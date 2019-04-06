package Repo;

import Domain.Invoice;

public interface IRepo {
    Invoice get(String id);
    void add(String id, Invoice invoice);
    void remove(String id);
}
