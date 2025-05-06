package gov.epa.ccte.api.exposure.web.rest;

import gov.epa.ccte.api.exposure.domain.FunctionalUseCategory;
import gov.epa.ccte.api.exposure.projection.FunctionalUseAll;
import gov.epa.ccte.api.exposure.projection.FunctionalUseCategoryAll;
import gov.epa.ccte.api.exposure.projection.QsurDataAll;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for getting the {@link gov.epa.ccte.api.exposure.domain.FunctionalUse}s.
 */
@Tag(name = "Functional Use Resource",
        description = "API endpoints for functional use in exposure data.")
@SecurityRequirement(name = "api_key")
@RequestMapping( value = "exposure/functional-use", produces = MediaType.APPLICATION_JSON_VALUE )
public interface FunctionalUseApi {

    @Operation(summary = "Find functional-use data by dtxsid", description = "return functional-use data for requested dtxsid")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {FunctionalUseAll.class}))),
    })
    @RequestMapping(value = "/search/by-dtxsid/{dtxsid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<FunctionalUseAll> getFunctionalUseByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0020232") @PathVariable("dtxsid") String dtxsid);

    @Operation(summary = "Find functional-use categories", description = "return all functional-use categories")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json",
                    schema = @Schema(oneOf = {FunctionalUseCategoryAll.class}))),
    })
    @RequestMapping(value = "/category", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<FunctionalUseCategory> getFunctionalUseCategory();

    @Operation(summary = "Find functional-use probability by dtxsid", description = "return functional-use probability for requested dtxsid")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json",
                    schema = @Schema(oneOf = {QsurDataAll.class}))),
    })
    @RequestMapping(value = "/probability/search/by-dtxsid/{dtxsid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<QsurDataAll> getFunctionalUseProbabilityByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0020232") @PathVariable("dtxsid") String dtxsid);

    @Operation(summary = "Find functional-use data by batch of dtxsids", description = "return functional-use data  for requested dtxsids.")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {FunctionalUseAll.class}))),
    })
    @PostMapping(value = "/search/by-dtxsid/")
    @ResponseBody
    List<FunctionalUseAll> batchSearchFunctionalUse(@io.swagger.v3.oas.annotations.parameters.RequestBody(required = true, description = "JSON array of DSSTox Substance Identifier",
            content = {@Content(array = @ArraySchema(schema = @Schema(implementation = String.class)),
                    examples = {@ExampleObject("\"[\\\"DTXSID7020182\\\",\\\"DTXSID9020112\\\"]\"")})})
                                                    @RequestBody String[] dtxsids);

}
