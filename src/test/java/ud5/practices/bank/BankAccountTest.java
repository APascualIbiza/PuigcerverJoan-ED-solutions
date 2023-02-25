package ud5.practices.bank;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Nested
    class ConstructorTests {
        @Test
        void defaultConstructor(){
            BankAccount bankAccount = new BankAccount("1234", "TestName");
            assertAll(
                    () -> assertEquals("1234", bankAccount.getAccountNumber()),
                    () -> assertEquals("TestName", bankAccount.getAccountHolderName()),
                    () -> assertEquals(0, bankAccount.getBalance()),
                    () -> assertTrue(bankAccount.getTransactions().isEmpty())
            );
        }

        @Test
        void validAmountConstructor(){
            BankAccount bankAccount = new BankAccount("1234", "TestName", 100);
            Transaction lastTransaction = bankAccount.getLastTransaction();
            assertAll(
                    () -> assertEquals("1234", bankAccount.getAccountNumber()),
                    () -> assertEquals("TestName", bankAccount.getAccountHolderName()),
                    () -> assertEquals(100, bankAccount.getBalance()),
                    () -> assertNotNull(lastTransaction),
                    () -> assertEquals(100, lastTransaction.getAmount()),
                    () -> assertEquals(TransactionType.DEPOSIT, lastTransaction.getTransactionType())
            );
        }

        @Test
        void zeroAmountConstructor(){
            BankAccount bankAccount = new BankAccount("1234", "TestName", 0);
            assertAll(
                    () -> assertEquals("1234", bankAccount.getAccountNumber()),
                    () -> assertEquals("TestName", bankAccount.getAccountHolderName()),
                    () -> assertEquals(0, bankAccount.getBalance()),
                    () -> assertTrue(bankAccount.getTransactions().isEmpty())
            );
        }

        @Test
        void negativeAmountConstructor(){
            BankAccount bankAccount = new BankAccount("1234", "TestName", -10);
            assertAll(
                    () -> assertEquals("1234", bankAccount.getAccountNumber()),
                    () -> assertEquals("TestName", bankAccount.getAccountHolderName()),
                    () -> assertEquals(0, bankAccount.getBalance()),
                    () -> assertTrue(bankAccount.getTransactions().isEmpty())
            );
        }
    }

    @Nested
    class DepositTests {
        BankAccount bankAccount;

        @BeforeEach
        void setup(){
            this.bankAccount = new BankAccount("1234", "TestName");
        }

        @ParameterizedTest(name="Deposit {0}")
        @DisplayName("Ingrés vàlid")
        @ValueSource(doubles = {50, 100, 150, 200})
        void validDeposit(double amount){
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

        @DisplayName("Ingrés zero")
        @Test
        void zeroDeposit(){
            boolean hasDeposited = bankAccount.deposit(0);
            Transaction lastTransaction = bankAccount.getLastTransaction();
            assertAll(
                    () -> assertFalse(hasDeposited),
                    () -> assertNull(lastTransaction),
                    () -> assertEquals(0, bankAccount.getBalance())
            );
        }

        @DisplayName("Ingrés negatiu")
        @Test
        void negativeDeposit(){
            boolean hasDeposited = bankAccount.deposit(-10);
            Transaction lastTransaction = bankAccount.getLastTransaction();
            assertAll(
                    () -> assertFalse(hasDeposited),
                    () -> assertNull(lastTransaction),
                    () -> assertEquals(0, bankAccount.getBalance())
            );
        }
    }

    @Nested
    class WithdrawTests {
        BankAccount bankAccount;

        @BeforeEach
        void setup(){
            this.bankAccount = new BankAccount("1234", "TestName", 100);
        }

        @ParameterizedTest(name="Withdraw {0}")
        @DisplayName("Withdraw vàlid")
        @ValueSource(doubles = {5, 10, 50, 100})
        void validWithdraw(double amount){
            boolean hasWithdrawn = bankAccount.withdraw(amount);
            Transaction lastTransaction = bankAccount.getLastTransaction();
            assertAll(
                    () -> assertTrue(hasWithdrawn),
                    () -> assertNotNull(lastTransaction),
                    () -> assertEquals(100 - amount, bankAccount.getBalance()),
                    () -> assertEquals(amount, lastTransaction.getAmount()),
                    () -> assertEquals(TransactionType.WITHDRAW, lastTransaction.getTransactionType())
            );
        }

        @DisplayName("Withdraw zero")
        @Test
        void zeroWithdraw(){
            List<Transaction> transactionsBefore = bankAccount.getTransactions();
            boolean hasWithdrawn = bankAccount.withdraw(0);
            Transaction lastTransaction = bankAccount.getLastTransaction();
            assertAll(
                    () -> assertFalse(hasWithdrawn),
                    () -> assertEquals(100, bankAccount.getBalance()),
                    () -> assertNotEquals(TransactionType.WITHDRAW, lastTransaction.getTransactionType()),
                    () -> assertEquals(transactionsBefore, bankAccount.getTransactions())
            );
        }

        @DisplayName("Withdraw negative")
        @Test
        void negativeWithdraw(){
            List<Transaction> transactionsBefore = bankAccount.getTransactions();
            boolean hasWithdrawn = bankAccount.withdraw(-100);
            Transaction lastTransaction = bankAccount.getLastTransaction();
            assertAll(
                    () -> assertFalse(hasWithdrawn),
                    () -> assertEquals(100, bankAccount.getBalance()),
                    () -> assertNotEquals(TransactionType.WITHDRAW, lastTransaction.getTransactionType()),
                    () -> assertEquals(transactionsBefore, bankAccount.getTransactions())
            );
        }

        @DisplayName("Withdraw more than balance")
        @Test
        void moreBalanceWithdraw(){
            List<Transaction> transactionsBefore = bankAccount.getTransactions();
            boolean hasWithdrawn = bankAccount.withdraw(150);
            Transaction lastTransaction = bankAccount.getLastTransaction();
            assertAll(
                    () -> assertFalse(hasWithdrawn),
                    () -> assertEquals(100, bankAccount.getBalance()),
                    () -> assertNotEquals(TransactionType.WITHDRAW, lastTransaction.getTransactionType()),
                    () -> assertEquals(transactionsBefore, bankAccount.getTransactions())
            );
        }
    }

    @Nested
    class BalanceTests {
        BankAccount bankAccount;

        @BeforeEach
        void setup(){
            this.bankAccount = new BankAccount("1234", "TestName" );
        }

        @DisplayName("Balance is consistent")
        @Test
        void moreBalanceWithdraw(){
            bankAccount.deposit(100);
            bankAccount.withdraw(120);
            bankAccount.withdraw(50);
            bankAccount.deposit(100);
            bankAccount.deposit(100);
            bankAccount.withdraw(50);
            bankAccount.withdraw(50);
            bankAccount.withdraw(-50);
            bankAccount.deposit(0);
            bankAccount.deposit(-100);

            int balance = 0;
            for(Transaction t : bankAccount.getTransactions()){
                if(t.getTransactionType() == TransactionType.DEPOSIT)
                    balance += t.getAmount();
                else if(t.getTransactionType() == TransactionType.WITHDRAW)
                    balance -= t.getAmount();
            }
            assertEquals(balance, bankAccount.getBalance());
        }
    }

}