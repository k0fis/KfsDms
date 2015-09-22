package kfs.kfsdms.domain;

import com.vaadin.ui.TextArea;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import kfs.kfsvaalib.kfsForm.KfsField;
import kfs.kfsvaalib.kfsForm.KfsMField;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author pavedrim
 */
@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"document_id", "name"})
)
public class DmsDocKeyword {

    @Id
    @Column(length = 40)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @NotNull
    @Column(length = 128, updatable = false, nullable = false)
    @Size(max = 128)
    @KfsMField({
        @KfsField(pos = 100, fieldClass = TextArea.class, isRequired = true, readOnly = true),})
    private String name = "";

    @OneToOne
    @JoinColumn(nullable = false, updatable = false)
    private DmsDocument document;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final DmsDocKeyword other = (DmsDocKeyword) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DmsDocument getDocument() {
        return document;
    }

    public void setDocument(DmsDocument document) {
        this.document = document;
    }

}
