package Repo;

import Domain.Car;
import Domain.IDomain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Repo<T extends IDomain>{
    private Map<String, T> repo = new HashMap<>();

    /**
     * gets all repo
     * @returnRepo
     */
    public Set<String> getAll(){
        return repo.keySet();
    }
    public void clear(){
        for(String el: repo.keySet()){
            repo.remove(el);
        }
    }

    /**
     * Gets Inv @ ID
     * @param id
     * @return Car
     */
    public T get(String id){
        return this.repo.get(id);
    }


    public void add(String id, T el){
        this.repo.put(id, el);
    }

    /**
     * removes invoice
     * @param id
     */
    public void remove(String id){
        this.repo.remove(id);
    }
}
