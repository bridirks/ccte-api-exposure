package gov.epa.ccte.api.exposure.web.rest;

import gov.epa.ccte.api.exposure.domain.DemoExpoPrediction;
import gov.epa.ccte.api.exposure.repository.DemoExpoPredictionRepository;
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
 * REST controller for getting the {@link gov.epa.ccte.api.exposure.domain.DemoExpoPrediction}s.
 */
@Tag(name = "Demographic Exposure Prediction Resource",
        description = "API endpoints for demographic prediction in exposure data.")
@SecurityRequirement(name = "api_key")
@Slf4j
@RestController
public class DemoExpoPredictionResource {
    private final DemoExpoPredictionRepository repository;

    public DemoExpoPredictionResource(DemoExpoPredictionRepository repository) {
        this.repository = repository;
    }
    @RequestMapping(value = "/exposure/seem/demographic/search/by-dtxsid/{dtxsid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<DemoExpoPrediction> getDemoExpoPredictionByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0020232") @PathVariable("dtxsid")String dtxsid) {
        log.debug("demographic exposure prediction for dtxsid = {}", dtxsid);

        return repository.findByDtxsid(dtxsid);


    }
}
