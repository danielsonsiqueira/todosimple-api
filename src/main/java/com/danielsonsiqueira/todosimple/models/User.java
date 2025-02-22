package com.danielsonsiqueira.todosimple.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;

/*

@Entity (usando JPA/Hibernate) indica que a classe Java
é uma entidade gerenciada pelo JPA e será mapeada para uma tabela no banco de dados.

@Column é usada pra gerar as configurações de tabela no banco de dados.

*/
@Entity
@Table(name = "user")
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

    //private List<Task> tasks = new ArrayList<Task>();


    public User() {
    }

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //verifica se o objeto é igual em todos os casos abaixo (garantia de que é o mesmo usuario)
    public boolean equals(Object obj){

        if(obj == this)
            return true;
        if(obj == null)
            return false;
        if(!(obj instanceof User))
            return false;

        User other = (User) obj;

        if(this.id == null)
            if(other.id != null)
                return false;
        else if(!this.id.equals(other.id))
            return false;
        return Objects.equals(this.id, other.id)
                && Objects.equals(this.username, other.username)
                && Objects.equals(this.password, other.password);

    }

    //verificador de valor unico para o id
    public int hashCode(){

        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        return result;
    }

}
