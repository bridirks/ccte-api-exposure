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
@Table(name = "v_puc", schema = "ep")
public class Puc {
    @Id
    @Column(name = "id")
    private Long id;

    @Size(max = 50)
    @Column(name = "kind_name", length = 50)
    private String kindName;

    @Size(max = 50)
    @Column(name = "gen_cat", length = 50)
    private String genCat;

    @Size(max = 50)
    @Column(name = "prodfam", length = 50)
    private String prodfam;

    @Size(max = 100)
    @Column(name = "prodtype", length = 100)
    private String prodtype;

    @Column(name = "definition")
    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    private String definition;

}