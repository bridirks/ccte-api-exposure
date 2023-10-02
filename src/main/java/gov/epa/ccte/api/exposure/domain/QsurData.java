package gov.epa.ccte.api.exposure.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "qsur_data", schema = "ep")
public class QsurData {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "dtxsid")
    private String dtxsid;

    @Column(name = "harmonized_functional_use")
    private String harmonizedFunctionalUse;

    @Column(name = "probability", precision = 5, scale = 4)
    private BigDecimal probability;

}