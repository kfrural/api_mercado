package service;

import classes.Comprador;
import java.util.List;
import jpa.CompradorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CompradorService {
    private final CompradorRepository compradorRepository;

    public CompradorService(CompradorRepository compradorRepository) {
        this.compradorRepository = compradorRepository;
    }

    public Comprador createComprador(Comprador comprador) {
        return compradorRepository.save(comprador);
    }

    public List<Comprador> getAllCompradors() {
        return compradorRepository.findAll();
    }

    public Comprador getCompradorById(Long id) {
        return compradorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Comprador not found with id: " + id));
    }

    public Comprador updateComprador(Long id, Comprador updatedComprador) {
        Comprador comprador = getCompradorById(id);
        comprador.setName(updatedComprador.getName());
        comprador.setEmail(updatedComprador.getEmail());
        comprador.setPassword(updatedComprador.getPassword());
        return compradorRepository.save(comprador);
    }

    public void deleteComprador(Long id) {
        Comprador comprador = getCompradorById(id);
        compradorRepository.delete(comprador);
    }

    public CompradorRepository getCompradorRepository() {
        return compradorRepository;
    }
}
