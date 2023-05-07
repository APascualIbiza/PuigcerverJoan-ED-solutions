package ud5.practices.bank.exception;

public class BankAccountNotFoundException extends Exception {
    public BankAccountNotFoundException(String message){
        super(message);
    }
}
