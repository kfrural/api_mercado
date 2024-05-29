package jpa;

import classes.Producer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author kfrural
 */
public interface ProducerRepository extends JpaRepository<Producer, Long> {
    List<Producer> findByRegion(String regiao);
}
