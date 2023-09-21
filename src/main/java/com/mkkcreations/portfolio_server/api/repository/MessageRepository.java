package com.mkkcreations.portfolio_server.api.repository;

import com.mkkcreations.portfolio_server.api.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends MongoRepository<Message, String> {
}
