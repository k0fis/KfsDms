package kfs.kfsdms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author pavedrim
 */
@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"document_id", "tag_id"})
)

public class DmsDocTag {

    @Id
    @Column(length = 40)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @OneToOne
    @JoinColumn(nullable = false, updatable = false)
    private DmsDocument document;

    @OneToOne
    @JoinColumn(nullable = false, updatable = false)
    private DmsTag tag;
    
    @Size(max=100)
    @Column(length = 100)
    private String commentary;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DmsDocTag other = (DmsDocTag) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }
        
    
    public DmsDocument getDocument() {
        return document;
    }

    public void setDocument(DmsDocument document) {
        this.document = document;
    }

    public DmsTag getTag() {
        return tag;
    }

    public void setTag(DmsTag tag) {
        this.tag = tag;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
