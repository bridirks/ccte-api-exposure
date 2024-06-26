package gov.epa.ccte.api.exposure.web.rest;

import gov.epa.ccte.api.exposure.domain.GenExpoPrediction;
import gov.epa.ccte.api.exposure.repository.GenExpoPredictionRepository;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
public class GenExpoPredictionResource implements GenExpoPredictionApi {
    private final GenExpoPredictionRepository repository;

    public GenExpoPredictionResource(GenExpoPredictionRepository repository) {
        this.repository = repository;
    }
    @Override
     public List<GenExpoPrediction> getGenExpoPredictionByDtxsid(String dtxsid) {
        log.debug("general exposure prediction for dtxsid = {}", dtxsid);

         return repository.findByDtxsid(dtxsid);

    }
}
