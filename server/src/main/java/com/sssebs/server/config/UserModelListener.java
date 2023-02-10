package com.sssebs.server.config;

import com.sssebs.server.model.User;
import com.sssebs.server.service.DbSequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;

@Configuration
public class UserModelListener extends AbstractMongoEventListener<User> {
    @Autowired
    DbSequenceGeneratorService dbSequenceGeneratorService;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<User> event) {
        if (event.getSource().getId() < 1) {
            event.getSource().setId(dbSequenceGeneratorService.generateSequence(User.SEQUENCE_NAME));
        }
    }
}
