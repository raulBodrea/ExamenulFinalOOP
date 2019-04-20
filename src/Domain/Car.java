package Domain;

import java.io.Serializable;

public class Car implements Serializable, IDomain{
    private String id;
    private double price;
    private String model;
    private int km;

    public Car(String id, double price, String model, int km){
        try{
            DomainValidator validator = new DomainValidator();
            this.km = km;
            this.model = model;
            this.id = id;
            this.price = price;
        }
        catch (DomainError e){
            throw new DomainError(e.getMessage());
        }

    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + this.id + '\'' +
                ", price=" + price +
                ", model='" + model + '\'' +
                ", km='" + km + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }
}
