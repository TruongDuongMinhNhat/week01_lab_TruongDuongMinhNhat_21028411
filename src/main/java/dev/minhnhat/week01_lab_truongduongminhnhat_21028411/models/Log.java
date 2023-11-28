package dev.minhnhat.week01_lab_truongduongminhnhat_21028411.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity @Table(name = "log")
@Getter @Setter @NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "Log.findById", query = "from Log where id =: id"),
        @NamedQuery(name = "Log.findAll", query = "from Log")
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

    public Log(Account account, LocalDateTime logIn, LocalDateTime logOut, String note) {
        this.account = account;
        this.logIn = logIn;
        this.logOut = logOut;
        this.note = note;
    }
}
