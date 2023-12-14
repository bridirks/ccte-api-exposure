package gov.epa.ccte.api.exposure.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "dashboard_functionalusecategory", schema = "ep")
public class FunctionalUseCategory {
    @Id
    @Column(name = "id")
    private Integer id;

    @Size(max = 100)
    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "description")
    @Type(type = "org.hibernate.type.TextType")
    private String description;
}