package gov.epa.ccte.api.exposure.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity
@Table(name = "list_presence", schema = "ep")
public class ListPresence {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "dtxsid")
    private String dtxsid;

    @Column(name = "docid")
    private Integer docid;

    @Size(max = 500)
    @Column(name = "doctitle", length = 500)
    private String doctitle;

    @Size(max = 250)
    @Column(name = "docsubtitle", length = 250)
    private String docsubtitle;

    @Size(max = 25)
    @Column(name = "docdate", length = 25)
    private String docdate;

    @Size(max = 255)
    @Column(name = "organization")
    private String organization;

    @Size(max = 255)
    @Column(name = "reportedfunction")
    private String reportedfunction;

    @Size(max = 100)
    @Column(name = "functioncategory", length = 100)
    private String functioncategory;

    @Size(max = 200)
    @Column(name = "component", length = 200)
    private String component;

    @Column(name = "keywordset")
    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    private String keywordset;

}