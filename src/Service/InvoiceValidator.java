package Service;

import Repo.Repo;

import java.util.Set;

public class InvoiceValidator {
    public void validate(String id, Set<String> invoices){
        int found = 0;
        for(String idCurent: invoices){
            if(id.equals(idCurent)) found+=1;
        }
        if(found != 0) throw new ServiceException("There is another invoice with the same ID.\n");
    }
}
