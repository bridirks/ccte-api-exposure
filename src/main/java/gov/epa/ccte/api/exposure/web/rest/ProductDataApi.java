package gov.epa.ccte.api.exposure.web.rest;

import gov.epa.ccte.api.exposure.domain.ProductData;
import gov.epa.ccte.api.exposure.domain.Puc;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * REST controller for getting the {@link gov.epa.ccte.api.exposure.domain.ProductData}s.
 */
@Tag(name = "Product Data Resource",
        description = "API endpoints for product data in exposure data.")
@SecurityRequirement(name = "api_key")
@RequestMapping( value = "exposure/product-data" , produces = MediaType.APPLICATION_JSON_VALUE )
public interface ProductDataApi {

    @Operation(summary = "Find product data by dtxsid or list all puc product data", description = "return product data for requested dtxsid or puc product data.", tags = {"product-data","exposure"})
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {ProductData.class}))),
    })

    @RequestMapping(value = "/search/by-dtxsid/{dtxsid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<ProductData> getProductDataByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0020232") @PathVariable("dtxsid") String dtxsid);


    @RequestMapping(value = "/puc", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<Puc> getProductDataPuc();
}