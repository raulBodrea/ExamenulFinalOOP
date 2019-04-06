package Domain;

public class DomainError extends RuntimeException {
    public DomainError(String DomainException){
        super(DomainException);
    }
}
