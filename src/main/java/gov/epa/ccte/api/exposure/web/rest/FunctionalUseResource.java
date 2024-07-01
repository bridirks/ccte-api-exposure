package gov.epa.ccte.api.exposure.web.rest;

import gov.epa.ccte.api.exposure.domain.FunctionalUseCategory;
import gov.epa.ccte.api.exposure.projection.QsurDataAll;
import gov.epa.ccte.api.exposure.projection.FunctionalUseAll;
import gov.epa.ccte.api.exposure.repository.FunctionalUseCategoryRepository;
import gov.epa.ccte.api.exposure.repository.FunctionalUseRepository;
import gov.epa.ccte.api.exposure.repository.QsurDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class FunctionalUseResource implements FunctionalUseApi {

        private final FunctionalUseRepository repository;
        private final FunctionalUseCategoryRepository categoryRepository;
        private final QsurDataRepository qsurDataRepository;

    public FunctionalUseResource(FunctionalUseRepository repository, FunctionalUseCategoryRepository categoryRepository, QsurDataRepository qsurDataRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
        this.qsurDataRepository = qsurDataRepository;
    }

    @Override
    public List<FunctionalUseAll> getFunctionalUseByDtxsid(String dtxsid) {
        log.debug("all functional use for dtxsid = {}", dtxsid);

        List<FunctionalUseAll> data = repository.findByDtxsid(dtxsid, FunctionalUseAll.class);

        return data;
    }

    @Override
    public List<FunctionalUseCategory> getFunctionalUseCategory(){
        log.debug("all functional use category");
        List<FunctionalUseCategory> data = categoryRepository.findAll();
        return data;
    }

    @Override
    public List<QsurDataAll> getFunctionalUseProbabilityByDtxsid(String dtxsid) {
        log.debug("all functional use probability for dtxsid = {}", dtxsid);

        List<QsurDataAll> data = qsurDataRepository.findByDtxsidOrderByHarmonizedFunctionalUseAsc(dtxsid, QsurDataAll.class);

        return data;
    }
}
