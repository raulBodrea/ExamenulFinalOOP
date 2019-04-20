
import Domain.Booking;
import Domain.Car;
import Repo.Repo;
import Service.BookingService;
import Service.CarService;
import Service.Reader;
import UI.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UI/mainWindow.fxml"));
        Parent root = fxmlLoader.load();
        Reader reader = new Reader();

        Repo<Car> repo = new Repo();
        reader.readFromFile("Cars.bin", repo);

        Repo<Booking> bookings = new Repo<Booking>();
        reader.readBookingFromFile("Bookings.bin", bookings);



        CarService carService = new CarService(repo);
        BookingService bookingService = new BookingService(bookings);


        Controller mainController =  fxmlLoader.getController();
        mainController.setService(carService, bookingService);

        primaryStage.setTitle("Invoices manager");
        primaryStage.setScene(new Scene(root, 600, 475));
        primaryStage.show();
    }

    public static void main(String[] args) throws Exception{
        launch(args);

    }
}


