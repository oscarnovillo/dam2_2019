package dao.modelo;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Teacher {

    @Id
    private int idteacher;

    private LocalDate start_date;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "idteacher", referencedColumnName = "idteacher")
    private List<Subject> subjects;

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public Teacher() {
    }

    public int getIdteacher() {
        return idteacher;
    }

    public void setIdteacher(int idteacher) {
        this.idteacher = idteacher;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "idteacher=" + idteacher +
                ", start_date=" + start_date +
                '}';
    }
}

