package gov.epa.ccte.api.exposure.web.rest;

import gov.epa.ccte.api.exposure.domain.FunctionalUseCategory;
import gov.epa.ccte.api.exposure.projection.FunctionalUseAll;
import gov.epa.ccte.api.exposure.repository.FunctionalUseCategoryRepository;
import gov.epa.ccte.api.exposure.repository.FunctionalUseRepository;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for getting the {@link gov.epa.ccte.api.exposure.domain.FunctionalUse}s.
 */
@Tag(name = "Functional Use Resource",
        description = "API endpoints for functional use in exposure data.")
@SecurityRequirement(name = "api_key")
@Slf4j
@RestController
public class FunctionalUseResource {

        private final FunctionalUseRepository repository;
        private final FunctionalUseCategoryRepository categoryRepository;

    public FunctionalUseResource(FunctionalUseRepository repository, FunctionalUseCategoryRepository categoryRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping(value = "exposure/functional-use/search/by-dtxsid/{dtxsid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<FunctionalUseAll> getFunctionalUseByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0020232") @PathVariable("dtxsid")String dtxsid) {
        log.debug("all functional use for dtxsid = {}", dtxsid);

        List<FunctionalUseAll> data = repository.findByDtxsid(dtxsid, FunctionalUseAll.class);

        return data;
    }

    @RequestMapping(value = "exposure/functional-use/category", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<FunctionalUseCategory> getFunctionalUseCategory(){
        log.debug("all functional use category");
        List<FunctionalUseCategory> data = categoryRepository.findAll();
        return data;
    }
}
