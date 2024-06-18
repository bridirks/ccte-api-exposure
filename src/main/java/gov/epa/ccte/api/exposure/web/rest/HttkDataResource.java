package gov.epa.ccte.api.exposure.web.rest;

import gov.epa.ccte.api.exposure.domain.HttkData;
import gov.epa.ccte.api.exposure.repository.HttkDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
public class HttkDataResource implements HttkDataApi {

    final private HttkDataRepository httkDataRepository;

    public HttkDataResource( HttkDataRepository httkDataRepository) {
        this.httkDataRepository = httkDataRepository;

    }

    @Override
    public List<HttkData> getHttkDataByDtxsid(String dtxsid) {
        log.debug("Httk Data by dtxsid = {}", dtxsid);

        return httkDataRepository.findByDtxsid(dtxsid);
    }
}
