package com.mkkcreations.portfolio_server.api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "skills")
@Data
public class Skill {
    @Id
    private String id;
    private String name;
    private String description;
    private String icon;

    public Skill(String id, String name, String description, String icon) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {this.id = id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {this.name = name;}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {this.description = description;}

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {this.icon = icon;}
}
