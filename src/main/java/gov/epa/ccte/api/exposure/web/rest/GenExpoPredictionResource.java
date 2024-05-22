package gov.epa.ccte.api.exposure.web.rest;

import gov.epa.ccte.api.exposure.domain.DemoExpoPrediction;
import gov.epa.ccte.api.exposure.domain.GenExpoPrediction;
import gov.epa.ccte.api.exposure.repository.DemoExpoPredictionRepository;
import gov.epa.ccte.api.exposure.repository.GenExpoPredictionRepository;
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
 * REST controller for getting the {@link gov.epa.ccte.api.exposure.domain.DemoExpoPrediction}s.
 */
@Tag(name = "General Exposure Prediction Resource",
        description = "API endpoints for general prediction in exposure data.")
@SecurityRequirement(name = "api_key")
@Slf4j
@RestController
public class GenExpoPredictionResource {
    private final GenExpoPredictionRepository repository;

    public GenExpoPredictionResource(GenExpoPredictionRepository repository) {
        this.repository = repository;
    }
    @RequestMapping(value = "/exposure/seem/general/search/by-dtxsid/{dtxsid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    GenExpoPrediction getGenExpoPredictionByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0020232") @PathVariable("dtxsid")String dtxsid) {
        log.debug("general exposure prediction for dtxsid = {}", dtxsid);

        GenExpoPrediction data = repository.findByDtxsid(dtxsid);

        return data;
    }
}
