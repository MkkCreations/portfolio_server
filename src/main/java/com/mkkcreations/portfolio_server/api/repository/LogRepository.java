package com.mkkcreations.portfolio_server.api.repository;

import com.mkkcreations.portfolio_server.api.model.Log;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface LogRepository extends MongoRepository<Log, String> {
    Optional<Log> findByName(String name);
}
