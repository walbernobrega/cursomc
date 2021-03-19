package com.curso.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.cursomc.domain.Categoria;
import com.curso.cursomc.domain.Cidade;
import com.curso.cursomc.domain.Cliente;
import com.curso.cursomc.domain.Endereco;
import com.curso.cursomc.domain.Estado;
import com.curso.cursomc.domain.ItemPedido;
import com.curso.cursomc.domain.Pagamento;
import com.curso.cursomc.domain.PagamentoComBoleto;
import com.curso.cursomc.domain.PagamentoComCartao;
import com.curso.cursomc.domain.Pedido;
import com.curso.cursomc.domain.Produto;
import com.curso.cursomc.domain.enums.EstadoPagamento;
import com.curso.cursomc.domain.enums.TipoCliente;
import com.curso.cursomc.repositories.CategoriaRepository;
import com.curso.cursomc.repositories.CidadeRepository;
import com.curso.cursomc.repositories.ClienteRepository;
import com.curso.cursomc.repositories.EnderecoRepository;
import com.curso.cursomc.repositories.EstadoRepository;
import com.curso.cursomc.repositories.ItemPedidoRepository;
import com.curso.cursomc.repositories.PagamentoRepository;
import com.curso.cursomc.repositories.PedidoRepository;
import com.curso.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}

}
