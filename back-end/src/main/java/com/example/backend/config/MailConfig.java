package com.example.backend.config;

import lombok.Getter;

import java.util.Random;

public class MailConfig {

    public String company = "Five Start";

    public String contact = "ndq1234pn@gmail.com";

    public String confirmMail = "Mã Xác Nhận Cho Tài Khoản Của Bạn";

    public String randomCode() {
        Random random = new Random();
        int min = 100000;
        int max = 999999;
        int randomNumber = random.nextInt(max - min + 1) + min;
        return String.format("%06d", randomNumber);
    }

}

