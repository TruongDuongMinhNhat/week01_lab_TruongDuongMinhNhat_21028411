package dev.minhnhat.week01_lab_truongduongminhnhat_21028411.models;

import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.enums.AccountStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity @Table(name = "account")
@NamedQueries({
        @NamedQuery(name = "Account.findById", query = "from Account where id =: id"),
        @NamedQuery(name = "Account.findAll", query = "from Account"),
        @NamedQuery(name = "Account.findAccountByEmailAndPassword", query = "from Account where email =: email and password =: password")
})
public class Account {
    @Id
    @Column(name = "account_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "full_name", nullable = false)
    private String fullName;
    @Column(nullable = false)
    private String password;
    @Column(unique = true)
    private String email;
    @Column(nullable = false)
    private String phone;
    @Enumerated(EnumType.ORDINAL)
    private AccountStatus status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grantAccessID.account")
    private List<GrantAccess> grantAccesses;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    private List<Log> logs;

    public Account() {
    }

    public Account(String fullName, String password, String email, String phone, AccountStatus status) {
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public List<GrantAccess> getGrantAccesses() {
        return grantAccesses;
    }

    public void setGrantAccesses(List<GrantAccess> grantAccesses) {
        this.grantAccesses = grantAccesses;
    }

    public List<Log> getLogs() {
        return logs;
    }

    public void setLogs(List<Log> logs) {
        this.logs = logs;
    }

    public String getAllPermissionByHtml() {
        String result = "";
        for(GrantAccess grantAccess : grantAccesses) {
            result += (grantAccess.getGrantAccessID().getRole().getRoleName() + "<br/>");
        }
        return result;
    }
}
