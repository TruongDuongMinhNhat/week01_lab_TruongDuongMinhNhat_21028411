package dev.minhnhat.week01_lab_truongduongminhnhat_21028411.services.impl;

import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.models.Account;
import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.models.Role;
import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.repositories.impl.RoleRepository;
import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.services.IServices;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

public class RoleService implements IServices<Role, Long> {
    private RoleRepository roleRepository;

    public RoleService() {
        roleRepository = new RoleRepository();
    }

    @Override
    public boolean insert(Role role) throws Exception {
        return roleRepository.insert(role);
    }

    @Override
    public boolean update(Role role) throws Exception {
        return roleRepository.update(role);
    }

    @Override
    public boolean delete(Role role) throws Exception {
        return roleRepository.delete(role);
    }

    @Override
    public Optional<Role> findById(Long id) throws Exception {
        return roleRepository.findById(id);
    }

    @Override
    public List<Role> findAll() throws Exception {
        return roleRepository.findAll();
    }

    public Role findByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName).orElse(null);
    }

    public String findAllByHtml() throws Exception {
        List<Role> roles = findAll();
        String result = "";
        for(Role role : roles) {
            result += ("<tr><td>"+ role.getId() +"</td><td>"+ role.getRoleName() +"</td><td>"+ role.getDescription() +"</td>" +
                    "<td>"+ role.getStatus().toString() +"</td>" +
                    "<td><form action='../../control-servlet/update/role' method='get'><input type='submit' name='action' value='Update Role "+ role.getId() +"'></form></td>" +
                    "<td><form action='../../control-servlet/delete/role' method='post'><input type='submit' name='action' value='Delete Role "+ role.getId() +"'></form></td></tr>");
        }
        return result;
    }
}
