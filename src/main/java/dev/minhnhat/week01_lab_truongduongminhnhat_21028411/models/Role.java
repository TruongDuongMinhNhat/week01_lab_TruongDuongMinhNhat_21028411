package dev.minhnhat.week01_lab_truongduongminhnhat_21028411.models;

import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.enums.RoleStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity @Table(name = "role")
@NamedQueries({
        @NamedQuery(name = "Role.findById", query = "from Role where id =: id"),
        @NamedQuery(name = "Role.findAll", query = "from Role"),
        @NamedQuery(name = "Role.findByRoleName", query = "from Role where roleName =: roleName")
})
public class Role {
    @Id
    @Column(name = "role_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "role_name", nullable = false, unique = true)
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

    public Role() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RoleStatus getStatus() {
        return status;
    }

    public void setStatus(RoleStatus status) {
        this.status = status;
    }

    public List<GrantAccess> getGrantAccesses() {
        return grantAccesses;
    }

    public void setGrantAccesses(List<GrantAccess> grantAccesses) {
        this.grantAccesses = grantAccesses;
    }
}
