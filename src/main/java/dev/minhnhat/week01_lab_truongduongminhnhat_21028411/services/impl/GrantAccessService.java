package dev.minhnhat.week01_lab_truongduongminhnhat_21028411.services.impl;

import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.models.GrantAccess;
import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.models.GrantAccessID;
import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.repositories.impl.GrantAccessRepository;
import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.services.IServices;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

public class GrantAccessService implements IServices<GrantAccess, GrantAccessID> {
    private GrantAccessRepository grantAccessRepository;
    public GrantAccessService() throws Exception{
        grantAccessRepository = new GrantAccessRepository();
    }

    @Override
    public boolean insert(GrantAccess grantAccess) throws Exception {
        return grantAccessRepository.insert(grantAccess);
    }

    @Override
    public boolean update(GrantAccess grantAccess) throws Exception {
        return grantAccessRepository.update(grantAccess);
    }

    @Override
    public boolean delete(GrantAccess grantAccess) throws Exception {
        return grantAccessRepository.delete(grantAccess);
    }

    @Override
    public Optional<GrantAccess> findById(GrantAccessID grantAccessID) throws Exception {
        return grantAccessRepository.findById(grantAccessID);
    }

    @Override
    public List<GrantAccess> findAll() throws Exception {
        return grantAccessRepository.findAll();
    }
}
