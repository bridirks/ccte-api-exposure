package gov.epa.ccte.api.exposure.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "v_demo_expo_predictions", schema = "ep")
public class DemoExpoPrediction {
    @Id
    @ColumnDefault("nextval('ep.v_demo_expo_predictions_id_seq'::regclass)")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 20)
    @Column(name = "dtxsid", length = 20)
    private String dtxsid;

    @Size(max = 25)
    @Column(name = "demographic", length = 25)
    private String demographic;

    @Size(max = 25)
    @Column(name = "predictor", length = 25)
    private String predictor;

    @Column(name = "median")
    private Double median;

    @Column(name = "l95")
    private Double l95;

    @Column(name = "u95")
    private Double u95;

    @Size(max = 20)
    @Column(name = "units", length = 20)
    private String units;

    @Column(name = "ad")
    private Integer ad;

    @Size(max = 20)
    @Column(name = "reference", length = 20)
    private String reference;

    @ColumnDefault("now()")
    @Column(name = "import_date")
    private Instant importDate;

}