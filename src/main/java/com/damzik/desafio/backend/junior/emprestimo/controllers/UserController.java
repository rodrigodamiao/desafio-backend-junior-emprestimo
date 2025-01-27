package com.damzik.desafio.backend.junior.emprestimo.controllers;

import com.damzik.desafio.backend.junior.emprestimo.entities.Loan;
import com.damzik.desafio.backend.junior.emprestimo.entities.User;
import com.damzik.desafio.backend.junior.emprestimo.exceptions.ResourceNotFoundException;
import com.damzik.desafio.backend.junior.emprestimo.repositories.UserRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/customer-loans")
    public User insertUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping(value = "/customer-loans/{id}")
    public List<Loan> findById(@PathVariable Long id){
        // Pessoal (income <= 3000 OU income >= 3000 && income <= 5000 && age < 30 && location == "SP")
        // Consignado (income >= 5000)
        // Garantia (income <= 3000 OU income >= 3000 && income <= 5000 && age < 30 && location == "SP")

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        ArrayList<Loan> loanList = new ArrayList<>();

        //Pessoal
        if((user.getIncome() <= 3000) || (user.getIncome() >= 3000 && user.getIncome() <= 5000 && user.getAge() < 30 && user.getLocation().equals("SP"))){
            loanList.add(new Loan("PERSONAL",4));
        }

        //Consignado
        if((user.getIncome() >= 5000)){
            loanList.add(new Loan("CONSIGNMENT",2));
        }

        //Garantia
        if((user.getIncome() <= 3000) || (user.getIncome() >= 3000 && user.getIncome() <= 5000 && user.getAge() < 30 && user.getLocation().equals("SP"))){
            loanList.add(new Loan("GUARANTEED",3));
        }

        return loanList;
    }

    @GetMapping(value = "/customer-loans")
    public List<User> findUsers(){
        return userRepository.findAll();
    }

    /*
    Conceder o empréstimo pessoal se o salário do cliente for igual ou inferior a R$ 3000.
    Conceder o empréstimo pessoal se o salário do cliente estiver entre R$ 3000 e R$ 5000, se o cliente tiver menos de 30 anos e residir em São Paulo (SP).
    Conceder o empréstimo consignado se o salário do cliente for igual ou superior a R$ 5000.
    Conceder o empréstimo com garantia se o salário do cliente for igual ou inferior a R$ 3000.
    Conceder o empréstimo com garantia se o salário do cliente estiver entre R$ 3000 e R$ 5000, se o cliente tiver menos de 30 anos e residir em São Paulo (SP).*/

}
