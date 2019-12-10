package wizard.dao2;

import javax.persistence.*;

@Entity
public class Members {
    private int idmember;
    private String nif;
    private String fullname;
    private String adress;
    private String phone;
    private String dateOfBirth;
    private User userByUsername;

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
    @Column(name = "date_of_birth", nullable = true, length = 45)
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Members members = (Members) o;

        if (idmember != members.idmember) return false;
        if (nif != null ? !nif.equals(members.nif) : members.nif != null) return false;
        if (fullname != null ? !fullname.equals(members.fullname) : members.fullname != null) return false;
        if (adress != null ? !adress.equals(members.adress) : members.adress != null) return false;
        if (phone != null ? !phone.equals(members.phone) : members.phone != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(members.dateOfBirth) : members.dateOfBirth != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idmember;
        result = 31 * result + (nif != null ? nif.hashCode() : 0);
        result = 31 * result + (fullname != null ? fullname.hashCode() : 0);
        result = 31 * result + (adress != null ? adress.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    public User getUserByUsername() {
        return userByUsername;
    }

    public void setUserByUsername(User userByUsername) {
        this.userByUsername = userByUsername;
    }
}
