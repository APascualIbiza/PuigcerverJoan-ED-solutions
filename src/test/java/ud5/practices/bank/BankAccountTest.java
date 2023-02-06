package ud5.practices.bank;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Nested
    class DepositTests {
        BankAccount bankAccount;

        @BeforeEach
        void setup(){
            this.bankAccount = new BankAccount("1234", "Test");
        }

        @ParameterizedTest(name="Deposit {0}")
        @DisplayName("Ingrés vàlid")
        @ValueSource(doubles = {50, 100, 150, 200})
        void deposit(double amount){
            boolean hasDeposited = bankAccount.deposit(amount);
            Transaction lastTransaction = bankAccount.getLastTransaction();
            assertAll(
                () -> assertTrue(hasDeposited),
                () -> assertNotNull(lastTransaction),
                () -> assertEquals(amount, bankAccount.getBalance()),
                () -> assertEquals(amount, lastTransaction.getAmount()),
                () -> assertEquals(TransactionType.DEPOSIT, lastTransaction.getTransactionType())
            );
        }

        void withdraw120(){
            this.bankAccount.deposit(100);
            double balanceBefore = bankAccount.getBalance();
            Transaction lastTransactionBefore = bankAccount.getLastTransaction();
            boolean hasWithdrawn = bankAccount.withdraw(120);
            double balanceAfter = bankAccount.getBalance();
            Transaction lastTransactionAfter = bankAccount.getLastTransaction();
            assertAll(
                    () -> assertEquals(balanceBefore, balanceAfter),
                    () -> assertSame(lastTransactionBefore, lastTransactionAfter),
                    () -> assertFalse(hasWithdrawn)
            );
        }
    }

}