package dev.minhnhat.week01_lab_truongduongminhnhat_21028411.services.impl;

import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.models.Account;
import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.models.GrantAccess;
import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.models.GrantAccessID;
import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.models.Role;
import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.repositories.impl.GrantAccessRepository;
import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.services.IServices;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

public class GrantAccessService implements IServices<GrantAccess, GrantAccessID> {
    private GrantAccessRepository grantAccessRepository;
    public GrantAccessService(){
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

    public GrantAccess findById(Account account, Role role) {
        Optional<GrantAccess> grantAccess = grantAccessRepository.findById(account, role);
        return grantAccess == null ? null : grantAccess.get();
    }

    @Override
    public List<GrantAccess> findAll() throws Exception {
        return grantAccessRepository.findAll();
    }

    public String findAllByHtml() throws Exception{
        List<GrantAccess> grantAccesses = findAll();
        String result = "";
        for(GrantAccess grantAccess : grantAccesses) {
            result += ("<tr><td>"+ grantAccess.getGrantAccessID().getAccount().getId() + " - " + grantAccess.getGrantAccessID().getAccount().getFullName() +"</td>" +
                    "<td>" + grantAccess.getGrantAccessID().getRole().getId() + " - " + grantAccess.getGrantAccessID().getRole().getRoleName() + "</td>" +
                    "<td>" + grantAccess.isGrant() + "</td><td>" + grantAccess.getNote() + "</td>" +
                    "<td><form action='../../control-servlet/update/grant-access' method='get'><input type='hidden' name='account_role' value='" + grantAccess.getGrantAccessID().getAccount().getId() + "_" + grantAccess.getGrantAccessID().getRole().getId() + "'>" +
                    "<input type='submit' name='action' value='Update Grant'></form></td>" +
                    "<td><form action='../../control-servlet/update/grant-access' method='get'><input type='hidden' name='account_role' value='" + grantAccess.getGrantAccessID().getAccount().getId() + "_" + grantAccess.getGrantAccessID().getRole().getId() + "'>" +
                    "<input type='submit' name='action' value='Delete Grant'></form></td>");
        }
        return result;
    }
}
