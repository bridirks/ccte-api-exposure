package gov.epa.ccte.api.exposure.repository;

import gov.epa.ccte.api.exposure.domain.GenExpoPrediction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@SuppressWarnings("unused")
@RepositoryRestResource(exported = false)
public interface GenExpoPredictionRepository extends JpaRepository<GenExpoPrediction, String> {

    GenExpoPrediction findByDtxsid(String dtxsid);
}