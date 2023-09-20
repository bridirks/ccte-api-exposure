package gov.epa.ccte.api.exposure.web.rest;

import gov.epa.ccte.api.exposure.domain.ProductData;
import gov.epa.ccte.api.exposure.domain.Puc;
import gov.epa.ccte.api.exposure.repository.ProductDataRepository;
import gov.epa.ccte.api.exposure.repository.PucRepository;
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
 * REST controller for getting the {@link gov.epa.ccte.api.exposure.domain.ProductData}s.
 */
@Tag(name = "Product Data Resource",
        description = "API endpoints for prodcut data in exposure data.")
@SecurityRequirement(name = "api_key")
@Slf4j
@RestController
public class ProductDataResource {

    final private ProductDataRepository productDataRepository;
    final private PucRepository pucRepository;

    public ProductDataResource(ProductDataRepository productDataRepository, PucRepository pucRepository, PucRepository pucRepository1) {
        this.productDataRepository = productDataRepository;
        this.pucRepository = pucRepository1;
    }

    @RequestMapping(value = "exposure/product-data/search/by-dtxsid/{dtxsid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<ProductData> getProductDataByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0020232") @PathVariable("dtxsid")String dtxsid) {
        log.debug("all functional use for dtxsid = {}", dtxsid);

       return productDataRepository.findByDtxsid(dtxsid);

    }

    @RequestMapping(value = "exposure/product-data/puc", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<Puc> getProductDataPuc(){
        log.debug("all puc values");

        List<Puc> data = pucRepository.findAll();
        return data;
    }


}
