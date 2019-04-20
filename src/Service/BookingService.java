package Service;

import Domain.Booking;
import Domain.Car;
import Repo.Repo;
import UI.Common;

import java.util.Set;

public class BookingService {
    private Repo<Booking> bookings;

    public BookingService(Repo<Booking> bookings) {
        this.bookings = bookings;
    }

    /**
     * Adds booking
     * @param id
     * @param days
     * @param carId
     * @param km
     * @param cars
     */
    public void addBooking(String id, int days, String carId, int km, Set<String> cars){
        try {
            Writer writer = new Writer();
            IDValidator validator = new IDValidator();
            validator.validate(id, bookings.getAll());
            validateBooking(carId, cars);
            Booking booking = new Booking(id, days, carId, km);
            bookings.add(booking.getId(), booking);
            writer.writeToFile("Bookings.bin", bookings);
        }
        catch (ServiceException e){
            Common.showValidationError(e.getMessage());
        }
    }

    /**
     * returns bookings
     * @return
     */
    public Set<String> getAll(){
        return this.bookings.getAll();
    }

    /**
     * returns booking
     * @param id
     * @return
     */
    public Booking getBooking(String id){
        return bookings.get(id);
    }

    /**
     * checks if there is a car for the booking
     * @param carId
     * @param cars
     */
    public void validateBooking(String carId, Set<String> cars){
        int found = 1;
        for(String car: cars){
            if(carId.equals(car)) found += 1;
        }
        if(found == 1) throw new ServiceException("Nu exista masina aleasa.");
    }

}
