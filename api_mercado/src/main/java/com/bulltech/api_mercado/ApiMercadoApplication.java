package com.bulltech.api_mercado;

import classes.Comprador;
import classes.Producer;
import classes.Vendedor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiMercadoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiMercadoApplication.class, args);

        Comprador comprador = new Comprador();
        comprador.setName("João");
        comprador.setEmail("joao@gmail.com");
        comprador.setPassword("123");

        Producer producer = new Producer();
        producer.setNome("João");
        producer.setRegiao("São Paulo");
        producer.setQtd(10);
        producer.setContato("joao@exemplo.com");
        producer.setValor(100.0);
        producer.setDescricao("So compro acima de 14 arrobas");

        Vendedor vendedor = new Vendedor();
        vendedor.setName("João");
        vendedor.setEmail("joao@exemplo.com");
        vendedor.setPassword("senha123");

    }
}
