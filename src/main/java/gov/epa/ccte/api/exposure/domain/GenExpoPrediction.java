package gov.epa.ccte.api.exposure.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "v_gen_expo_predictions", schema = "ep")
public class GenExpoPrediction {
    @Id
    @Size(max = 20)
    @Column(name = "dtxsid", length = 20)
    private String dtxsid;

    @Column(name = "production_volume")
    private BigDecimal productionVolume;

    @Size(max = 7)
    @Column(name = "units", length = 7)
    private String units;

    @Column(name = "stockholm_convention")
    private Integer stockholmConvention;

    @Column(name = "probability_dietary", precision = 5, scale = 4)
    private BigDecimal probabilityDietary;

    @Column(name = "probability_residential", precision = 5, scale = 4)
    private BigDecimal probabilityResidential;

    @Column(name = "probability_pesticde", precision = 5, scale = 4)
    private BigDecimal probabilityPesticde;

    @Column(name = "probability_industrial", precision = 5, scale = 4)
    private BigDecimal probabilityIndustrial;

    @ColumnDefault("now()")
    @Column(name = "import_date")
    private Instant importDate;

}