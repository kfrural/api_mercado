package controller;

import classes.Vendedor;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.VendedorService;

@RestController
@RequestMapping("/api/vendedores")

/**
 *
 * @author kfrural
 */
public class VendedorController {
    private final VendedorService vendedorService;

    public VendedorController(VendedorService vendedorService) {
        this.vendedorService = vendedorService;
    }

    @PostMapping
    public Vendedor createVendedor(@RequestBody Vendedor vendedor) {
        return (Vendedor) vendedorService.createVendedor(vendedor);
    }

    @GetMapping
    public List<Vendedor> getAllVendedors() {
        return (List<Vendedor>) vendedorService.getAllVendedors();
    }

    @GetMapping("/{id}")
    public Vendedor getVendedorById(@PathVariable Long id) {
        return (Vendedor) vendedorService.getVendedorById(id);
    }

    @PutMapping("/{id}")
    public Vendedor updateVendedor(@PathVariable Long id, @RequestBody Vendedor vendedor) {
        return (Vendedor) vendedorService.updateVendedor(id, vendedor);
    }

    @DeleteMapping("/{id}")
    public void deleteVendedor(@PathVariable Long id) {
        vendedorService.deleteVendedor(id);
    }

    public VendedorService getVendedorService() {
        return vendedorService;
    }
    
}

