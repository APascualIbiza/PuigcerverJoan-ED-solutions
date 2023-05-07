package ud5.practices.bank.service;

import ud5.practices.bank.BankAccount;
import ud5.practices.bank.exception.BankAccountNotFoundException;
import ud5.practices.bank.exception.InvalidAccountHolderNameException;

import java.util.List;

public interface BankAccountService {
    List<BankAccount> getAll();

    BankAccount getBankAccountByNumber(String accountNumber) throws BankAccountNotFoundException;

    void updateHolderName(BankAccount bankAccount) throws InvalidAccountHolderNameException;
}
