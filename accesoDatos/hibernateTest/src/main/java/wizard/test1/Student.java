package wizard.test1;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Student {
  private int idstudent;
  private Integer schoolYear;
  private Collection<Enroll> enrollsByIdstudent;
  private Members membersByIdstudent;

  @Id
  @Column(name = "idstudent", nullable = false)
  public int getIdstudent() {
    return idstudent;
  }

  public void setIdstudent(int idstudent) {
    this.idstudent = idstudent;
  }

  @Basic
  @Column(name = "school_year", nullable = true)
  public Integer getSchoolYear() {
    return schoolYear;
  }

  public void setSchoolYear(Integer schoolYear) {
    this.schoolYear = schoolYear;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Student student = (Student) o;
    return idstudent == student.idstudent &&
        Objects.equals(schoolYear, student.schoolYear);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idstudent, schoolYear);
  }

  @OneToMany(mappedBy = "studentByIdstudent")
  public Collection<Enroll> getEnrollsByIdstudent() {
    return enrollsByIdstudent;
  }

  public void setEnrollsByIdstudent(Collection<Enroll> enrollsByIdstudent) {
    this.enrollsByIdstudent = enrollsByIdstudent;
  }

  @OneToOne
  @JoinColumn(name = "idstudent", referencedColumnName = "idmember", nullable = false)
  public Members getMembersByIdstudent() {
    return membersByIdstudent;
  }

  public void setMembersByIdstudent(Members membersByIdstudent) {
    this.membersByIdstudent = membersByIdstudent;
  }
}
