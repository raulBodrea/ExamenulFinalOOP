package UI;

import Domain.Booking;
import Domain.Car;
import Repo.Repo;
import Service.BookingService;
import Service.CarService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Controller {
    public TableView tblCakes;
    public TableColumn colIdCake;
    public TableColumn colNameCake;
    public TableColumn colIngredientsCake;
    public TableColumn colCaloriesCake;
    public TableColumn colPriceCake;
    public TableColumn colSugarFreeCake;
    public TextField txtCakeID;
    public CheckBox chkSugarFree;
    public TextField txtCakeName;
    public TextField txtCakeIngredients;
    public TextField txtCakeCalories;
    public TextField txtCakePrice;
    public Button btnAddCake;
    public TextField txtDate;
    public Button btnGetAllInADay;
    public TableView tblBookings;
    public TableColumn colIdBooking;
    public TableColumn colCarId;
    public TableColumn colDaysNumber;
    public TableColumn colKmParcursi;
    public TextField txtId;
    public TextField txtCarId;
    public TextField txtDaysNumber;
    public TextField txtKm;
    public Button btnAddBooking;
    public Button btnGetAllKm;
    public Button btnGetAllIncome;
    public TextField txtCarIdToBeChecked;
    public TableView tblSorted;
    public TableColumn tblSortedID;
    public TableColumn tblSortedModel;
    public TableColumn tblSortedDays;

    private CarService carService;
    private BookingService bookingService;

    public void setService(CarService service, BookingService bookingService){
        this.carService = service;
        this.bookingService = bookingService;
    }

    private ObservableList<Car> cars = FXCollections.observableArrayList();
    private ObservableList<Booking> bookings = FXCollections.observableArrayList();



    @FXML
    private void initialize() {

        Platform.runLater(() -> {
            List<Car> carList = new ArrayList();
            for(String invoiceId: carService.getAll()){
                carList.add(carService.getCar(invoiceId));
            }
            cars.addAll(carList);
            tblCakes.setItems(cars);

            List<Booking> bookingList = new ArrayList();
            for(String invoiceId: bookingService.getAll()){
                bookingList.add(bookingService.getBooking(invoiceId));
            }
            bookings.addAll(bookingList);
            tblBookings.setItems(bookings);
        });
    }

    /**
     * adds car
     * @param actionEvent
     */
    public void btnAddCakeClick(ActionEvent actionEvent) {
        try {
            String id = txtCakeID.getText();
            String model = txtCakeIngredients.getText();
            int km = Integer.parseInt(txtCakeCalories.getText());
            double price = Double.parseDouble(txtCakeName.getText());
            carService.addCar(id, price, model, km);
            cars.clear();
            List<Car> carList = new ArrayList();
            for(String invoiceId: carService.getAll()){
                carList.add(carService.getCar(invoiceId));
            }
            cars.addAll(carList);
        } catch ( RuntimeException rex ){
            Common.showValidationError(rex.getMessage());
        }
    }

    /**
     * adds booking
     * @param actionEvent
     */
    public void btnAddBookingClick(ActionEvent actionEvent) {
        try {
            String id = txtId.getText();
            String carId = txtCarId.getText();
            int days = Integer.parseInt(txtDaysNumber.getText());
            int km = Integer.parseInt(txtKm.getText());
            bookingService.addBooking(id,days, carId, km, carService.getAll());
            bookings.clear();
            List<Booking> bookingList = new ArrayList();
            for(String invoiceId: bookingService.getAll()){
                bookingList.add(bookingService.getBooking(invoiceId));
            }
            bookings.addAll(bookingList);
        } catch ( RuntimeException rex ){
            System.out.println(rex.getMessage());
        }
    }

    /**
     * finds all km
     * @param actionEvent
     */
    public void btnAddFindKm(ActionEvent actionEvent) {
        Repo<Booking> bookingRepo = new Repo<Booking>();
        for (String booking: bookingService.getAll()){
            bookingRepo.add(booking, bookingService.getBooking(booking));
        }
        Common.showResult("This car has "+carService.findKm(txtCarIdToBeChecked.getText(), bookingRepo) + "km.");
    }

    /**
     * finds all income
     * @param actionEvent
     */
    public void btnAddFindIncome(ActionEvent actionEvent) {
        Repo<Booking> bookingRepo = new Repo<Booking>();
        for (String booking: bookingService.getAll()){
            bookingRepo.add(booking, bookingService.getBooking(booking));
        }
        Common.showResult("This car has brought in "+carService.findIncome(txtCarIdToBeChecked.getText(), bookingRepo) + "$.");
    }
//
//    public void btnSortCars(ActionEvent actionEvent) {
//        Repo<Booking> bookingRepo = new Repo<Booking>();
//        for (String booking: bookingService.getAll()){
//            bookingRepo.add(booking, bookingService.getBooking(booking));
//        }
//        Map<String, Integer> carsMapSorted = carService.sortByDemand(bookingRepo);
//        Car[] carsToBeOrdered = new Car[carService.getAll().size()];
//        int k = 0;
//        for(String car: carService.getAll()){
//            carsToBeOrdered[k] = carService.getCar(car);
//        }
//        for(int i = 0; i < carService.getAll().size(); i++){
//            for(int j = i+1; j < carService. getAll().size(); j++){
//                if(carsMapSorted.get(carsToBeOrdered[i].getId()) < carsMapSorted.get(carsToBeOrdered[j].getId())){
//                    Car temp = carsToBeOrdered[i];
//                    carsToBeOrdered[i] = carsToBeOrdered[j];
//                    carsToBeOrdered[j] = temp;
//                }
//            }
//        }
//        for(Car car: carsToBeOrdered){
//            ObservableList<Car> carsSorted = FXCollections.observableArrayList();
//            carsSorted.addAll(carsToBeOrdered);
//            tblSorted.setItems(carsSorted);
//        }




//    }
}
