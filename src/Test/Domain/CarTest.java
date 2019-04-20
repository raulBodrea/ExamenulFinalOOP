package Test.Domain;

import Domain.Car;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void testIfAllFieldsAreTakingTheRightInfo() {
        Car car = new Car("id", 123, "123", 123);
        assertEquals("id", car.getId());
        assertEquals(123, car.getPrice());
        assertEquals("123", car.getModel());
        assertEquals(123, car.getKm());
        car.setKm(1234);
        assertEquals(1234, car.getKm());
        car.setId("123");
        assertEquals("123", car.getId());
        car.setModel("123");
        assertEquals("123", car.getModel());
        car.setPrice(123.3);
        assertEquals(123.3, car.getPrice());
    }
}