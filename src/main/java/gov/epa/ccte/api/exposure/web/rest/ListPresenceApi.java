package gov.epa.ccte.api.exposure.web.rest;

import gov.epa.ccte.api.exposure.domain.ListPresence;
import gov.epa.ccte.api.exposure.domain.ListPresenceTag;
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
@Tag(name = "List Presence Resource",
        description = "API endpoints for list presence in exposure data.")
@SecurityRequirement(name = "api_key")
@RequestMapping( value = "exposure/list-presence", produces = MediaType.APPLICATION_JSON_VALUE )
public interface ListPresenceApi {

    @Operation(summary = "Find list presence data by dtxsid and produce list presence tags", description = "return list presence data for requested dtxsid or list presence tags.", tags = {"list-presence","exposure"})
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json",
                    schema = @Schema(oneOf = {ListPresence.class}))),
    })
    @RequestMapping(value = "/search/by-dtxsid/{dtxsid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<ListPresence> getListPresenceByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0020232") @PathVariable("dtxsid") String dtxsid);

    @RequestMapping(value = "/tags", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<ListPresenceTag> getListPresenceTags();
}
