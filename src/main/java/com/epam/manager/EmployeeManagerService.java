package com.epam.manager;

import java.util.List;

public interface EmployeeManagerService<T,E> {
    List<T> getAll();
    void createUser(T obj);

    void updateUser (T obj);


}
