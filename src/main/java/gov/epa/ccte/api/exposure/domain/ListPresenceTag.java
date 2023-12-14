package gov.epa.ccte.api.exposure.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "list_presence_tag", schema = "ep")
public class ListPresenceTag {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 100)
    @Column(name = "tag_name", length = 100)
    private String tagName;

    @Size(max = 750)
    @Column(name = "tag_definition", length = 750)
    private String tagDefinition;

    @Size(max = 50)
    @Column(name = "kind_name", length = 50)
    private String kindName;

}