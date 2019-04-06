package Domain;

public class Invoice implements IInvoice {
    private String ID;
    private double sum;
    private String description;
    private String date;

    public Invoice(String id, double sum, String description, String date){
        try{
            DomainInvoiceValidator validator = new DomainInvoiceValidator();
            validator.validate(date);
            this.date = date;
            this.description = description;
            this.ID = id;
            this.sum = sum;
        }
        catch (DomainError e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
