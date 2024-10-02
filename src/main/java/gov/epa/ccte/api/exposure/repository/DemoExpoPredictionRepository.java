package gov.epa.ccte.api.exposure.repository;

import gov.epa.ccte.api.exposure.domain.DemoExpoPrediction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@SuppressWarnings("unused")
@RepositoryRestResource(exported = false)
public interface DemoExpoPredictionRepository extends JpaRepository<DemoExpoPrediction, Integer> {

    List<DemoExpoPrediction> findByDtxsid(String dtxsid);

    <T> List<T> findByDtxsidInOrderByDtxsidAsc(String[] dtxsids, Class<T> type);

}