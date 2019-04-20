package Repo;

import Domain.Car;

import java.util.Set;

public interface IRepo<T> {
    T get(String id);
    void add(String id, T el);
    void remove(String id);
    Set getAll();
    void clear();
}
