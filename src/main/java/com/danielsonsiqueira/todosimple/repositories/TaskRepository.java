package com.danielsonsiqueira.todosimple.repositories;

import com.danielsonsiqueira.todosimple.models.Task;
import com.danielsonsiqueira.todosimple.models.projection.TaskProjection;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List <TaskProjection> findByUser_Id (Long id);
    /*
    //Forma padrão do spring:

    List <Task> findByUser_Id (Long id);

    depois pesquisar essa forma (spql):

    @Query(value = "SELECT t FROM Task t WHERE t.user.id = :id")
    List <Task> findByUser_Id (@Param ("id") Long id);

     @Query(value = "SELECT * FROM task t WHERE t.user_id = :id", nativeQuery = true)
    List <Task> findByUser_Id (@Param ("id") Long id);

    */



}
