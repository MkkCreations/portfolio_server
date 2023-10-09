package com.mkkcreations.portfolio_server.api.rest;

import com.mkkcreations.portfolio_server.api.model.Log;
import com.mkkcreations.portfolio_server.api.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/logs")
@CrossOrigin(origins = "http://localhost:3000")
public class LogREST {
    @Autowired
    LogService logService;

    @GetMapping
    public List<Log> getLogs() {
        return logService.getAllLogs();
    }

}
