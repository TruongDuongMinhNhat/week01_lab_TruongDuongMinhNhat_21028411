package dev.minhnhat.week01_lab_truongduongminhnhat_21028411;

import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.enums.AccountStatus;
import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.enums.RoleStatus;
import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.models.Account;
import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.models.GrantAccess;
import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.models.GrantAccessID;
import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.models.Role;
import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.repositories.impl.AccountRepository;
import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.repositories.impl.LogRepository;
import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.repositories.impl.RoleRepository;
import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.services.impl.AccountService;
import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.services.impl.GrantAccessService;
import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.services.impl.RoleService;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class ApplicationMain {

    public static void main(String[] args) throws Exception {
        EntityManager entityManager = Persistence.createEntityManagerFactory("week01").createEntityManager();

        //Role
        Role role_1 = new Role("ADMIN", "Administrator will control everything in system", RoleStatus.ACTIVE);
        Role role_2 = new Role("MANAGER", "Manager will be control the action from employee", RoleStatus.ACTIVE);
        Role role_3 = new Role("EMPLOYEE", "Do they work in website", RoleStatus.ACTIVE);
        Role role_4 = new Role("SALARY", "They will calculator, get information the number of works from employee", RoleStatus.ACTIVE);

        RoleService roleService = new RoleService();
        roleService.insert(role_1);
        roleService.insert(role_2);
        roleService.insert(role_3);
        roleService.insert(role_4);

        //Account
        Account account_1 = new Account("John Smith", "john123", "john@gmail.com", "0123456789", AccountStatus.ACTIVE);
        Account account_2 = new Account("Zack Witch", "zack123", "zack@gmail.com", "0987654321", AccountStatus.ACTIVE);
        Account account_3 = new Account("Emely Loyal", "emely123", "emely@gmail.com", "0246813579", AccountStatus.ACTIVE);
        Account account_4 = new Account("Timy Ime", "timy123", "timy@gmail.com", "0135792468", AccountStatus.ACTIVE);

        AccountService accountService = new AccountService();
        accountService.insert(account_1);
        accountService.insert(account_2);
        accountService.insert(account_3);
        accountService.insert(account_4);

        //Grant Access
        GrantAccess grantAccess_1 = new GrantAccess(account_1, role_1, true, "No Note");
        GrantAccess grantAccess_2 = new GrantAccess(account_2, role_2, true, "No Note");
        GrantAccess grantAccess_3 = new GrantAccess(account_3, role_3, true, "No Note");
        GrantAccess grantAccess_4 = new GrantAccess(account_4, role_4, true, "No Note");

        GrantAccessService grantAccessService = new GrantAccessService();
        grantAccessService.insert(grantAccess_1);
        grantAccessService.insert(grantAccess_2);
        grantAccessService.insert(grantAccess_3);
        grantAccessService.insert(grantAccess_4);
    }
}
