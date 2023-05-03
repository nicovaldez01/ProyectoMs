package LegajosMsalud.Repository;

import LegajosMsalud.Model.Legajos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ILegajosRepository extends JpaRepository<Legajos, Long> {
    Optional<Legajos> findBydni(Long dni);
}
