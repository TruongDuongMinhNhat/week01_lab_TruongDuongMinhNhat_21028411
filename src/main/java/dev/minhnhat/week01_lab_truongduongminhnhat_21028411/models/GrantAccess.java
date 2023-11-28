package dev.minhnhat.week01_lab_truongduongminhnhat_21028411.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Table(name = "grant_access")
@Getter @Setter @NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "GrantAccess.findById", query = "from GrantAccess where grantAccessID.account =: account and grantAccessID.role =: role"),
        @NamedQuery(name = "GrantAccess.findAll", query = "from GrantAccess")
})
public class GrantAccess {

    @EmbeddedId
    private GrantAccessID grantAccessID;

    @Column(name = "is_grant", nullable = false)
    private boolean grant;
    private String note;

    public GrantAccess(Account account, Role role, boolean grant, String note) {
        grantAccessID = new GrantAccessID(account, role);
        this.grant = grant;
        this.note = note;
    }
}
