package com.mkkcreations.portfolio_server.api.service;

import com.mkkcreations.portfolio_server.api.model.Log;
import com.mkkcreations.portfolio_server.api.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class LogService {
    @Autowired
    private LogRepository logRepository;

    public void createLog(String name, String operation) {
        Map<String, String> data = Map.of("info", operation, "date", new Date().toString());
        Log log = new Log( null, name, List.of(data));
        if (logRepository.findByName(name).isPresent()) {
            log = logRepository.findByName(name).get();
            List<Object> operations = log.getOperations();
            operations.add(data);
            log.setOperations(operations);
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
