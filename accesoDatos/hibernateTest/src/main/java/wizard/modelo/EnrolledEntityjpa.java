package wizard.modelo;

import javax.persistence.*;

@Entity
@Table(name = "enrolled", schema = "test", catalog = "")
public class EnrolledEntityjpa {
  private int idenrolled;
  private Double mark1;
  private Double mark2;
  private Double mark3;
  private Double mark4;
  private SubjectEntityjpa subjectByIdsubject;
  private StudentEntityjpa studentByIdstudient;

  @Id
  @Column(name = "idenrolled", nullable = false)
  public int getIdenrolled() {
    return idenrolled;
  }

  public void setIdenrolled(int idenrolled) {
    this.idenrolled = idenrolled;
  }

  @Basic
  @Column(name = "mark1", nullable = true, precision = 0)
  public Double getMark1() {
    return mark1;
  }

  public void setMark1(Double mark1) {
    this.mark1 = mark1;
  }

  @Basic
  @Column(name = "mark2", nullable = true, precision = 0)
  public Double getMark2() {
    return mark2;
  }

  public void setMark2(Double mark2) {
    this.mark2 = mark2;
  }

  @Basic
  @Column(name = "mark3", nullable = true, precision = 0)
  public Double getMark3() {
    return mark3;
  }

  public void setMark3(Double mark3) {
    this.mark3 = mark3;
  }

  @Basic
  @Column(name = "mark4", nullable = true, precision = 0)
  public Double getMark4() {
    return mark4;
  }

  public void setMark4(Double mark4) {
    this.mark4 = mark4;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    EnrolledEntityjpa that = (EnrolledEntityjpa) o;

    if (idenrolled != that.idenrolled) {
      return false;
    }
    if (mark1 != null ? !mark1.equals(that.mark1) : that.mark1 != null) {
      return false;
    }
    if (mark2 != null ? !mark2.equals(that.mark2) : that.mark2 != null) {
      return false;
    }
    if (mark3 != null ? !mark3.equals(that.mark3) : that.mark3 != null) {
      return false;
    }
    if (mark4 != null ? !mark4.equals(that.mark4) : that.mark4 != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = idenrolled;
    result = 31 * result + (mark1 != null ? mark1.hashCode() : 0);
    result = 31 * result + (mark2 != null ? mark2.hashCode() : 0);
    result = 31 * result + (mark3 != null ? mark3.hashCode() : 0);
    result = 31 * result + (mark4 != null ? mark4.hashCode() : 0);
    return result;
  }

  @ManyToOne
  @JoinColumn(name = "idsubject", referencedColumnName = "idsubject", nullable = false)
  public SubjectEntityjpa getSubjectByIdsubject() {
    return subjectByIdsubject;
  }

  public void setSubjectByIdsubject(SubjectEntityjpa subjectByIdsubject) {
    this.subjectByIdsubject = subjectByIdsubject;
  }

  @ManyToOne
  @JoinColumn(name = "idstudient", referencedColumnName = "idstudent", nullable = false)
  public StudentEntityjpa getStudentByIdstudient() {
    return studentByIdstudient;
  }

  public void setStudentByIdstudient(StudentEntityjpa studentByIdstudient) {
    this.studentByIdstudient = studentByIdstudient;
  }
}
