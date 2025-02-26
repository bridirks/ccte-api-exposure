package gov.epa.ccte.api.exposure.repository;

import java.util.List;

import org.hibernate.query.spi.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import gov.epa.ccte.api.exposure.domain.MMDBAggregate;
import gov.epa.ccte.api.exposure.domain.MMDBSingleSample;

@SuppressWarnings("unused")
@RepositoryRestResource(exported = false)
public interface MMDBSingleSampleRepository extends JpaRepository<MMDBSingleSample, Integer> {

    @Transactional(readOnly = true)
    List<MMDBSingleSample> findByDtxsid(String dtxside);

    @Transactional(readOnly = true)
    List<MMDBSingleSample> findByHarmonizedMedium(String medium, org.springframework.data.domain.Limit limit);

}
