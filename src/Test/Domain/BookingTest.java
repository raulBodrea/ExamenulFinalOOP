package Test.Domain;

import Domain.Booking;
import Domain.Car;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookingTest {

    @Test
    void TestIfItWorks() {
        Car car = new Car("id", 123, "123", 123);
        Booking booking = new Booking("123", 123, "id", 123);
        assertEquals("123", booking.getId());
        assertEquals(123, booking.getDays());
        assertEquals("id", booking.getCarId());
        assertEquals(123, booking.getKm());
        booking.setCarId("123");
        assertEquals("123", booking.getCarId());
        booking.setId("12354");
        assertEquals("12354", booking.getId());
        booking.setDays(1);
        assertEquals(1, booking.getDays());
        booking.setKm(1);
        assertEquals(1, booking.getKm());
    }
}