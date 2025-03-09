package com.danielsonsiqueira.todosimple.repositories;

import com.danielsonsiqueira.todosimple.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/*
perquisar mais sobre o JpaRepository. basicamente ele ja tem metodos de buscas para serem utilizados
*/
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional(readOnly = true)
    User findByUsername(String username);

}
