package controller;

import classes.Producer;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ProducerService;

@RestController
@RequestMapping("/api/producers")

/**
 *
 * @author kfrural
 */
public class ProducerController {
    private final ProducerService producerService;

    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping
    public Producer createProducer(@RequestBody Producer producer) {
        return (Producer) producerService.createProducer(producer);
    }

    @GetMapping
    public List<Producer> getAllProducers() {
        return (List<Producer>) producerService.getAllProducers();
    }

    @GetMapping("/{id}")
    public Producer getProducerById(@PathVariable Long id) {
        return (Producer) producerService.getProducerById(id);
    }

    @PutMapping("/{id}")
    public Producer updateProducer(@PathVariable Long id, @RequestBody Producer producer) {
        return (Producer) producerService.updateProducer(id, producer);
    }

    @DeleteMapping("/{id}")
    public void deleteProducer(@PathVariable Long id) {
        producerService.deleteProducer(id);
    }

    @GetMapping("/regiao/{regiao}")
    public List<Producer> getProducersByRegion(@PathVariable String regiao) {
        return (List<Producer>) producerService.getProducersByRegion(regiao);
    }

    public ProducerService getProducerService() {
        return producerService;
    }
    
}