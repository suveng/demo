package com.tt.demo.util.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by 苏文广 on 2018/11/20
 */
@Data
public class Mail implements Serializable {
    private String from;
    private String to;
    private String subject;
    private String content;

    public Mail(String to, String subject, String content) {
        this.to = to;
        this.subject = subject;
        this.content = content;
    }

    public Mail() {
    }
}
