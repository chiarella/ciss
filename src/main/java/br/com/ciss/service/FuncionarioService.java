package br.com.ciss.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ciss.domain.Funcionario;
import br.com.ciss.repository.FuncionarioRepository;

@Service
@Transactional
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repository;

	public Funcionario save(Funcionario funcionario) {
		return repository.save(funcionario);
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	public List<Funcionario> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	public Optional<Funcionario> findById(long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}
	
}
