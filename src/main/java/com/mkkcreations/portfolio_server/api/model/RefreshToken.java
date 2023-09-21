package com.mkkcreations.portfolio_server.api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "refresh_tokens")
@Data
public class RefreshToken {
    @Id
    String id;
    @DocumentReference(lazy = true)
    private User owner;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id != null)
            this.id = id;
    }
}
