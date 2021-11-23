package com.example.api_overwatch_2;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface IMapsDAO extends CrudRepository<Map,Integer> {

    Iterable<Object> findByGamemode(String gamemode);

    Map findById(int id);

    void deleteById(int id);

    //List<Map> findAll(String gamemode);
}

