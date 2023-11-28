package dev.minhnhat.week01_lab_truongduongminhnhat_21028411.models;

import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.enums.AccountStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity @Table(name = "account")
@Getter @Setter @NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "Account.findById", query = "from Account where id =: id"),
        @NamedQuery(name = "Account.findAll", query = "from Account")
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
    private String email;
    @Column(nullable = false)
    private String phone;
    @Enumerated(EnumType.ORDINAL)
    private AccountStatus status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grantAccessID.account")
    private List<GrantAccess> grantAccesses;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    private List<Log> logs;

    public Account(String fullName, String password, String email, String phone, AccountStatus status) {
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.status = status;
    }
}
