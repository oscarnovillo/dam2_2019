package wizard.dao;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Teacher {
    private int idteacher;
    private Date startDate;

    @Id
    @GeneratedValue
    @Column(name = "idteacher", nullable = false)
    public int getIdteacher() {
        return idteacher;
    }

    public void setIdteacher(int idteacher) {
        this.idteacher = idteacher;
    }

    @Basic
    @Column(name = "start_date", nullable = true)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        if (idteacher != teacher.idteacher) return false;
        if (startDate != null ? !startDate.equals(teacher.startDate) : teacher.startDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idteacher;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        return result;
    }
}
