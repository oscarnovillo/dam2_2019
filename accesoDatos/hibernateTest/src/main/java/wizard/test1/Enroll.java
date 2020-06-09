package wizard.test1;


import org.apache.logging.log4j.LogManager;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Enroll {
  private int idenroll;
  private Integer ncalls;
  private Integer mark;
  private Student studentByIdstudent;
  private Subject subjectByIdsubject;

  @Id
  @Column(name = "idenroll", nullable = false)
  public int getIdenroll() {
    return idenroll;
  }

  public void setIdenroll(int idenroll) {
    this.idenroll = idenroll;
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
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LogManager.getLogger(Enroll.class)
        .error("esto es un error");

    Enroll enroll = (Enroll) o;
    return idenroll == enroll.idenroll &&
        Objects.equals(ncalls, enroll.ncalls) &&
        Objects.equals(mark, enroll.mark);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idenroll, ncalls, mark);
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
  @JoinColumn(name = "idsubject",referencedColumnName = "idsubject", nullable = false)
  public Subject getSubjectByIdsubject() {
    return subjectByIdsubject;
  }

  public void setSubjectByIdsubject(Subject subjectByIdsubject) {
    this.subjectByIdsubject = subjectByIdsubject;
  }
}
