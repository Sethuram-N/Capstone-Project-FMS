package com.capstone.fmsconfig.service;

import com.capstone.fmsconfig.dto.EditQuestionRequestDTO;
import com.capstone.fmsconfig.dto.QuestionDTO;
import com.capstone.fmsconfig.dto.QuestionRequestDTO;
import com.capstone.fmsconfig.dto.QuestionResponseDTO;
import com.capstone.fmsconfig.entity.Answer;
import com.capstone.fmsconfig.entity.Question;
import com.capstone.fmsconfig.repository.AnswerRepository;
import com.capstone.fmsconfig.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    DatabaseClient databaseClient;

    public Mono<Void> createQuestion(QuestionRequestDTO questionRequestDTO) {

        Mono<Void> voidMono = Mono.empty();
        Question question = mapQuestionRequestDTO(questionRequestDTO);

        if(!CollectionUtils.isEmpty(questionRequestDTO.getAnswers())) {
                Mono<Question> questionMono = questionRepository.save(question);
                voidMono = questionMono.map(Question::getQuestionId).
                        flatMap(value -> createAnswers(value, questionRequestDTO.getAnswers())).then();

        }else {
            voidMono = questionRepository.save(question).then();
        }
        return voidMono;
    }

    public Flux<QuestionResponseDTO> getAllQuestions() {
                Flux<QuestionResponseDTO> responseDTOFlux = databaseClient.execute().sql(
                        "select q.questionid, q.questiondescription, q.feedbacktype, count(a.answerid) as totalanswers from question q left outer join answer a on q.questionid=a.questionid group by q.questionid;")
                        .as(QuestionResponseDTO.class).fetch().all();
            return responseDTOFlux;
    }

    public Flux<QuestionDTO> getQuestionById(Integer questionId) {
        Flux<QuestionDTO> responseQuestionDTO = databaseClient.execute().sql(
       "select q.questionID, q,questionDescription, q.feedbackType, q.answerType, a.answerID, a.answerText from Question q left outer join Answer a on q.questionID = a.questionID and q.questionID = :questionID" )
                .bind("questionID", questionId).as(QuestionDTO.class).fetch().all();
        return responseQuestionDTO;
    }

    public Mono<Question> editQuestion(EditQuestionRequestDTO editQuestionRequestDTO) {

        Mono<Question> questionMono = null;

        if(Optional.ofNullable(editQuestionRequestDTO.getQuestion()).isPresent()) {
           questionMono = questionRepository.save(editQuestionRequestDTO.getQuestion());
        }
        if(!CollectionUtils.isEmpty(editQuestionRequestDTO.getAnswers())) {
            answerRepository.saveAll(editQuestionRequestDTO.getAnswers()).subscribe();
        }
        return questionMono;
    }

    public Mono<Void> deleteQuestionById(Integer questionId) {
            answerRepository.deleteByQuestionId(questionId).subscribe();
            return questionRepository.deleteById(questionId);
    }

    private Question mapQuestionRequestDTO(QuestionRequestDTO questionRequestDTO) {
        Question question = new Question();
        question.setFeedbackType(questionRequestDTO.getFeedbackType());
        question.setAnswerType(questionRequestDTO.getAnswerType());
        question.setQuestionDescription(questionRequestDTO.getQuestionDescription());
        return question;
    }

    private Mono<Void> createAnswers(Integer value, List<String> answers) {
        List<Answer> answerList = new ArrayList<>();
        Mono<Void> voidMono = Mono.empty();

        answers.forEach(ans -> {
            Answer answer = new Answer();
            answer.setAnswerId(null);
            answer.setQuestionId(value);
            answer.setAnswerText(ans);
            answerList.add(answer);
        });
        voidMono = answerRepository.saveAll(answerList).then();
        return voidMono;
    }
}
