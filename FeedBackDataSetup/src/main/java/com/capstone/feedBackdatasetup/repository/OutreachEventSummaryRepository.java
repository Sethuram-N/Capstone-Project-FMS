package com.capstone.feedBackdatasetup.repository;

import com.capstone.feedBackdatasetup.entity.OutreachEventSummary;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OutreachEventSummaryRepository extends MongoRepository<OutreachEventSummary, Integer> {
}
