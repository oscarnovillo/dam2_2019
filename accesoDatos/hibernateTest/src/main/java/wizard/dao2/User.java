package wizard.dao2;

import javax.persistence.*;

@Entity
public class User {
    private String username;
    private String passwd;
    private Typeuser typeuserByIdtypeuser;

    @Id
    @Column(name = "username", nullable = false, length = 45)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "passwd", nullable = true, length = 45)
    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (passwd != null ? !passwd.equals(user.passwd) : user.passwd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (passwd != null ? passwd.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idtypeuser", referencedColumnName = "idtypeuser")
    public Typeuser getTypeuserByIdtypeuser() {
        return typeuserByIdtypeuser;
    }

    public void setTypeuserByIdtypeuser(Typeuser typeuserByIdtypeuser) {
        this.typeuserByIdtypeuser = typeuserByIdtypeuser;
    }
}
