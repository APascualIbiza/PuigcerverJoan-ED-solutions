package ud5.practices.bank.service;

import ud5.practices.bank.BankAccount;
import ud5.practices.bank.exception.BankAccountNotFoundException;
import ud5.practices.bank.exception.InvalidAccountHolderNameException;
import ud5.practices.bank.repository.BankAccountRepository;

import java.util.Comparator;
import java.util.List;

public class BankAccountServiceImpl implements BankAccountService {
    private BankAccountRepository bankAccountRepository;
    private NotificationService notificationService;

    public BankAccountServiceImpl() {
    }

    public List<BankAccount> getAll() {
        List<BankAccount> bankAccounts = bankAccountRepository.getAll();
        bankAccounts.sort(Comparator.comparing(BankAccount::getAccountNumber));
        return bankAccounts;
    }

    public BankAccount getBankAccountByNumber(String accountNumber) throws BankAccountNotFoundException {
        BankAccount bankAccount = bankAccountRepository.getBankAccountByNumber(accountNumber);
        if (bankAccount == null) {
            throw new BankAccountNotFoundException("Invalid account number: " + accountNumber);
        }
        return bankAccount;
    }

    public void updateHolderName(BankAccount bankAccount) throws InvalidAccountHolderNameException {
        if (bankAccount.getAccountHolderName().length() < 3) {
            throw new InvalidAccountHolderNameException("Holder name must be at least 3 characters long");
        }
        notificationService.notifyUpdateAccountHolderName(bankAccount);
        bankAccountRepository.updateAccountHolderName(bankAccount);
    }
}