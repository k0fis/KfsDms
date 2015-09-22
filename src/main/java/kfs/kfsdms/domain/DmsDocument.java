package kfs.kfsdms.domain;

import com.vaadin.ui.TextArea;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
public class DmsDocument {

    @Id
    @Column(length = 40)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @NotNull
    @Column(length = 128, updatable = false, nullable = false, unique = true)
    @Size(max = 128)
    @KfsMField({
        @KfsField(pos = 10, name = "new", isRequired = true, readOnly = true),
        @KfsField(pos = 10, name = "edit", isRequired = true, readOnly = true),})
    private String name = "";

    @Column(length = 1024, updatable = false, nullable = false)
    @Size(max = 1024)
    @KfsMField({
        @KfsField(pos = 20, fieldClass = TextArea.class),})
    private String note = "";

    private String status = "";

    @NotNull
    @Column(length = 50, updatable = false, nullable = false)
    @Size(max = 50)
    private String createdBy;
    
    @NotNull
    @Column(updatable = false, nullable = false)
    private Timestamp created;
    
    @NotNull
    @Column(length = 50, nullable = false)
    @Size(max = 50)
    private String lastModifiedBy;

    @NotNull
    @Column(nullable = false)    
    private Timestamp modified;

    @NotNull
    @Column(length = 50)
    @Size(max = 50)
    private String lockedBy;
    
    private Timestamp locked;
    
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
        final DmsDocument other = (DmsDocument) obj;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Timestamp getModified() {
        return modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }

    public String getLockedBy() {
        return lockedBy;
    }

    public void setLockedBy(String lockedBy) {
        this.lockedBy = lockedBy;
    }

    public Timestamp getLocked() {
        return locked;
    }

    public void setLocked(Timestamp locked) {
        this.locked = locked;
    }

    
}
