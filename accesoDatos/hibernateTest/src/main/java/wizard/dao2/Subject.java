package wizard.dao2;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Subject {
    private int idsubject;
    private String name;
    private Collection<Enroll> enrollsByIdsubject;
    private Teacher teacherByIdteacher;

    @Id
    @Column(name = "idsubject", nullable = false)
    public int getIdsubject() {
        return idsubject;
    }

    public void setIdsubject(int idsubject) {
        this.idsubject = idsubject;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subject subject = (Subject) o;

        if (idsubject != subject.idsubject) return false;
        if (name != null ? !name.equals(subject.name) : subject.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idsubject;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "subjectByIdsubject")
    public Collection<Enroll> getEnrollsByIdsubject() {
        return enrollsByIdsubject;
    }

    public void setEnrollsByIdsubject(Collection<Enroll> enrollsByIdsubject) {
        this.enrollsByIdsubject = enrollsByIdsubject;
    }

    @ManyToOne
    @JoinColumn(name = "idteacher", referencedColumnName = "idteacher", nullable = false)
    public Teacher getTeacherByIdteacher() {
        return teacherByIdteacher;
    }

    public void setTeacherByIdteacher(Teacher teacherByIdteacher) {
        this.teacherByIdteacher = teacherByIdteacher;
    }
}
