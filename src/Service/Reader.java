package Service;

import Domain.Booking;
import Domain.Car;
import Repo.IRepo;
import Repo.Repo;
import UI.Common;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Reader {
    /**
     * reads Cars from file
     * @param filename
     * @param repo
     */
    public void readFromFile(String filename, Repo repo) {
        try{
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            repo.clear();
            int i = 0;
            while(true){
                Car element = (Car) in.readObject();
                repo.add(element.getId(), element);
            }

        }
        catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }

    }

    /**
     * reads bookings from file
     * @param filename
     * @param repo
     */
    public void readBookingFromFile(String filename, Repo repo) {
        try{
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            repo.clear();
            int i = 0;
            while(true){
                Booking element = (Booking) in.readObject();
                repo.add(element.getId(), element);
            }
        }
        catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }

    }
}
