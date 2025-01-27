package com.damzik.desafio.backend.junior.emprestimo.entities;

import jakarta.persistence.Entity;

public class Loan {
    private String type;
    private Integer interest_rate;

    public Loan(String type, Integer interest_rate) {
        this.type = type;
        this.interest_rate = interest_rate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(Integer interest_rate) {
        this.interest_rate = interest_rate;
    }
}
