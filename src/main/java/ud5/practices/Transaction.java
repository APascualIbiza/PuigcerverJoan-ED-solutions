package ud5.practices;

import java.util.Date;

public class Transaction {
    private TransactionType transactionType;
    private double amount;
    private Date date;

    public Transaction(TransactionType transactionType, double amount) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.date = new Date();
    }
}
