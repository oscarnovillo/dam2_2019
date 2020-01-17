package wizard.dao2;

import javax.persistence.*;

@Entity
@IdClass(EnrollPK.class)
public class Enroll {
    private int idenroll;
    private int idstudent;
    private int idsubject;
    private Integer ncalls;
    private Integer mark;
    private Student studentByIdstudent;
    private SubjectTest subjectByIdsubject;

    @Id
    @Column(name = "idenroll", nullable = false)
    public int getIdenroll() {
        return idenroll;
    }

    public void setIdenroll(int idenroll) {
        this.idenroll = idenroll;
    }

    @Id
    @Column(name = "idstudent", nullable = false)
    public int getIdstudent() {
        return idstudent;
    }

    public void setIdstudent(int idstudent) {
        this.idstudent = idstudent;
    }

    @Id
    @Column(name = "idsubject", nullable = false)
    public int getIdsubject() {
        return idsubject;
    }

    public void setIdsubject(int idsubject) {
        this.idsubject = idsubject;
    }

    @Basic
    @Column(name = "ncalls", nullable = true)
    public Integer getNcalls() {
        return ncalls;
    }

    public void setNcalls(Integer ncalls) {
        this.ncalls = ncalls;
    }

    @Basic
    @Column(name = "mark", nullable = true)
    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Enroll enroll = (Enroll) o;

        if (idenroll != enroll.idenroll) return false;
        if (idstudent != enroll.idstudent) return false;
        if (idsubject != enroll.idsubject) return false;
        if (ncalls != null ? !ncalls.equals(enroll.ncalls) : enroll.ncalls != null) return false;
        if (mark != null ? !mark.equals(enroll.mark) : enroll.mark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idenroll;
        result = 31 * result + idstudent;
        result = 31 * result + idsubject;
        result = 31 * result + (ncalls != null ? ncalls.hashCode() : 0);
        result = 31 * result + (mark != null ? mark.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idstudent", referencedColumnName = "idstudent", nullable = false)
    public Student getStudentByIdstudent() {
        return studentByIdstudent;
    }

    public void setStudentByIdstudent(Student studentByIdstudent) {
        this.studentByIdstudent = studentByIdstudent;
    }

    @ManyToOne
    @JoinColumn(name = "idsubject", referencedColumnName = "idsubject", nullable = false)
    public SubjectTest getSubjectByIdsubject() {
        return subjectByIdsubject;
    }

    public void setSubjectByIdsubject(SubjectTest subjectByIdsubject) {
        this.subjectByIdsubject = subjectByIdsubject;
    }
}
