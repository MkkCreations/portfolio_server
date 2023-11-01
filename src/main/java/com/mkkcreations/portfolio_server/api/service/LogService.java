package com.mkkcreations.portfolio_server.api.service;

import com.mkkcreations.portfolio_server.api.model.Log;
import com.mkkcreations.portfolio_server.api.repository.LogRepository;
import com.mongodb.lang.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class LogService {
    @Autowired
    private LogRepository logRepository;

    public void createLog(String name, String operation, Map<String, String> data) {
        Log log = new Log();
        Map<String, Object> logData = Map.of(
                "name", name,
                "info", operation,
                "data", data,
                "date", new Date().toString());
        log.setName(name);

        if (logRepository.findByName(name).isPresent()) {
            log = logRepository.findByName(name).get();
            List<Object> operations = log.getOperations();
            operations.add(logData);
            log.setOperations(operations);
        } else {
            log.setOperations(List.of(logData));
        }
        logRepository.save(log);
    }

    public void deleteLog(String id) {
        logRepository.deleteById(id);
    }

    public void deleteAllLogs() {
        logRepository.deleteAll();
    }

    public List<Log> getAllLogs() {
        return logRepository.findAll();
    }

}
