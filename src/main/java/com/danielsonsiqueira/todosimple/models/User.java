package com.danielsonsiqueira.todosimple.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;

/*

@Entity (usando JPA/Hibernate) indica que a classe Java
é uma entidade gerenciada pelo JPA e será mapeada para uma tabela no banco de dados.

@Column é usada pra gerar as configurações de tabela no banco de dados.

*/
@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class User {

    public interface CreateUser{}

    public interface UpdateUser{}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "username", unique = true, nullable = false, length = 100)
    @NotNull(groups = CreateUser.class)
    @NotEmpty(groups = CreateUser.class)
    @Size(min = 3, max = 100)
    private String username;

    @JsonProperty(access = WRITE_ONLY)
    @Column(name = "password", nullable = false, length = 60)
    @NotNull(groups = {CreateUser.class, UpdateUser.class})
    @NotEmpty(groups = {CreateUser.class, UpdateUser.class})
    @Size(groups = {CreateUser.class, UpdateUser.class}, min = 8, max = 60)
    private String password;

    /*

    @OneToMany está vinculado a classe User com a anotação @ManyToOne de lá.
    o mappedBy precisa receber o nome da variável da classe Task nesse caso que é a variavel user.

    */
    @OneToMany(mappedBy = "user")
    @JsonProperty(access = WRITE_ONLY)
    private List<Task> tasks = new ArrayList<Task>();

}
