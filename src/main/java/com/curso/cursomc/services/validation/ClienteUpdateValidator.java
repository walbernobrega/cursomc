package com.curso.cursomc.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.curso.cursomc.domain.Cliente;
import com.curso.cursomc.dto.ClienteDTO;
import com.curso.cursomc.repositories.ClienteRepository;
import com.curso.cursomc.resources.exception.FieldMessage;

public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteDTO> {
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private ClienteRepository repo;
	
	@Override
	public void initialize(ClienteUpdate ann) {

	}

	@Override
	public boolean isValid(ClienteDTO objDTO, ConstraintValidatorContext context) {
		
		// Método para pegar o id do cliente na URL ex: http://localhost:8080/clientes/1
		// Traz o id = 1
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));

		List<FieldMessage> list = new ArrayList<>();
		
		Cliente aux = repo.findByEmail(objDTO.getEmail());
		
		if (aux != null && !aux.getId().equals(uriId))  {
			list.add(new FieldMessage("email","Email já cadastrado"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}

		return list.isEmpty();

	}

}
