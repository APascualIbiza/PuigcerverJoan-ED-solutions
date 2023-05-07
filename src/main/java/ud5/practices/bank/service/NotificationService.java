package ud5.practices.bank.service;

import ud5.practices.bank.BankAccount;

public interface NotificationService {
    void notifyUpdateAccountHolderName(BankAccount bankAccount);
}
