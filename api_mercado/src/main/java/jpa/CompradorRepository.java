package jpa;

import classes.Comprador;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author kfrural
 */
public interface CompradorRepository extends JpaRepository<Comprador, Long> {
}
