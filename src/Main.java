
import Domain.*;
import Repo.IRepo;
import Repo.Repo;
import Service.InvoiceService;
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

        Repo repo = new Repo();


        InvoiceService invoiceService = new InvoiceService();
        invoiceService.addInvoice("1", 1.2, "ing 1, ing2", "11.11.1999");
        invoiceService.addInvoice("3", 1.2, "ing 1, ing2", "11.11.1998");
        invoiceService.addInvoice("2", 1.2, "ing 1, ing2", "11.11.1998");

        Controller mainController =  fxmlLoader.getController();
        mainController.setServices(invoiceService);

        primaryStage.setTitle("Invoices manager");
        primaryStage.setScene(new Scene(root, 600, 475));
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);


    }
}


