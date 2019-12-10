package wizard.dao;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class EnrollPK implements Serializable {
    private int idenroll;
    private int idstudent;
    private int idsubject;

    @Column(name = "idenroll", nullable = false)
    @Id
    public int getIdenroll() {
        return idenroll;
    }

    public void setIdenroll(int idenroll) {
        this.idenroll = idenroll;
    }

    @Column(name = "idstudent", nullable = false)
    @Id
    public int getIdstudent() {
        return idstudent;
    }

    public void setIdstudent(int idstudent) {
        this.idstudent = idstudent;
    }

    @Column(name = "idsubject", nullable = false)
    @Id
    public int getIdsubject() {
        return idsubject;
    }

    public void setIdsubject(int idsubject) {
        this.idsubject = idsubject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EnrollPK enrollPK = (EnrollPK) o;

        if (idenroll != enrollPK.idenroll) return false;
        if (idstudent != enrollPK.idstudent) return false;
        if (idsubject != enrollPK.idsubject) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idenroll;
        result = 31 * result + idstudent;
        result = 31 * result + idsubject;
        return result;
    }
}
