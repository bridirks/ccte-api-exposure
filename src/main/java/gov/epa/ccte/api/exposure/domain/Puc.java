package gov.epa.ccte.api.exposure.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "puc", schema = "ep")
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
    @Type(type = "org.hibernate.type.TextType")
    private String definition;

}