package service;

import classes.Vendedor;
import java.util.List;
import jpa.VendedorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service

/**
 *
 * @author kfrural
 */
public class VendedorService {
    private final VendedorRepository vendedorRepository;

    public VendedorService(VendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }

    public Vendedor createVendedor(Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }

    public List<Vendedor> getAllVendedors() {
        return vendedorRepository.findAll();
    }

    public Vendedor getVendedorById(Long id) {
        return vendedorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vendedor not found with id: " + id));
    }

    public Vendedor updateVendedor(Long id, Vendedor updatedVendedor) {
        Vendedor vendedor = getVendedorById(id);
        vendedor.setName(updatedVendedor.getName());
        vendedor.setEmail(updatedVendedor.getEmail());
        vendedor.setPassword(updatedVendedor.getPassword());
        return vendedorRepository.save(vendedor);
    }

    public void deleteVendedor(Long id) {
        Vendedor vendedor = getVendedorById(id);
        vendedorRepository.delete(vendedor);
    }

    public VendedorRepository getVendedorRepository() {
        return vendedorRepository;
    }
    
}
