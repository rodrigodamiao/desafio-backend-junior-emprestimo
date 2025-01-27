package com.damzik.desafio.backend.junior.emprestimo.repositories;

import com.damzik.desafio.backend.junior.emprestimo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
