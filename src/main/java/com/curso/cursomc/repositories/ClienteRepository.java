package com.curso.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.curso.cursomc.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
	// Se o nome do método for findBy<coluna de pesquisa> o Spring vai fazer a pesquisa automaticamente
	// O Transactional com readOnly=true implica que não vai haver bloqueio no banco de dados e a pesquisa fica mais rápida
	
	@Transactional(readOnly=true)
	Cliente findByEmail(String email);

}
