//package Test.Domain;
//
//import Domain.DomainError;
//import Domain.DomainValidator;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class DomainValidatorTest {
//
//    @Test
//    void checkIfValidatorIsSetUpProperly() {
//        DomainValidator domainValidator = new DomainValidator();
//
//        assertThrows(DomainError.class, () -> domainValidator.validate("11.11.111"));
//        assertThrows(DomainError.class, () -> domainValidator.validate("11.11.11111"));
//        assertThrows(DomainError.class, () -> domainValidator.validate("11.111.1111"));
//        assertThrows(DomainError.class, () -> domainValidator.validate("111.11.1111"));
//        assertDoesNotThrow(() -> domainValidator.validate("11.11.1111"));
//
//    }
//}