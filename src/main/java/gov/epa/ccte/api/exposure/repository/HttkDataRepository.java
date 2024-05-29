package gov.epa.ccte.api.exposure.repository;

import gov.epa.ccte.api.exposure.domain.GenExpoPrediction;
import gov.epa.ccte.api.exposure.domain.HttkData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@SuppressWarnings("unused")
@RepositoryRestResource(exported = false)
public interface HttkDataRepository extends JpaRepository<HttkData, Integer> {
    HttkData findByDtxsid(String dtxsid);
}