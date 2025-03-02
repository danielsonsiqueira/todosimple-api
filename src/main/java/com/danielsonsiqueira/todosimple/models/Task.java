package com.danielsonsiqueira.todosimple.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "task")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    /*
    @ManyToOne nesse contexto quer dizer várias Tasks(classe) para um usuario (User abaixo)

    @JoinToColumn Especifica que a chave estrangeira na tabela referenciará a chave primária da entidade User
    fazer assim por boas praticas
    */

    @ManyToOne
    @JoinColumn (name = "user_id", nullable = false, updatable = false)
    private User user;
    @Column(name = "description", length = 255, nullable = false)
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 255)
    private String description;

}
