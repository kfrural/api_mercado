package jpa;

import classes.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author kfrural
 */
public interface VendedorRepository extends JpaRepository<Vendedor, Long> {}
