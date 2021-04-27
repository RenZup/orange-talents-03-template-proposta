package br.com.propostaot3.Proposta.proposta;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,nullable = false)
    private @NotBlank @Valid String documento;
    @Column(nullable = false)
    private @Email @NotBlank String email;
    @Column(nullable = false)
    private @NotBlank String nome;
    @Column(nullable = false)
    private @NotBlank String endereco;
    @Column(nullable = false)
    private @NotNull @Positive BigDecimal salario;
    @Enumerated(EnumType.STRING)
    private Status status = Status.NAO_AVALIADO;

    @Deprecated
    public Proposta() {
    }

    public Proposta(@NotBlank @Valid String documento, @Email @NotBlank String email, @NotBlank String nome, @NotBlank String endereco, @NotNull @Positive BigDecimal salario) {
        this.documento = documento;
        this.email = email;
        this.nome = nome;
        this.endereco = endereco;
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return "Proposta{" +
                "id=" + id +
                ", documento='" + documento + '\'' +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", salario=" + salario +
                '}';
    }

    public void setStatus(Status status){
        this.status = status;
    }
}
