package gov.epa.ccte.api.exposure.web.rest;

import gov.epa.ccte.api.exposure.domain.DemoExpoPrediction;
import gov.epa.ccte.api.exposure.repository.DemoExpoPredictionRepository;
import gov.epa.ccte.api.exposure.web.rest.error.HigherNumberOfDtxsidException;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * REST controller for getting the {@link gov.epa.ccte.api.exposure.domain.DemoExpoPrediction}s.
 */
@Tag(name = "Demographic Exposure Prediction Resource",
        description = "API endpoints for demographic prediction in exposure data.")
@SecurityRequirement(name = "api_key")
@Slf4j
@RestController
public class DemoExpoPredictionResource implements DemoExpoPredictionApi{
    private final DemoExpoPredictionRepository repository;

    @Value("200")
    private Integer batchSize;

    public DemoExpoPredictionResource(DemoExpoPredictionRepository repository) {
        this.repository = repository;
    }
    @Override
    public List<DemoExpoPrediction> getDemoExpoPredictionByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0020232") @PathVariable("dtxsid")String dtxsid) {
        log.debug("demographic exposure prediction for dtxsid = {}", dtxsid);

        return repository.findByDtxsid(dtxsid);
    }

    @Override
    public @ResponseBody
    List<DemoExpoPrediction> batchSearchDemoExpoPrediction(String[] dtxsids) {
        log.debug("demographic exposure prediction data for dtxsid size = {}", dtxsids.length);

        if(dtxsids.length > batchSize)
            throw new HigherNumberOfDtxsidException(dtxsids.length, batchSize);

        List<DemoExpoPrediction> data = repository.findByDtxsidInOrderByDtxsidAsc(dtxsids, DemoExpoPrediction.class);

        return data;
    }
}
