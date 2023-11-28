package dev.minhnhat.week01_lab_truongduongminhnhat_21028411.models;

import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.enums.RoleStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity @Table(name = "role")
@Getter @Setter @NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "Role.findById", query = "from Role where id =: id"),
        @NamedQuery(name = "Role.findAll", query = "from Role")
})
public class Role {
    @Id
    @Column(name = "role_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "role_name", nullable = false)
    private String roleName;
    private String description;
    @Enumerated(EnumType.ORDINAL)
    private RoleStatus status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grantAccessID.role")
    private List<GrantAccess> grantAccesses;

    public Role(String roleName, String description, RoleStatus status) {
        this.roleName = roleName;
        this.description = description;
        this.status = status;
    }
}
