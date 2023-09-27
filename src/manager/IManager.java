package manager;

import java.util.ArrayList;

public interface IManager<E> {
    void add(E e);
    void edit(int id);
    void remove(int id);
    ArrayList<E> findAll();

    E findById(int id);
    ArrayList<E> findByName(String s);
}
