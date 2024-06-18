package gov.epa.ccte.api.exposure.web.rest;

import gov.epa.ccte.api.exposure.domain.HttkData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
 * REST controller for getting the {@link gov.epa.ccte.api.exposure.domain.HttkData}s.
 */
@Tag(name = "Httk Data Resource",
        description = "API endpoints for httk data in exposure data.")
@SecurityRequirement(name = "api_key")
@RequestMapping( value = "exposure/httk", produces = MediaType.APPLICATION_JSON_VALUE)
public interface HttkDataApi {

    @Operation(summary = "Find httk data by dtxsid", description = "return httk data for requested dtxsid.", tags = {"httk","exposure"})
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {HttkData.class}))),
    })
    @RequestMapping(value = "/search/by-dtxsid/{dtxsid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<HttkData> getHttkDataByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0020232")
                                       @PathVariable("dtxsid") String dtxsid);
}
