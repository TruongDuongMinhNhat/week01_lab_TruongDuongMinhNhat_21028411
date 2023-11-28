package dev.minhnhat.week01_lab_truongduongminhnhat_21028411.services.impl;

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
}
