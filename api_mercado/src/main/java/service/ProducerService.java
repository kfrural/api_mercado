package service;

import classes.Producer;
import java.util.List;
import jpa.ProducerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service

/**
 *
 * @author kfrural
 */

public class ProducerService {
    private final ProducerRepository producerRepository;

    public ProducerService(ProducerRepository producerRepository) {
        this.producerRepository = producerRepository;
    }

    public Producer createProducer(Producer producer) {
        return producerRepository.save(producer);
    }

    public List<Producer> getAllProducers() {
        return producerRepository.findAll();
    }

    public Producer getProducerById(Long id) {
        return producerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producer not found with id: " + id));
    }

    public Producer updateProducer(Long id, Producer updatedProducer) {
        Producer producer = getProducerById(id);
        producer.setNome(updatedProducer.getNome());
        producer.setRegiao(updatedProducer.getRegiao());
        producer.setQtd(updatedProducer.getQtd());
        producer.setContato(updatedProducer.getContato());
        producer.setValor(updatedProducer.getValor());
        producer.setDescricao(updatedProducer.getDescricao());
        return producerRepository.save(producer);
    }

    public void deleteProducer(Long id) {
        Producer producer = getProducerById(id);
        producerRepository.delete(producer);
    }

    public List<Producer> getProducersByRegion(String regiao) {
        return producerRepository.findByRegion(regiao);
    }

    public ProducerRepository getProducerRepository() {
        return producerRepository;
    }
}
