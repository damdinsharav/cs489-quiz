package edu.miu.cs489.model;

public class PhoneNumber {
    String phoneNumber;
    String label;

    public PhoneNumber(String phoneNumber, String label) {
        this.phoneNumber = phoneNumber;
        this.label = label;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getLabel() {
        return label;
    }
}
