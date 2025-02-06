package gov.epa.ccte.api.exposure.web.rest;

import java.util.List;

import org.springframework.data.domain.Limit;
import org.springframework.web.bind.annotation.RestController;

import gov.epa.ccte.api.exposure.domain.MMDBAggregate;
import gov.epa.ccte.api.exposure.domain.MMDBMediaDesc;
import gov.epa.ccte.api.exposure.domain.MMDBSingleSample;
import gov.epa.ccte.api.exposure.projection.MMDBMediaDescSummary;
import gov.epa.ccte.api.exposure.repository.MMDBAggregateRepository;
import gov.epa.ccte.api.exposure.repository.MMDBMediaDescRepository;
import gov.epa.ccte.api.exposure.repository.MMDBSingleSampleRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MMDBResource implements MMDBApi {

		private final MMDBAggregateRepository aggregateRepository;
		private final MMDBSingleSampleRepository singleSampleRepository;
		private final MMDBMediaDescRepository mediaRepository;
		private Integer limit = 2000;

	public MMDBResource(MMDBAggregateRepository aggregateRepository,MMDBSingleSampleRepository singleSampleRepository, MMDBMediaDescRepository mediaRepository) {
		this.aggregateRepository = aggregateRepository;
		this.singleSampleRepository = singleSampleRepository;
		this.mediaRepository = mediaRepository;
	}

	@Override
	public List<MMDBAggregate> getHarmonizedAggregateDataByDtxsid(String dtxsid){
        log.debug("all MMDB harmonized aggregate data for dtxsid = {}", dtxsid);

        return aggregateRepository.findByDtxsid(dtxsid);
       
	}

	@Override
	public   List<MMDBAggregate> getHarmonizedAggregateDataByMedium(String medium){
        log.debug("all MMDB harmonized aggregate data for medium = {}", medium);

        return aggregateRepository.findByHarmonizedMedium(medium, Limit.of(limit));
	}

	@Override
	public List<MMDBSingleSample> getHarmonizedSingleSampleDataByDtxsid(String dtxsid){
        log.debug("all MMDB harmonized single-sample data for dtxsid = {}", dtxsid);

        return singleSampleRepository.findByDtxsid(dtxsid);
	}

	@Override
	public List<MMDBSingleSample> getHarmonizedSingleSampleDataByMedium(String medium){
        log.debug("all MMDB harmonized single-sample data for medium = {}", medium);

        return singleSampleRepository.findByHarmonizedMedium(medium, Limit.of(limit));

	}

	public List<MMDBMediaDescSummary> getAllHarmonizedMedia(){
		log.debug("All available media descriptions");
		
		List<MMDBMediaDescSummary> data =  mediaRepository.findBy(MMDBMediaDescSummary.class);
		return data;
	}

}

