package gov.epa.ccte.api.exposure.domain;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;


@Getter
@Setter
@Entity
@Table(name = "functional_use", schema = "ep")
public class FunctionalUse {
    @Id
    @Column(name = "id")
    private Long id;

    @Size(max = 50)
    @Column(name = "dtxsid", length = 50)
    private String dtxsid;

    @Size(max = 50)
    @Column(name = "datatype", length = 50)
    private String datatype;

    @Column(name = "docid")
    private Integer docid;

    @Size(max = 500)
    @Column(name = "doctitle", length = 500)
    private String doctitle;

    @Size(max = 25)
    @Column(name = "docdate", length = 25)
    private String docdate;

    @Size(max = 255)
    @Column(name = "reportedfunction")
    private String reportedfunction;

    @Size(max = 100)
    @Column(name = "functioncategory", length = 100)
    private String functioncategory;

}