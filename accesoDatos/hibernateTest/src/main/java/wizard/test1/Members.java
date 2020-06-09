package wizard.test1;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Members {
  private int idmember;
  private String nif;
  private String fullname;
  private String adress;
  private String phone;
  private Date dateOfBirth;
  private User userByUsername;
  private Student student;
  private Teacher teacherByIdmember;

  @Id
  @Column(name = "idmember", nullable = false)
  public int getIdmember() {
    return idmember;
  }

  public void setIdmember(int idmember) {
    this.idmember = idmember;
  }

  @Basic
  @Column(name = "nif", nullable = true, length = 45)
  public String getNif() {
    return nif;
  }

  public void setNif(String nif) {
    this.nif = nif;
  }

  @Basic
  @Column(name = "fullname", nullable = true, length = 45)
  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

  @Basic
  @Column(name = "adress", nullable = true, length = 45)
  public String getAdress() {
    return adress;
  }

  public void setAdress(String adress) {
    this.adress = adress;
  }

  @Basic
  @Column(name = "phone", nullable = true, length = 45)
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @Basic
  @Column(name = "date_of_birth", nullable = true)
  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Members members = (Members) o;
    return idmember == members.idmember &&
        Objects.equals(nif, members.nif) &&
        Objects.equals(fullname, members.fullname) &&
        Objects.equals(adress, members.adress) &&
        Objects.equals(phone, members.phone) &&
        Objects.equals(dateOfBirth, members.dateOfBirth);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idmember, nif, fullname, adress, phone, dateOfBirth);
  }

  @ManyToOne
  @JoinColumn(name = "username", referencedColumnName = "username")
  public User getUserByUsername() {
    return userByUsername;
  }

  public void setUserByUsername(User userByUsername) {
    this.userByUsername = userByUsername;
  }

  @OneToOne(mappedBy = "membersByIdstudent")
  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  @OneToOne(mappedBy = "membersByIdteacher")
  public Teacher getTeacherByIdmember() {
    return teacherByIdmember;
  }

  public void setTeacherByIdmember(Teacher teacherByIdmember) {
    this.teacherByIdmember = teacherByIdmember;
  }
}
