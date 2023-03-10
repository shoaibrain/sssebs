package com.sssebs.server.service;

import com.sssebs.server.model.DbSequence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Objects;

@Service
public class DbSequenceGeneratorService {
    private static Logger logger = LogManager.getLogger(DbSequenceGeneratorService.class);

    @Autowired
    private MongoOperations mongoOperations;

    public long generateSequence(String seqName) {
        DbSequence counter = mongoOperations.findAndModify(query(where("id").is(seqName)),
                new Update().inc("seq",1), options().returnNew(true).upsert(true),
                DbSequence.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;
    }
}
