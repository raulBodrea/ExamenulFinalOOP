package Repo;

import Domain.Invoice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Repo {
    private Map<String, Invoice> repo = new HashMap<>();

    /**
     * gets all repo
     * @returnRepo
     */
    public Set<String> getAll(){
        return repo.keySet();
    }

    /**
     * Gets Inv @ ID
     * @param id
     * @return Invoice
     */
    public Invoice get(String id){
        return this.repo.get(id);
    }

    /**
     * adds invoice
     * @param id
     * @param invoice
     */
    public void add(String id, Invoice invoice){
        this.repo.put(id, invoice);
    }

    /**
     * removes invoice
     * @param id
     */
    public void remove(String id){
        this.repo.remove(id);
    }
}
