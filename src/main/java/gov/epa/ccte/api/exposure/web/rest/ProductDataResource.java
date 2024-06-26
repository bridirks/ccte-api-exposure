package gov.epa.ccte.api.exposure.web.rest;

import gov.epa.ccte.api.exposure.domain.ProductData;
import gov.epa.ccte.api.exposure.domain.Puc;
import gov.epa.ccte.api.exposure.repository.ProductDataRepository;
import gov.epa.ccte.api.exposure.repository.PucRepository;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
public class ProductDataResource implements ProductDataApi {

    final private ProductDataRepository productDataRepository;
    final private PucRepository pucRepository;

    public ProductDataResource(ProductDataRepository productDataRepository, PucRepository pucRepository) {
        this.productDataRepository = productDataRepository;
        this.pucRepository = pucRepository;
    }

    @Override
    public List<ProductData> getProductDataByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0020232") @PathVariable("dtxsid") String dtxsid) {
        log.debug("all functional use for dtxsid = {}", dtxsid);

       return productDataRepository.findByDtxsid(dtxsid);

    }

    @Override
    public List<Puc> getProductDataPuc(){
        log.debug("all puc values");

        List<Puc> data = pucRepository.findAll();
        return data;
    }


}
