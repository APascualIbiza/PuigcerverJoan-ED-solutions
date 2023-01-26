package ud5.practices.bank;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Nested
    class DepositTests {
        BankAccount bankAccount;

        @BeforeEach
        void setup(){
            this.bankAccount = new BankAccount("1234", "Test");
        }

        @Test
        @DisplayName("Ingrés de 100€")
        void deposit100(){
            boolean hasDeposited = bankAccount.deposit(100);
            Transaction lastTransaction = bankAccount.getLastTransaction();
            assertAll(
                () -> assertTrue(hasDeposited),
                () -> assertNotNull(lastTransaction),
                () -> assertEquals(100, bankAccount.getBalance()),
                () -> assertEquals(100, lastTransaction.getAmount()),
                () -> assertEquals(TransactionType.DEPOSIT, lastTransaction.getTransactionType())
            );
        }
    }

}