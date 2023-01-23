package ud5.practices.bank;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un compte bancari.
 */
public class BankAccount {
    /**
     * Número de compte.
     */
    private String accountNumber;
    /**
     * Nom del propietari.
     */
    private String accountHolderName;
    /**
     * Saldo del compte.
     */
    private double balance;
    /**
     * Llista de transaccions realitzades en el compte.
     */
    private List<Transaction> transactions;

    /**
     * Crea un compte bancari i realitza un ingrés amb el saldo inicial.
     * @param accountNumber Número del compte
     * @param accountHolderName Nom del propietari
     * @param balance Saldo inicial
     */
    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.transactions = new ArrayList<>();
        this.balance = 0;
        deposit(balance);
    }

    /**
     * Crea un compte bancari i realitza un ingrés amb un saldo inicial de 0.
     * @param accountNumber Número del compte
     * @param accountHolderName Nom del propietari
     */
    public BankAccount(String accountNumber, String accountHolderName) {
        this(accountNumber, accountHolderName, 0);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    /**
     * TODO: Ingressa els diners especificats en el compte
     * <p>
     * La cantitat no pot ser 0 ni ser un nombre negatiu.
     * <p>
     * Afegeix una nova transacció del tipus DEPOIST amb els diners ingressats.
     * @param amount Diners a ingressar.
     * @return true si l'ingrés s'ha efectuat; false en altre cas.
     */
    public boolean deposit(double amount){
        // TODO
        return false;
    }

    /**
     * TODO: Retira els diners especificats en el compte.
     * <p>
     * La cantitat no pot ser 0 ni ser un nombre negatiu. Si la cantitat especificada
     * és major que el saldo disponible, la retirada no s'efectuarà.
     * <p>
     * Afegeix una nova transacció del tipus WITHDRAW amb els diners retirats.
     * @param amount Diners a retirar.
     * @return true si la retirada s'ha efectuat; false en altre cas.
     */
    public boolean withdraw(double amount){
        // TODO
        return false;
    }
}
