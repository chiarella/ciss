package br.com.ciss.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ciss.domain.Funcionario;
import br.com.ciss.service.FuncionarioService;

@RestController
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService service;
	


	@PostMapping(value = "/cadastrar")
	public void save(@RequestBody @Valid Funcionario funcionario) {
		service.save(funcionario);
	}
	
	@GetMapping(value = "/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="atualizar/{id}")
	public ResponseEntity<Funcionario>  update(@PathVariable("id") long id,
			@RequestBody @Valid Funcionario funcionario) {
		return service.findById(id)
				.map(altera -> {
					altera.setNome(funcionario.getNome());
					altera.setSobrenome(funcionario.getSobrenome());
					altera.setEmail(funcionario.getEmail());
					altera.setNumeroPis(funcionario.getNumeroPis());
					Funcionario updated = service.save(altera);
					return ResponseEntity.ok().body(updated);
		           }).orElse(ResponseEntity.notFound().build());
	}


	@GetMapping(value = "/funcionarios")
	public ResponseEntity<List<Funcionario>> buscaTodos() {
		return new ResponseEntity<List<Funcionario>>(service.getAll(), HttpStatus.OK);
	}


}
