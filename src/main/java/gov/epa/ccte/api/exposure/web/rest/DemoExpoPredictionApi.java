package gov.epa.ccte.api.exposure.web.rest;

import gov.epa.ccte.api.exposure.domain.DemoExpoPrediction;
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

/**
 * REST controller for getting the {@link gov.epa.ccte.api.exposure.domain.DemoExpoPrediction}s.
 */
@Tag(name = "Demographic Exposure Prediction Resource",
        description = "API endpoints for demographic prediction in exposure data.")
@SecurityRequirement(name = "api_key")
@RequestMapping( value = "exposure/seem/demographic", produces = MediaType.APPLICATION_JSON_VALUE)
public interface DemoExpoPredictionApi {

    @Operation(summary = "Find demographic prediction SEEMs data by dtxsid", description = "return demographic prediction SEEMs data for requested dtxsid.", tags = {"exposure","seem","demographic"})
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content( mediaType = "application/json",
            schema = @Schema(oneOf = DemoExpoPrediction.class)))
    })
    @RequestMapping(value = "/search/by-dtxsid/{dtxsid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    DemoExpoPrediction getDemoExpoPredictionByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0020232")
                                                     @PathVariable("dtxsid") String dtxsid);
}
