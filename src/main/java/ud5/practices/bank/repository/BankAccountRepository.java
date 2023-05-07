package ud5.practices.bank.repository;

import ud5.practices.bank.BankAccount;

import java.util.List;

public interface BankAccountRepository {
    List<BankAccount> getAll();
    BankAccount getBankAccountByNumber(String accontNumber);

    boolean updateAccountHolderName(BankAccount bankAccount);
}
