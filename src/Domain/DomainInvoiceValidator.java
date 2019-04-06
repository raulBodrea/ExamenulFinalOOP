package Domain;

public class DomainInvoiceValidator {
    public void validate(String rawDate){
        int i;
        String err = "";
        String[] dateString = rawDate.split("[.]");
        int[] date = new int[3];
        for(i = 0 ; i<3; i++){
            date[i] = Integer.parseInt(dateString[i]);
        }
        if(date[0] > 31 || date[0] < 1) err+="The day should be between 1 and 31.\n ";
        if(date[1] > 12 || date[1] < 1) err+="The month should be between 1 and 12.\n";
        if(date[2] > 9999 || date[2] < 1000) err+="The year should be composed of 4 digits.\n";
        if(!err.equals("")) throw new DomainError(err);
    }
}
