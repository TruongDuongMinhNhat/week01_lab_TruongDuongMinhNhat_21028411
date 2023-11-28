package dev.minhnhat.week01_lab_truongduongminhnhat_21028411.services.impl;

import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.models.Account;
import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.repositories.impl.AccountRepository;
import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.services.IServices;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

public class AccountService implements IServices<Account, Long> {
    private AccountRepository accountRepository;
    public AccountService() {
        accountRepository = new AccountRepository();
    }

    @Override
    public boolean insert(Account account) throws Exception {
        return accountRepository.insert(account);
    }

    @Override
    public boolean update(Account account) throws Exception {
        return accountRepository.update(account);
    }

    @Override
    public boolean delete(Account account) throws Exception {
        return accountRepository.delete(account);
    }

    @Override
    public Optional<Account> findById(Long id) throws Exception {
        return accountRepository.findById(id);
    }

    @Override
    public List<Account> findAll() throws Exception {
        return accountRepository.findAll();
    }

    public Account checkLogin(String email, String password) {
        return accountRepository.findAccountByEmailAndPassword(email,password).orElse(null);
    }
}
