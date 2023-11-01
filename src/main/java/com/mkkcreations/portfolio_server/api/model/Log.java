package com.mkkcreations.portfolio_server.api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Document(collection = "logs")
@Data
public class Log {
    @Id
    private String id;
    private String name;
    private List<Object> operations;

    public Log(String id, String name, List<Object> operations) {
        this.id = id;
        this.name = name;
        this.operations = operations;
    }

    public Log() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Object> getOperations() {
        return operations;
    }

    public void setOperations(List<Object> operations) {
        this.operations = operations;
    }
}
