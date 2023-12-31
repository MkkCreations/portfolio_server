package com.mkkcreations.portfolio_server.api.model;

import jakarta.annotation.Nullable;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.List;

@Document(collection = "projects")
@Data
public class Project {
    @Id
    private String id;
    private String title;
    private String description;
    private List<String> stack;
    private List<String> images;
    @Nullable
    private String url;
    @Nullable
    private String github;
    private Date createdAt;
    private Date updatedAt;

    public Project(String id, String title, String description, List<String> stack, List<String> images, String url, String github, Date createdAt, Date updatedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.stack = stack;
        this.images = images;
        this.url = url;
        this.github = github;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {this.description = description;}

    public List<String> getStack() {
        return stack;
    }

    public void setStack(List<String> stack) {
        this.stack = stack;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getUrl() {return url;}

    public void setUrl(String url) {this.url = url;}

    public String getGithub() {return github;}

    public void setGithub(String github) {this.github = github;}

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
