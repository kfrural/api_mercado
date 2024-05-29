package controller;

import classes.Comprador;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.CompradorService;

@RestController
@RequestMapping("/api/compradores")

/**
 *
 * @author kfrural
 */
public class CompradorController {
    private final CompradorService compradorService;
    
    public CompradorController(CompradorService compradorService) {
        this.compradorService = compradorService;
    }

    @PostMapping
    public Comprador createComprador(@RequestBody Comprador comprador) {
        return (Comprador) compradorService.createComprador(comprador);
    }

    @GetMapping
    public List<Comprador> getAllCompradors() {
        return (List<Comprador>) compradorService.getAllCompradors();
    }

    @GetMapping("/{id}")
    public Comprador getCompradorById(@PathVariable Long id) {
        return (Comprador) compradorService.getCompradorById(id);
    }

    @PutMapping("/{id}")
    public Comprador updateComprador(@PathVariable Long id, @RequestBody Comprador comprador) {
        return (Comprador) compradorService.updateComprador(id, comprador);
    }

    @DeleteMapping("/{id}")
    public void deleteComprador(@PathVariable Long id) {
        compradorService.deleteComprador(id);
    }

    public CompradorService getCompradorService() {
        return compradorService;
    }
    
}
