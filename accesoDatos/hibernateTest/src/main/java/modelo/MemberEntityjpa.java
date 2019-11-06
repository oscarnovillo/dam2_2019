package modelo;

import javax.persistence.*;
import java.sql.Date;



@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name= "member")
public class MemberEntityjpa {

  private int idmember;
  private String nif;
  private String name;
  private String address;
  private String telephonenum;
  private Date dateofbirth;
  private UserEntityjpa userByIduser;

  @Basic
  @Column(table="member" ,name = "NIF", nullable = false, length = 11)
  public String getNif() {
    return nif;
  }

  public void setNif(String nif) {
    this.nif = nif;
  }

  @Basic
  @Column(table="member" ,name = "name", nullable = false, length = 100)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Basic
  @Column(table="member" ,name = "address", nullable = false, length = 100)
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Basic
  @Column(name = "telephonenum", nullable = false, length = 45)
  public String getTelephonenum() {
    return telephonenum;
  }

  public void setTelephonenum(String telephonenum) {
    this.telephonenum = telephonenum;
  }

  @Basic
  @Column(name = "dateofbirth", nullable = false)
  public Date getDateofbirth() {
    return dateofbirth;
  }

  public void setDateofbirth(Date dateofbirth) {
    this.dateofbirth = dateofbirth;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    MemberEntityjpa that = (MemberEntityjpa) o;


    if (nif != null ? !nif.equals(that.nif) : that.nif != null) {
      return false;
    }
    if (name != null ? !name.equals(that.name) : that.name != null) {
      return false;
    }
    if (address != null ? !address.equals(that.address) : that.address != null) {
      return false;
    }
    if (telephonenum != null ? !telephonenum.equals(that.telephonenum) : that.telephonenum != null) {
      return false;
    }
    if (dateofbirth != null ? !dateofbirth.equals(that.dateofbirth) : that.dateofbirth != null) {
      return false;
    }

    return true;
  }

  @Override
  public String toString() {
    return "MemberEntityjpa{" +
" idmember ='" + idmember + '\'' +
        "nif='" + nif + '\'' +
        ", name='" + name + '\'' +
        ", address='" + address + '\'' +
        ", telephonenum='" + telephonenum + '\'' +
        ", dateofbirth=" + dateofbirth +
        ", userByIduser=" + userByIduser +
        '}';
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (nif != null ? nif.hashCode() : 0);
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    result = 31 * result + (telephonenum != null ? telephonenum.hashCode() : 0);
    result = 31 * result + (dateofbirth != null ? dateofbirth.hashCode() : 0);
    return result;
  }

  @OneToOne
  @JoinColumn(name = "iduser", referencedColumnName = "iduser", nullable = false)
  public UserEntityjpa getUserByIduser() {
    return userByIduser;
  }

  public void setUserByIduser(UserEntityjpa userByIduser) {
    this.userByIduser = userByIduser;
  }

  @Id
  @Column(name = "idmember", nullable = false)
  public int getIdmember() {
    return idmember;
  }

  public void setIdmember(int idmember) {
    this.idmember = idmember;
  }
}
