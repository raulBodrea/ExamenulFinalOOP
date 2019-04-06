package UI;

import Domain.Invoice;
import Service.InvoiceService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;

import java.util.ArrayList;
import java.util.List;

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

    private InvoiceService invoiceService = new InvoiceService();

    private ObservableList<Invoice> invoices = FXCollections.observableArrayList();

    public void setServices(InvoiceService invoiceService){
        this.invoiceService = invoiceService;
    }

    @FXML
    private void initialize() {

        Platform.runLater(() -> {
            List<Invoice> invoiceList = new ArrayList();
            for(String invoiceId: invoiceService.getAll()){
                invoiceList.add(invoiceService.getInvoice(invoiceId));
            }
            invoices.addAll(invoiceList);
            tblCakes.setItems(invoices);
        });
    }

    public void btnAddCakeClick(ActionEvent actionEvent) {
        try {
            String id = txtCakeID.getText();
            String description = txtCakeIngredients.getText();
            String date = txtCakeCalories.getText();
            double sum = Double.parseDouble(txtCakeName.getText());
            invoiceService.addInvoice(id, sum, description, date);
            invoices.clear();
            List<Invoice> invoiceList = new ArrayList();
            for(String invoiceId: invoiceService.getAll()){
                invoiceList.add(invoiceService.getInvoice(invoiceId));
            }
            invoices.addAll(invoiceList);
        } catch ( RuntimeException rex ){
            //Common.showValidationError(rex.getMessage());
            System.out.println(rex.getCause());
        }
    }

    /**
     * gets all in a day
     *
     * @param actionEvent
     */
    public void btnGetAll(ActionEvent actionEvent) {
        String date = txtDate.getText();
        System.out.println(invoiceService.getAllInADay(date));
    }
}
