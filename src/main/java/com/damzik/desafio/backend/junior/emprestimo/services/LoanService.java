package com.damzik.desafio.backend.junior.emprestimo.services;

import com.damzik.desafio.backend.junior.emprestimo.dto.LoanResponseDTO;
import com.damzik.desafio.backend.junior.emprestimo.dto.UserRequestDTO;
import com.damzik.desafio.backend.junior.emprestimo.entities.Loan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {
    public List<LoanResponseDTO> determineLoans(UserRequestDTO userRequestDTO){

        int age = userRequestDTO.getAge();
        double income = userRequestDTO.getIncome();
        String location = userRequestDTO.getLocation();

        List<LoanResponseDTO> loanList = new ArrayList<>();

        //Pessoal
        if((income <= 3000) || (income >= 3000 && income <= 5000 && age < 30 && location.equals("SP"))){
            loanList.add(new LoanResponseDTO("PERSONAL",4));
        }
        //Consignado
        if((income >= 5000)){
            loanList.add(new LoanResponseDTO("CONSIGNMENT",2));
        }
        //Garantia
        if((income <= 3000) || (income >= 3000 && income <= 5000 && age < 30 && location.equals("SP"))){
            loanList.add(new LoanResponseDTO("GUARANTEED",3));
        }

        return loanList;
    }
}
