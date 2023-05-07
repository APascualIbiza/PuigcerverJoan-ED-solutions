package ud5.practices.bank.exception;

public class InvalidAccountHolderNameException extends Exception {
    public InvalidAccountHolderNameException(String message){
        super(message);
    }
}
