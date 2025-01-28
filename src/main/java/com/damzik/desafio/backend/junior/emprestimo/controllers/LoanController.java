package com.damzik.desafio.backend.junior.emprestimo.controllers;

import com.damzik.desafio.backend.junior.emprestimo.dto.AnswerResponseDTO;
import com.damzik.desafio.backend.junior.emprestimo.dto.LoanResponseDTO;
import com.damzik.desafio.backend.junior.emprestimo.dto.UserRequestDTO;
import com.damzik.desafio.backend.junior.emprestimo.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/customer-loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping
    public Map<String, Object> getLoans(@RequestBody UserRequestDTO userRequestDTO){

        List<LoanResponseDTO> loanList = loanService.determineLoans(userRequestDTO);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("user",userRequestDTO.getName());
        response.put("loans",loanList);

        return response;
    }

    @PostMapping(value = "/teste")
    public AnswerResponseDTO getLoansDTO(@RequestBody UserRequestDTO userRequestDTO) {

        List<LoanResponseDTO> loanList = loanService.determineLoans(userRequestDTO);

        return new AnswerResponseDTO(userRequestDTO.getName(),loanList);
    }
}
