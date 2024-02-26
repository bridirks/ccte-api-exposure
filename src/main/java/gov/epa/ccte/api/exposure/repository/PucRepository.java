package gov.epa.ccte.api.exposure.repository;

import gov.epa.ccte.api.exposure.domain.Puc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@SuppressWarnings("unused")
@RepositoryRestResource(exported = false)
public interface PucRepository extends JpaRepository<Puc, Long> {
}