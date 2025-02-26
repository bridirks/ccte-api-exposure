package gov.epa.ccte.api.exposure.web.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import gov.epa.ccte.api.exposure.domain.ProductData;
import gov.epa.ccte.api.exposure.domain.Puc;
import gov.epa.ccte.api.exposure.repository.ProductDataRepository;
import gov.epa.ccte.api.exposure.repository.PucRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductDataResource.class)
class ProductDataResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProductDataRepository productDataRepository;

    @MockBean
    private PucRepository pucRepository;

    private ProductData productData;
    private Puc puc;

    @BeforeEach
    void setUp(){
        productData = ProductData.builder()
                .id(635205L)
                .dtxsid("DTXSID7020182")
                .docid(1308929)
                .doctitle("02Y040CAT COMP B MIL-P-23377G TY 1 CL C")
                .docdate("01/10/1997")
                .productname("02y040cat comp b mil-p-23377g ty 1 cl c")
                .rawcentralcomp("<50")
                .unittype("percent")
                .lowerweightfraction(BigDecimal.valueOf(0.000000000000000))
                .upperweightfraction(BigDecimal.valueOf(0.500000000000000))
                .weightfractiontype("reported")
                .build();

        puc = Puc.builder()
                .id(25L)
                .genCat("batteries")
                .prodfam("general use")
                .prodtype("lithium")
                .definition("Single use lithium based batteries for general use, including lithium metal and lithium-ion batteries.")
                .build();
    }

    @Test
    void getProductDataByDtxsid() throws Exception {
        final List<ProductData> products = Collections.singletonList(productData);

        given(productDataRepository.findByDtxsid("DTXSID7020182")).willReturn(products);

        mockMvc.perform(get("/exposure/product-data/search/by-dtxsid/{dtxsid}", "DTXSID7020182"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].dtxsid").value(productData.getDtxsid()));

    }

    @Test
    void getProductDataPuc() throws Exception {
        final List<Puc> pucs = Collections.singletonList(puc);

        given(pucRepository.findAll()).willReturn(pucs);

        mockMvc.perform(get("/exposure/product-data/puc"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(puc.getId()));

    }
}