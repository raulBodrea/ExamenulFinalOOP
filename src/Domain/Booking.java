package Domain;

import java.io.Serializable;

public class Booking implements Serializable, IDomain {
    private String id;
    private int days;
    private String carId;
    private int km;

    public Booking(String id, int days, String carId, int km) {
        this.id = id;
        this.days = days;
        this.carId = carId;
        this.km = km;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id='" + id + '\'' +
                ", days=" + days +
                ", carId='" + carId + '\'' +
                ", km=" + km +
                '}';
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }
}
