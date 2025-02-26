package com.danielsonsiqueira.todosimple.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

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
