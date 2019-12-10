package wizard.modelo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "student")
@PrimaryKeyJoinColumn(name = "idstudent")
public class StudentEntityjpa extends MemberEntityjpa{

  private Date schoolYear;
  private Collection<EnrolledEntityjpa> enrolledsByIdstudent;



  @Basic
  @Column(name = "schoolYear", nullable = false)
  public Date getSchoolYear() {
    return schoolYear;
  }

  public void setSchoolYear(Date schoolYear) {
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

    StudentEntityjpa that = (StudentEntityjpa) o;


    if (schoolYear != null ? !schoolYear.equals(that.schoolYear) : that.schoolYear != null) {
      return false;
    }

    return true;
  }

  @Override
  public String toString() {
    return "StudentEntityjpa{" +

        ", schoolYear=" + schoolYear +

        "} " + super.toString();
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (schoolYear != null ? schoolYear.hashCode() : 0);
    return result;
  }

  @OneToMany(mappedBy = "studentByIdstudient")
  public Collection<EnrolledEntityjpa> getEnrolledsByIdstudent() {
    return enrolledsByIdstudent;
  }

  public void setEnrolledsByIdstudent(Collection<EnrolledEntityjpa> enrolledsByIdstudent) {
    this.enrolledsByIdstudent = enrolledsByIdstudent;
  }
}
