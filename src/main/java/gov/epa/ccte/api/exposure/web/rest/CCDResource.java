package gov.epa.ccte.api.exposure.web.rest;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import gov.epa.ccte.api.exposure.domain.CCDBiomonitoring;
import gov.epa.ccte.api.exposure.domain.CCDChemicalWeightFractions;
import gov.epa.ccte.api.exposure.domain.CCDGeneralUseKeywords;
import gov.epa.ccte.api.exposure.domain.CCDProductUseCategory;
import gov.epa.ccte.api.exposure.domain.CCDReportedFunctionalUse;
import gov.epa.ccte.api.exposure.repository.CCDBiomonitoringRepository;
import gov.epa.ccte.api.exposure.repository.CCDChemicalWeightFractionsRepository;
import gov.epa.ccte.api.exposure.repository.CCDGeneralUseKeywordsRepository;
import gov.epa.ccte.api.exposure.repository.CCDProductUseCategoryRepository;
import gov.epa.ccte.api.exposure.repository.CCDReportedFunctionalUseRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CCDResource implements CCDApi{

    private final CCDChemicalWeightFractionsRepository chemWeightRepository;
    private final CCDGeneralUseKeywordsRepository keywordsRepository;
    private final CCDProductUseCategoryRepository productUseRepository;
    private final CCDReportedFunctionalUseRepository functionalUseRepository;
    private final CCDBiomonitoringRepository biomonitoringRepository;

    public CCDResource(CCDChemicalWeightFractionsRepository chemWeightRepository, CCDGeneralUseKeywordsRepository keywordsRepository, CCDProductUseCategoryRepository productUseRepository, CCDReportedFunctionalUseRepository functionalUseRepository, CCDBiomonitoringRepository biomonitoringRepository) {
        this.chemWeightRepository = chemWeightRepository;
        this.keywordsRepository = keywordsRepository;
        this.productUseRepository = productUseRepository;
        this.functionalUseRepository = functionalUseRepository;
        this.biomonitoringRepository = biomonitoringRepository;
    }
    
    @Override
    public List<CCDChemicalWeightFractions> getChemicalWeightFractionsByDtxsid(String dtxsid) {
        log.debug("all chemical weight fractions data for dtxsid = {}", dtxsid);

        List<CCDChemicalWeightFractions> data = chemWeightRepository.findByDtxsid(dtxsid);

        return data;
    }
    
    @Override
    public List<CCDGeneralUseKeywords> getGeneralUseKeywordsByDtxsid(String dtxsid) {
        log.debug("all gneral use keywords data for dtxsid = {}", dtxsid);

        List<CCDGeneralUseKeywords> data = keywordsRepository.findByDtxsid(dtxsid);

        return data;
    }
    
    @Override
    public List<CCDProductUseCategory> getProductUseCategoryByDtxsid(String dtxsid) {
        log.debug("all product use category data for dtxsid = {}", dtxsid);

        List<CCDProductUseCategory> data = productUseRepository.findByDtxsid(dtxsid);

        return data;
    }
    
    @Override
    public List<CCDReportedFunctionalUse> getReportedFunctionalUseByDtxsid(String dtxsid) {
        log.debug("all reported functional use data for dtxsid = {}", dtxsid);

        List<CCDReportedFunctionalUse> data = functionalUseRepository.findByDtxsid(dtxsid);

        return data;
    }
    
    @Override
    public List<CCDBiomonitoring> getBiomonitoringDataByDtxsid(String dtxsid) {
        log.debug("all NHANES Inferences for dtxsid = {}", dtxsid);

        List<CCDBiomonitoring> data = biomonitoringRepository.findByDtxsid(dtxsid);

        return data;
    }
}
