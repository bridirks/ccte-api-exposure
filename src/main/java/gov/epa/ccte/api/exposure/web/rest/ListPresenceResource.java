package gov.epa.ccte.api.exposure.web.rest;

import gov.epa.ccte.api.exposure.domain.ListPresence;
import gov.epa.ccte.api.exposure.domain.ListPresenceTag;
import gov.epa.ccte.api.exposure.repository.ListPresenceRepository;
import gov.epa.ccte.api.exposure.repository.ListPresenceTagRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
public class ListPresenceResource implements ListPresenceApi {
    final private ListPresenceRepository listPresenceRepository;
    final private ListPresenceTagRepository listPresenceTagRepository;
    public ListPresenceResource(ListPresenceRepository listPresenceRepository, ListPresenceTagRepository listPresenceTagRepository) {
        this.listPresenceRepository = listPresenceRepository;
        this.listPresenceTagRepository = listPresenceTagRepository;
    }

    @Override
    public List<ListPresence> getListPresenceByDtxsid(String dtxsid) {
        log.debug("all functional use for dtxsid = {}", dtxsid);

        List<ListPresence> data = listPresenceRepository.findByDtxsid(dtxsid);

        return data;
    }

    @Override
    public List<ListPresenceTag> getListPresenceTags(){
        log.debug("all functional use category");
        List<ListPresenceTag> data = listPresenceTagRepository.findAll();
        return data;
    }

}
