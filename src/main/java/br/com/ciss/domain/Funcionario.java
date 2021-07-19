package br.com.ciss.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "funcionario")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// @NotBlank
	@Size(min = 2, max = 30, message = "Nome deve ter no minimo {min} caracteres e no máximo {max} caracteres. Você digitou: ${validatedValue}")
	private String nome;

	// @NotBlank 
	@Size(min = 2, max = 50, message = "Sobrenome deve ter no minimo {min} caracteres e no máximo {max} caracteres. Você digitou: ${validatedValue}")
	private String sobrenome;

	@Email(message = " ${validatedValue}: não é um email valido")
	private String email;
	
	private int numeroPis;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNumeroPis() {
		return numeroPis;
	}

	public void setNumeroPis(int numeroPis) {
		this.numeroPis = numeroPis;
	}

}
