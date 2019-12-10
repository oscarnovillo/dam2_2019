package wizard.dao;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Typeuser {
    private int idtypeuser;
    private String description;

    @Id
    @Column(name = "idtypeuser", nullable = false)
    public int getIdtypeuser() {
        return idtypeuser;
    }

    public void setIdtypeuser(int idtypeuser) {
        this.idtypeuser = idtypeuser;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 45)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Typeuser typeuser = (Typeuser) o;

        if (idtypeuser != typeuser.idtypeuser) return false;
        if (description != null ? !description.equals(typeuser.description) : typeuser.description != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idtypeuser;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
