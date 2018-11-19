package com.TT.demo.util.properties;

import org.springframework.stereotype.Component;

@Component
public class TestProperties {
//    @Value("${com.neo.description}")
    private String description;
//    @Value("${com.neo.email}")
    private String email;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
