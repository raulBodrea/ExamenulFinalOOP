package Service;

import Domain.Booking;
import Domain.Car;
import Repo.Repo;
import UI.Common;

import javax.xml.ws.Service;
import java.io.*;
import java.util.*;

public class CarService implements Serializable {
    private Repo<Car> cars;
    public CarService(Repo repo){
        this.cars = repo;
    }

    /**
     * gets all
     * @return set
     */
    public Set<String> getAll(){
        return cars.getAll();
    }

    /**
     * adds a ca r
     * @param id
     * @param price
     * @param model
     * @param km
     */
    public void addCar(String id, double price, String model, int km){
        try{
            Writer writer = new Writer();
            IDValidator validator = new IDValidator();
            validator.validate(id, cars.getAll());
            Car car = new Car(id, price, model, km);
            cars.add(car.getId(), car);
            writer.writeToFile("Cars.bin", cars);
        }
        catch (ServiceException e){
            Common.showValidationError(e.getMessage());
        }
    }

    public int findKm(String car, Repo<Booking> bookings){
        int found = 0, km = cars.get(car).getKm();
        for(String carCheck: cars.getAll()){
            if(carCheck.equals(car)) found+=1;
        }
        if(found == 0) throw new ServiceException("Aceasta masina nu exista");
        else{
            for(String booking: bookings.getAll()){
                if(bookings.get(booking).getCarId().equals(car)){
                    km += bookings.get(booking).getKm();

                }
            }
        }
        return km;
    }
    public int findIncome(String car, Repo<Booking> bookings){
        int found = 0, income = 0;
        for(String carCheck: cars.getAll()){
            if(carCheck.equals(car)) found+=1;
        }
        if(found == 0) throw new ServiceException("Aceasta masina nu exista");
        else{
            for(String booking: bookings.getAll()){
                if(bookings.get(booking).getCarId().equals(car)){
                    income += bookings.get(booking).getDays()*cars.get(car).getPrice();
                }
            }
        }
        return income;
    }

    public Map<String, Integer> sortByDemand(Repo<Booking> bookings){
        Map<String, Integer> carsMap = new HashMap<>();
        for(String car: cars.getAll()){
            int days = 0;
            for(String booking: bookings.getAll()){
                if(bookings.get(booking).getCarId().equals(car)) days += bookings.get(booking).getDays();
            }
            carsMap.put(car, days);
        }
        String[] carsToBeOrdered = new String[cars.getAll().size()];
//        int k = 0;
//        for(String car: cars.getAll()){
//            carsToBeOrdered[k] = car;
//        }
//        for(int i = 0; i < cars.getAll().size(); i++){
//            for(int j = i+1; j < cars. getAll().size(); j++){
//                if(carsMap.get(carsToBeOrdered[i]) < carsMap.get(carsToBeOrdered[j])){
//                    String temp = carsToBeOrdered[i];
//                    carsToBeOrdered[i] = carsToBeOrdered[j];
//                    carsToBeOrdered[j] = carsToBeOrdered[i];
//                }
//            }
//        }
        Map<Car, Integer> carsOrdered = new HashMap<>();
        for(String car: carsToBeOrdered){

        }
        return carsMap;
    }


    /**
     * gets invoice
     * @param id
     * @return
     */
    public Car getCar(String id){
        return cars.get(id);
    }
}
