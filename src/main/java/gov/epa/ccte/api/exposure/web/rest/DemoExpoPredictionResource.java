package gov.epa.ccte.api.exposure.web.rest;

import gov.epa.ccte.api.exposure.domain.DemoExpoPrediction;
import gov.epa.ccte.api.exposure.repository.DemoExpoPredictionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class DemoExpoPredictionResource implements DemoExpoPredictionApi {

    final private DemoExpoPredictionRepository demoExpoPredictionRepository;

    public DemoExpoPredictionResource(DemoExpoPredictionRepository demoExpoPredictionRepository) {
        this.demoExpoPredictionRepository = demoExpoPredictionRepository;
    }
    @Override
    public DemoExpoPrediction getDemoExpoPredictionByDtxsid(String dtxsid) {
        log.debug("demographic exposure prediction for dtxsid = {}", dtxsid);

        return demoExpoPredictionRepository.findByDtxsid(dtxsid);

    }
}
