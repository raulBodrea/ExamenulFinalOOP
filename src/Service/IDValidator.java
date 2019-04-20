package Service;

import Repo.Repo;

import java.util.Set;

public class IDValidator {
    /**
     * validates ID
     * @param id
     * @param invoices
     */
    public void validate(String id, Set<String> invoices){
        int found = 0;
        for(String idCurent: invoices){
            if(id.equals(idCurent)) found+=1;
        }
        if(found != 0) throw new ServiceException("There is another element with the same id.\n");
    }
}
