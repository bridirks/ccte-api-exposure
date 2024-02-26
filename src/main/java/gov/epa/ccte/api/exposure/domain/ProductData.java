package gov.epa.ccte.api.exposure.domain;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "v_product_data", schema = "ep")
public class ProductData {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 50)
    @Column(name = "dtxsid", length = 50)
    private String dtxsid;

    @Column(name = "docid")
    private Integer docid;

    @Size(max = 500)
    @Column(name = "doctitle", length = 500)
    private String doctitle;

    @Size(max = 25)
    @Column(name = "docdate", length = 25)
    private String docdate;

    @Size(max = 255)
    @Column(name = "productname")
    private String productname;

    @Size(max = 50)
    @Column(name = "gencat", length = 50)
    private String gencat;

    @Size(max = 50)
    @Column(name = "prodfam", length = 50)
    private String prodfam;

    @Size(max = 100)
    @Column(name = "prodtype", length = 100)
    private String prodtype;

    @Size(max = 100)
    @Column(name = "classificationmethod", length = 100)
    private String classificationmethod;

    @Size(max = 100)
    @Column(name = "rawmincomp", length = 100)
    private String rawmincomp;

    @Size(max = 100)
    @Column(name = "rawmaxcomp", length = 100)
    private String rawmaxcomp;

    @Size(max = 100)
    @Column(name = "rawcentralcomp", length = 100)
    private String rawcentralcomp;

    @Size(max = 50)
    @Column(name = "unittype", length = 50)
    private String unittype;

    @Column(name = "lowerweightfraction", precision = 16, scale = 15)
    private BigDecimal lowerweightfraction;

    @Column(name = "upperweightfraction", precision = 16, scale = 15)
    private BigDecimal upperweightfraction;

    @Column(name = "centralweightfraction", precision = 16, scale = 15)
    private BigDecimal centralweightfraction;

    @Size(max = 50)
    @Column(name = "weightfractiontype", length = 50)
    private String weightfractiontype;

    @Size(max = 200)
    @Column(name = "component", length = 200)
    private String component;

}