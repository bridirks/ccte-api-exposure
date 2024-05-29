package gov.epa.ccte.api.exposure.web.rest;

import gov.epa.ccte.api.exposure.domain.HttkData;
import gov.epa.ccte.api.exposure.repository.HttkDataRepository;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for getting the {@link gov.epa.ccte.api.exposure.domain.HttkData}s.
 */
@Tag(name = "Httk Data Resource",
        description = "API endpoints for httk data in exposure data.")
@SecurityRequirement(name = "api_key")
@Slf4j
@RestController
public class HttkDataResource {
    private final HttkDataRepository repository;

    public HttkDataResource(HttkDataRepository repository) {this.repository = repository;}
    @RequestMapping(value = "/exposure/httk/search/by-dtxsid/{dtxsid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    HttkData getHttkDataByDtxsid(@Parameter(required = true, description = "Httk Data by DTXSID", example = "DTXSID0027301") @PathVariable("dtxsid")String dtxsid) {
        log.debug("Httk Data by dtxsid = {}", dtxsid);

        return repository.findByDtxsid(dtxsid);

    }
}
