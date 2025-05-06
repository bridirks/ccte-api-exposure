package gov.epa.ccte.api.exposure.web.rest;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import gov.epa.ccte.api.exposure.domain.MMDBAggregate;
import gov.epa.ccte.api.exposure.domain.MMDBSingleSample;
import gov.epa.ccte.api.exposure.projection.MMDBMediaDescSummary;
import gov.epa.ccte.api.exposure.web.rest.requests.MMDBPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "MMBD Resource",
        description = "API endpoints for collecting data for MMDB database.")
@SecurityRequirement(name = "api_key")
@RequestMapping( value = "exposure/mmdb")
public interface MMDBApi {

	/**
	 * {@code GET  /exposure/mmdb/aggregate/by-dtxsid/:dtxsid} : get list of harmonized aggregate records by dtxsid.
	 *
	 * @param dtxsid the matching dtxsid of the MMDB aggregate records to retrieve
	 * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the list of MMDB aggregate records}.
	 */
	@Operation(summary = "Get harmonized aggregate records by dtxsid",
            description = "Specify the dtxsid as part of the path.")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {MMDBAggregate.class})))
    })
    @RequestMapping(value = "/aggregate/by-dtxsid/{dtxsid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		List<MMDBAggregate> getHarmonizedAggregateDataByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID7020182") @PathVariable("dtxsid") String dtxsid);

	/**
	 * {@code GET  /exposure/mmdb/aggregate/by-medium/:medium} : get list of harmonized aggregate records by harmonized medium.
	 *
	 * @param dtxsid the matching dtxsid of the MMDB aggregate records to retrieve
	 * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the list of MMDB aggregate records}.
	 */
	@Operation(summary = "Get harmonized aggregate records by medium",
            description = "Specify the medium as part of the path.")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {MMDBAggregate.class})))
    })
    @RequestMapping(value = "/aggregate/by-medium/{medium}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		MMDBPage getHarmonizedAggregateDataByMedium(@Parameter(required = true, description = "harmonized medium", example = "surface water") @PathVariable("medium") String medium,
												@RequestParam(required = false, value = "pageNumber", defaultValue = "1") Integer pageNumber);

	/**
	 * {@code GET  /exposure/mmdb/single-sample/by-dtxsid/:dtxsid} : get list of harmonized single-sample data records by dtxsid.
	 *
	 * @param dtxsid the matching dtxsid of the MMDB aggregate records to retrieve
	 * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the list of MMDB aggregate records}.
	 */
	@Operation(summary = "Get harmonized single-sample records by dtxsid",
            description = "Specify the dtxsid as part of the path.")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {MMDBSingleSample.class})))
    })
    @RequestMapping(value = "/single-sample/by-dtxsid/{dtxsid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		List<MMDBSingleSample> getHarmonizedSingleSampleDataByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID7020182") @PathVariable("dtxsid") String dtxsid);


	/**
	 * {@code GET  /exposure/mmdb/single-sample/by-medium/:medium} : get list of harmonized single-sample records by dtxsid.
	 *
	 * @param dtxsid the matching dtxsid of the MMDB aggregate records to retrieve
	 * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the list of MMDB aggregate records}.
	 */
	@Operation(summary = "Get harmonized single-sample records by medium",
            description = "Specify the medium as part of the path.")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {MMDBSingleSample.class})))
    })
    @RequestMapping(value = "/single-sample/by-medium/{medium}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		MMDBPage getHarmonizedSingleSampleDataByMedium(@Parameter(required = true, description = "harmonized medium", example = "surface water") @PathVariable("medium") String medium,
													@RequestParam(required = false, value = "pageNumber", defaultValue = "1") Integer pageNumber);


	/**
	 * {@code GET  /exposure/mmdb/mediums} : get list of all searchable medium categories and their definitions.
	 *
	 * @param N/A.
	 * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the list of MMDB medium categories and definitions}.
	 */
	@Operation(summary = "Get all searchable harmonized medium categories and their corresponding definitions")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {MMDBMediaDescSummary.class})))
    })
    @RequestMapping(value = "/mediums", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	List<MMDBMediaDescSummary> getAllHarmonizedMedia();

}
