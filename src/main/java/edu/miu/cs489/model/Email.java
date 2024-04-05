package edu.miu.cs489.model;

public class Email {
    String email;
    String label;

    public Email(String email, String label) {
        this.email = email;
        this.label = label;
    }

    public String getEmail() {
        return email;
    }

    public String getLabel() {
        return label;
    }
}
