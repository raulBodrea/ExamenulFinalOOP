package Service;

import Domain.DomainInvoiceValidator;
import Domain.Invoice;
import Repo.Repo;

import java.util.Set;

public class InvoiceService {
    private Repo invoices = new Repo();

    /**
     * gets all
     * @return set
     */
    public Set<String> getAll(){
        return invoices.getAll();
    }

    /**
     * adds invoice
     * @param id
     * @param sum
     * @param description
     * @param date
     */
    public void addInvoice(String id, double sum, String description, String date){
        try{
            InvoiceValidator validator = new InvoiceValidator();
            validator.validate(id, invoices.getAll());
            Invoice invoice = new Invoice(id, sum, description, date);
            invoices.add(invoice.getID(), invoice);
        }
        catch (ServiceException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * gets invoice
     * @param id
     * @return
     */
    public Invoice getInvoice(String id){
        return invoices.get(id);
    }

    /**
     * gets sum of all invoices in a date
     * @param rawDate
     * @return
     */
    public double getAllInADay(String rawDate){
        int i;
        String[] dateString = rawDate.split("[.]");
        int[] date = new int[3];
        for(i = 0 ; i<3; i++){
            date[i] = Integer.parseInt(dateString[i]);
        }
        double sum = 0;
        for(String invoice: invoices.getAll()){
            String[] invoiceDateString = invoices.get(invoice).getDate().split("[.]");
            int[] invoiceDate = new int[3];
            for(i = 0 ; i<3; i++){
                date[i] = Integer.parseInt(invoiceDateString[i]);
            }
            if(date[0] == invoiceDate[0] && date[1] == invoiceDate[1] && date[2] == invoiceDate[2]) sum += invoices.get(invoice).getSum();
        }
        return sum;
    }
}
