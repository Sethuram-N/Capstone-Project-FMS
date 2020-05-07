package com.capstone.feedBackdatasetup.repository;

import com.capstone.feedBackdatasetup.entity.OutreachEventInformation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OutreachEventInformationRepository extends MongoRepository<OutreachEventInformation, Integer> {
}
