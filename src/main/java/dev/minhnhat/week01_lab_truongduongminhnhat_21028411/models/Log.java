package dev.minhnhat.week01_lab_truongduongminhnhat_21028411.models;

import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity @Table(name = "log")
@NamedQueries({
        @NamedQuery(name = "Log.findById", query = "from Log where id =: id"),
        @NamedQuery(name = "Log.findAll", query = "from Log"),
        @NamedQuery(name = "Log.findByAccount", query = "from Log where account =: account")
})
public class Log {
    @Id
    @Column(name = "log_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;
    @Column(name = "log_in")
    private LocalDateTime logIn;
    @Column(name = "log_out")
    private LocalDateTime logOut;
    private String note;
    public Log() {
    }

    public Log(Account account, LocalDateTime logIn, LocalDateTime logOut, String note) {
        this.account = account;
        this.logIn = logIn;
        this.logOut = logOut;
        this.note = note;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public LocalDateTime getLogIn() {
        return logIn;
    }

    public void setLogIn(LocalDateTime logIn) {
        this.logIn = logIn;
    }

    public LocalDateTime getLogOut() {
        return logOut;
    }

    public void setLogOut(LocalDateTime logOut) {
        this.logOut = logOut;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
