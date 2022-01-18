package com.tele2.calculator.dao;

import java.util.List;

public interface Tele2Dao<T> {

    List<T> get(String calculation);

    List<T> getAll();

    void save(T t);
}
