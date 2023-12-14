package gov.epa.ccte.api.exposure.web.rest;

import gov.epa.ccte.api.exposure.domain.ListPresence;
import gov.epa.ccte.api.exposure.domain.ListPresenceTag;
import gov.epa.ccte.api.exposure.repository.ListPresenceRepository;
import gov.epa.ccte.api.exposure.repository.ListPresenceTagRepository;
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
 * REST controller for getting the {@link gov.epa.ccte.api.exposure.domain.FunctionalUse}s.
 */
@Tag(name = "List Presence Resource",
        description = "API endpoints for list presence in exposure data.")
@SecurityRequirement(name = "api_key")
@Slf4j
@RestController
public class ListPresenceResource {
    final private ListPresenceRepository listPresenceRepository;
    final private ListPresenceTagRepository listPresenceTagRepository;
    public ListPresenceResource(ListPresenceRepository listPresenceRepository, ListPresenceTagRepository listPresenceTagRepository) {
        this.listPresenceRepository = listPresenceRepository;
        this.listPresenceTagRepository = listPresenceTagRepository;
    }

    @RequestMapping(value = "exposure/list-presence/search/by-dtxsid/{dtxsid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<ListPresence> getListPresenceByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0020232") @PathVariable("dtxsid")String dtxsid) {
        log.debug("all functional use for dtxsid = {}", dtxsid);

        List<ListPresence> data = listPresenceRepository.findByDtxsid(dtxsid);

        return data;
    }

    @RequestMapping(value = "exposure/list-presence/tags", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<ListPresenceTag> getListPresenceTags(){
        log.debug("all functional use category");
        List<ListPresenceTag> data = listPresenceTagRepository.findAll();
        return data;
    }

}
