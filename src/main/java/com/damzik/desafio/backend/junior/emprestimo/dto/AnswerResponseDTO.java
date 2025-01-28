package com.damzik.desafio.backend.junior.emprestimo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AnswerResponseDTO {

    private String userName;
    private List<LoanResponseDTO> loanList;

    public AnswerResponseDTO(String username, List<LoanResponseDTO> loanList){
        this.userName = username;
        this.loanList = loanList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<LoanResponseDTO> getLoanList() {
        return loanList;
    }

    public void setLoanList(List<LoanResponseDTO> loanList) {
        this.loanList = loanList;
    }
}
