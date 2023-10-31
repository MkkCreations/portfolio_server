package com.mkkcreations.portfolio_server.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Document(collection = "user")
@Data
public class User implements UserDetails {
    @Id
    String id;
    @NonNull
    private String name;
    @Indexed(unique = true)
    @NonNull
    private String username;
    @Indexed(unique = true)
    @NonNull
    private String email;
    @JsonIgnore
    private String password;
    @Nullable
    private String image;
    @Nullable
    private String bio;
    @Nullable
    private String resume;
    @Nullable
    private String location;
    @Nullable
    private String github;
    @Nullable
    private String linkedin;
    @Nullable
    private String number;
    @NonNull
    private String role;

    public User(String name, String username, String email, String password, String image, String bio, String resume, String location, String github, String linkedin, String number, String role) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.image = image;
        this.bio = bio;
        this.resume = resume;
        this.location = location;
        this.github = github;
        this.linkedin = linkedin;
        this.number = number;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return "ADMIN".equals(role) ? Collections.singletonList((GrantedAuthority) () -> "ROLE_ADMIN") : Collections.singletonList((GrantedAuthority) () -> "ROLE_USER");
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
