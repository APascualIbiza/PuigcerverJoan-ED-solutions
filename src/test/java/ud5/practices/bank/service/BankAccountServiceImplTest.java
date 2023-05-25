package ud5.practices.bank.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ud5.practices.bank.BankAccount;
import ud5.practices.bank.exception.BankAccountNotFoundException;
import ud5.practices.bank.exception.InvalidAccountHolderNameException;
import ud5.practices.bank.repository.BankAccountRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BankAccountServiceImplTest {
    @Mock
    private BankAccountRepository bankAccountRepository;

    @Mock
    private NotificationService notificationService;

    @InjectMocks
    private BankAccountServiceImpl bankAccountService;

    @Test
    void getAll_givenUnorderedList_shouldReturnOrderedList(){
        List<BankAccount> unorderedList = new ArrayList<>(List.of(
                new BankAccount("0001", "Holder1"),
                new BankAccount("0010", "Holder10"),
                new BankAccount("0005", "Holder5"),
                new BankAccount("0002", "Holder2"),
                new BankAccount("0004", "Holder4"),
                new BankAccount("0009", "Holder9"),
                new BankAccount("0007", "Holder7")
        ));

        List<BankAccount> expectedList = unorderedList.stream()
                            .sorted(Comparator.comparing(BankAccount::getAccountNumber))
                            .toList();

        when(bankAccountRepository.getAll()).thenReturn(unorderedList);

        List<BankAccount> actualList = bankAccountService.getAll();

        assertEquals(expectedList, actualList);
    }

    @Test
    void getBankAccountByNumber_givenExistingAccountNumber_shouldReturnBankAccount() throws BankAccountNotFoundException {
        BankAccount expectedBankAccount = new BankAccount("0001", "Holder1");

        when(bankAccountRepository.getBankAccountByNumber(expectedBankAccount.getAccountNumber()))
                .thenReturn(expectedBankAccount);

        BankAccount actualBankAccount = bankAccountService.getBankAccountByNumber(expectedBankAccount.getAccountNumber());

        assertSame(expectedBankAccount, actualBankAccount);
    }

    @Test
    void getBankAccountByNumber_givenNonExistingAccountNumber_shouldThrowException() {
        when(bankAccountRepository.getBankAccountByNumber("-1"))
                .thenReturn(null);

        assertThrows(
                BankAccountNotFoundException.class,
                () -> bankAccountService.getBankAccountByNumber("-1")
        );
    }

    @Test
    void updateHolderName_givenValidHolderName_shouldUpdateHolderName() throws InvalidAccountHolderNameException {
        BankAccount bankAccount = new BankAccount("0001", "Holder1");

        assertAll(
                () -> assertDoesNotThrow(
                        () -> bankAccountService.updateHolderName(bankAccount)
                ),
                () -> verify(bankAccountRepository).updateAccountHolderName(bankAccount),
                () -> verify(notificationService).notifyUpdateAccountHolderName(bankAccount)
        );
    }

    @Test
    void updateHolderName_givenNonValidHolderName_shouldThrowException() {
        BankAccount bankAccount = new BankAccount("0001", "Ho");

        assertAll(
                () -> assertThrows(
                        InvalidAccountHolderNameException.class,
                        () -> bankAccountService.updateHolderName(bankAccount)
                ),
                () -> verify(bankAccountRepository, never()).updateAccountHolderName(bankAccount),
                () -> verify(notificationService, never()).notifyUpdateAccountHolderName(bankAccount)
        );
    }
}