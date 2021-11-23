package com.example.api_overwatch_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.List;

@Controller
public class MapController {

    @Autowired
    private IMapsDAO dao;

    @ResponseBody
    @GetMapping(value = "/Maps")
    public List<Map> getMaps(){

        return (List<Map>) dao.findAll();
    }

    @ResponseBody
    @GetMapping(value = "/Maps/{id}")
    public Map getMap(@PathVariable int id){
        return dao.findById(id);
    }

    @PostMapping(value = "/Maps")
    public Map addMaps(@RequestBody Map m){
        Map map = new Map();
        map.setName(m.getName());
        map.setGamemode(m.getGamemode());
        map.setCountry(m.getCountry());
        return dao.save(map);
    }

    @PutMapping(value ="/Maps/{id}")
    public Map modifyMap(@RequestBody Map map,@PathVariable int id){
        Map oldMap = dao.findById(id);
        oldMap.setName(map.getName());
        oldMap.setGamemode(map.getGamemode());
        oldMap.setCountry(map.getCountry());

        return dao.save(oldMap);
    }

    @DeleteMapping(value="/Maps/{id}")
    public void deleteMaps(@PathVariable int id){
        dao.deleteById(id);
    }
}
