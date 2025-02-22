package com.danielsonsiqueira.todosimple.repositories;

import com.danielsonsiqueira.todosimple.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
perquisar mais sobre o JpaRepository. basicamente ele ja tem metodos de buscas para serem utilizados
*/
@Repository
public interface UserRepositoty extends JpaRepository<User, Long> {

}
