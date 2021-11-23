package com.example.api_overwatch_2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

@SpringBootApplication
public class ApiOverwatch2Application {

    private static final Logger log = LoggerFactory.getLogger(ApiOverwatch2Application.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public static void main(String[] args) {
        SpringApplication.run(ApiOverwatch2Application.class, args);
    }

    @PostConstruct
    private void initDb(){
        String sqlStatement[] = {
                "Insert Into map (name,gamemode,country) VALUES ('Paris','2CP','France')",
                "Insert Into map (name,gamemode,country) VALUES ('Horizon Lunar Colony','2CP', 'Moon')",
                "Insert Into map (name,gamemode,country) VALUES ('Hanamura','2CP', 'Japon')",
                "Insert Into map (name,gamemode,country) VALUES ('Temple of Anubis','2CP', 'Egypte')",
                "Insert Into map (name,gamemode,country) VALUES ('Volskaya Industries','2CP', 'Russie')",

                "Insert Into map (name,gamemode,country) VALUES ('Busan','Koth', 'Corée du sud')",
                "Insert Into map (name,gamemode,country) VALUES ('Ilios','Koth', 'Grece')",
                "Insert Into map (name,gamemode,country) VALUES ('Lijiang Tower','Koth', 'Chine')",
                "Insert Into map (name,gamemode,country) VALUES ('Nepal','Koth', 'Nepal')",
                "Insert Into map (name,gamemode,country) VALUES ('Oasis','Koth', 'Irak')",

                "Insert Into map (name,gamemode,country) VALUES ('Dorado','Escort', 'Mexique')",
                "Insert Into map (name,gamemode,country) VALUES ('Havana','Escort', 'Cuba')",
                "Insert Into map (name,gamemode,country) VALUES ('Junkertown','Escort', 'Australie')",
                "Insert Into map (name,gamemode,country) VALUES ('Rialto','Escort', 'Italie')",
                "Insert Into map (name,gamemode,country) VALUES ('Route 66','Escort', 'Etats-Unis')",
                "Insert Into map (name,gamemode,country) VALUES ('Watchpoint: Gibraltar','Escort', 'Inconnu')",

                "Insert Into map (name,gamemode,country) VALUES ('Blizzard World','Hybrid', 'Etats-Unis')",
                "Insert Into map (name,gamemode,country) VALUES ('Eichenwalde','Hybrid', 'Allemagne')",
                "Insert Into map (name,gamemode,country) VALUES ('Hollywood','Hybrid', 'Etats-Unis')",
                "Insert Into map (name,gamemode,country) VALUES ('Kings Row','Hybrid', 'Angleterre')",
                "Insert Into map (name,gamemode,country) VALUES ('Numbani','Hybrid', 'Numbani')",

                "Insert Into map (name,gamemode,country) VALUES ('Black Forest','Elimination', 'Allemagne')",
                "Insert Into map (name,gamemode,country) VALUES ('Castillo','Elimination', 'Mexique')",
                "Insert Into map (name,gamemode,country) VALUES ('Ecopoint: Antarctica','Elimination', 'Inconnu')",
                "Insert Into map (name,gamemode,country) VALUES ('Necropolis','Elimination', 'Egypte')"


        };
        Arrays.asList(sqlStatement).forEach(sql -> {
            jdbcTemplate.execute(sql);
        });

        log.info("\n Affichage de toutes les maps --(findAll)--");
        jdbcTemplate.query("select * from map", new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet map, int i) throws SQLException {
                System.out.println("id: " + map.getString("id")+
                        " gamemode: " + map.getString("gamemode")+
                        " country: " + map.getString("country")
                        );
                return null;
            }
        });
    }
    @Bean
    public CommandLineRunner runner(IMapsDAO repository){
        return (args) -> {
        };

    }
}
