package gov.epa.ccte.api.exposure.repository;

import java.util.List;

import org.hibernate.query.spi.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import gov.epa.ccte.api.exposure.domain.MMDBAggregate;
@SuppressWarnings("unused")
@RepositoryRestResource(exported = false)
public interface MMDBAggregateRepository extends JpaRepository<MMDBAggregate, Integer> {

    @Transactional(readOnly = true)
    List<MMDBAggregate> findByDtxsid(String dtxsid);

    @Transactional(readOnly = true)
    List<MMDBAggregate> findByHarmonizedMedium(String medium, org.springframework.data.domain.Limit limit);
}