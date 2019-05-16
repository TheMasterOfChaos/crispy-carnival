package com.example.testname.specialClasses;

public class SMSRequest {
    String phone_number;
    String code;

    public SMSRequest(String phone_number, String code) {
        this.phone_number = phone_number;
        this.code = code;
    }
}
