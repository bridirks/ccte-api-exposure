package gov.epa.ccte.api.exposure.web.rest;

import gov.epa.ccte.api.exposure.domain.FunctionalUse;
import gov.epa.ccte.api.exposure.domain.FunctionalUseCategory;
import gov.epa.ccte.api.exposure.projection.FunctionalUseAll;
import gov.epa.ccte.api.exposure.projection.QsurDataAll;
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
 * REST controller for getting the {@link gov.epa.ccte.api.exposure.domain.FunctionalUse}s.
 */
@Tag(name = "Functional Use Resource",
        description = "API endpoints for functional use in exposure data.")
@SecurityRequirement(name = "api_key")
@RequestMapping( value = "exposure/functional-use", produces = MediaType.APPLICATION_JSON_VALUE )
public interface FunctionalUseApi {

    @Operation(summary = "Find functional-use data by dtxsid, find functional-use categories, or find functional-use probability by dtxsid", description = "return functional-use data or probability for requested dtxsid or all functional-use categories.")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {FunctionalUse.class}))),
    })
    @RequestMapping(value = "/search/by-dtxsid/{dtxsid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<FunctionalUseAll> getFunctionalUseByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0020232") @PathVariable("dtxsid") String dtxsid);

    @RequestMapping(value = "/category", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<FunctionalUseCategory> getFunctionalUseCategory();

    @RequestMapping(value = "/probability/search/by-dtxsid/{dtxsid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<QsurDataAll> getFunctionalUseProbabilityByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0020232") @PathVariable("dtxsid") String dtxsid);
}
