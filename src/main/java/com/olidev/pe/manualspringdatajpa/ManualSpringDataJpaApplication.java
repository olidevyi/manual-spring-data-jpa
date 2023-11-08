package com.olidev.pe.manualspringdatajpa;

import com.olidev.pe.manualspringdatajpa.model.Client;
import com.olidev.pe.manualspringdatajpa.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Timestamp;
import java.util.List;

@SpringBootApplication
public class ManualSpringDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManualSpringDataJpaApplication.class, args);
    }

    @Bean // Se crea el Bean para evitar crear un controlador y un servicio ya que este es un proyecto de prueba
    CommandLineRunner commandLineRunner(ClientRepository clientRepository) {
        return args -> {
            // Agregar un registro
            Client client1 = new Client(
                    null,
                    "Oliver",
                    1,
                    new Timestamp(System.currentTimeMillis()),
                    "1234",
                    "jean.yantas@gmail.com"
                    );
            // Guardar el registro en la DB
            clientRepository.save(client1);
            // Buscar el registro con id 1 y guardarlo en un objeto
            Client client2 = clientRepository.findByIdAndActive(1l, 1);
            // Imprimir el objeto con el registro id=1
            System.out.println(client2.toString());

            // Guarda todos los registros en una lista
            List<Client> clientes = clientRepository.findAll();
            // Imprime la lista en consolaapp
            System.out.println(clientes.toString());
        };
    }
}
