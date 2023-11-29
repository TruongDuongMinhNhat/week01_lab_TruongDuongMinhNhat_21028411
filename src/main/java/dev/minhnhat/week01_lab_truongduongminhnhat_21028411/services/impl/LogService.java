package dev.minhnhat.week01_lab_truongduongminhnhat_21028411.services.impl;

import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.models.Account;
import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.models.Log;
import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.repositories.impl.LogRepository;
import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.services.IServices;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

public class LogService implements IServices<Log, Long> {
    private LogRepository logRepository;
    public LogService() {
        logRepository = new LogRepository();
    }
    @Override
    public boolean insert(Log log) throws Exception {
        return logRepository.insert(log);
    }

    @Override
    public boolean update(Log log) throws Exception {
        return logRepository.update(log);
    }

    @Override
    public boolean delete(Log log) throws Exception {
        return logRepository.delete(log);
    }

    @Override
    public Optional<Log> findById(Long id) throws Exception {
        return logRepository.findById(id);
    }

    @Override
    public List<Log> findAll() throws Exception {
        return logRepository.findAll();
    }

    public String findAllByHtml() throws Exception {
        List<Log> logs = findAll();
        String result = "";
        for(Log log : logs) {
            result += ("<tr><td>" + log.getId() + "</td><td>" + log.getAccount().getId() + "-" + log.getAccount().getFullName() + "</td>" +
                    "<td>" + log.getLogIn() + "</td><td>" + log.getLogOut() + "</td><td>" + log.getNote() + "</td></tr>");
        }
        return result;
    }

    public Log findByAccount(Account account) {
        return logRepository.findByAccountWithLogInNearest(account).get();
    }
}
