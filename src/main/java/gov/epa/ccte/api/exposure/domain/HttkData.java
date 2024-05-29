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
@Table(name = "v_httk_data", schema = "ep")
public class HttkData {
    @Id
    @ColumnDefault("nextval('ep.v_httk_data_id_seq'::regclass)")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 20)
    @Column(name = "dtxsid", length = 20)
    private String dtxsid;

    @Size(max = 15)
    @Column(name = "parameter", length = 15)
    private String parameter;

    @Column(name = "measured")
    private BigDecimal measured;

    @Column(name = "predicted")
    private BigDecimal predicted;

    @Size(max = 30)
    @Column(name = "units", length = 30)
    private String units;

    @Size(max = 15)
    @Column(name = "model", length = 15)
    private String model;

    @Size(max = 150)
    @Column(name = "reference", length = 150)
    private String reference;

    @Size(max = 5)
    @Column(name = "percentile", length = 5)
    private String percentile;

    @Size(max = 10)
    @Column(name = "species", length = 10)
    private String species;

    @Size(max = 10)
    @Column(name = "data_source_species", length = 10)
    private String dataSourceSpecies;

    @ColumnDefault("now()")
    @Column(name = "import_date")
    private Instant importDate;

}