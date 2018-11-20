package com.TT.demo.domain.mysql.spring;

import javax.persistence.*;

@Table(name = "kkk")
public class Kkk {
    private String kkk;

    private String asdfas;

    /**
     * @return kkk
     */
    public String getKkk() {
        return kkk;
    }

    /**
     * @param kkk
     */
    public void setKkk(String kkk) {
        this.kkk = kkk == null ? null : kkk.trim();
    }

    /**
     * @return asdfas
     */
    public String getAsdfas() {
        return asdfas;
    }

    /**
     * @param asdfas
     */
    public void setAsdfas(String asdfas) {
        this.asdfas = asdfas == null ? null : asdfas.trim();
    }
}