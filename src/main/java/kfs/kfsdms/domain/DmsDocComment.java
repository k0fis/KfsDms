package kfs.kfsdms.domain;

import com.vaadin.ui.TextArea;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
public class DmsDocComment {

    @Id
    @Column(length = 40)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @NotNull
    @Column(length = 1024, updatable = false, nullable = false)
    @Size(max = 1024)
    @KfsMField({
        @KfsField(pos = 100, name = "ExchEventDlg", fieldClass = TextArea.class, isRequired = true),})
    private String note;

    @NotNull
    @Column(length = 50, updatable = false, nullable = false)
    @Size(max = 50)
    private String userName;

    @NotNull
    @Column(updatable = false, nullable = false)
    private Timestamp commentDate;

    @OneToOne
    @JoinColumn(nullable = false, updatable = false)
    private DmsDocument document;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final DmsDocComment other = (DmsDocComment) obj;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Timestamp getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Timestamp commentDate) {
        this.commentDate = commentDate;
    }

    public DmsDocument getDocument() {
        return document;
    }

    public void setDocument(DmsDocument document) {
        this.document = document;
    }

}
