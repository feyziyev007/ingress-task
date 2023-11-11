package az.ingress.ms10security.repository;

import az.ingress.ms10security.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

}
