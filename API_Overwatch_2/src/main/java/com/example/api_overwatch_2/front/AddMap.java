package com.example.api_overwatch_2.front;

import com.example.api_overwatch_2.Map;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class AddMap {
    public AddMap() {

        JFrame frame = new JFrame("Ajouter une Map");

        JLabel label = new JLabel("Ajouter une Map");
        label.setBounds(150, 10, 150, 40);
        frame.add(label);

        //Créer les labels
        JLabel id = new JLabel("ID");
        JLabel name = new JLabel("Name");
        JLabel gamemode = new JLabel("Gamemode");
        JLabel country = new JLabel("Country");

        //Créer des textArea
        JTextField idTF = new JTextField();
        JTextField nameTF = new JTextField();
        JTextField gamemodeTF = new JTextField();
        JTextField countryTF = new JTextField();

        //Définir la position des labels
        id.setBounds(30, 50, 150, 40);
        name.setBounds(30, 100, 150, 40);
        gamemode.setBounds(30, 150, 150, 40);
        country.setBounds(30, 200, 150, 40);

        idTF.setBounds(200, 50, 150, 40);
        nameTF.setBounds(200, 100, 150, 40);
        gamemodeTF.setBounds(200, 150, 150, 40);
        countryTF.setBounds(200, 200, 150, 40);

        // Le bouton pour commit
        JButton valider = new JButton("Valider");
        valider.setBounds(150, 400, 200, 50);

        valider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Map map = new Map();
                map.setId(Integer.valueOf(idTF.getText()));
                map.setName(nameTF.getText());
                map.setGamemode(gamemodeTF.getText());
                map.setCountry(countryTF.getText());

                URL url = null;
                try {
                    url = new URL("http://localhost:8081/Maps");
                } catch (MalformedURLException ex) {
                    ex.printStackTrace();
                }
                String json = '{' +
                        "\"id\": " + idTF.getText() + "," +
                        "\"gamemode\": " + "\"" +nameTF.getText()+ "\"" + "," +
                        "\"country\": " + "\"" +gamemodeTF.getText()+ "\"" + "," +
                        "\"name\": " + "\"" +countryTF.getText()+ "\"" +
                        "}";
                System.out.println(json);
                HttpURLConnection con = null;
                try {
                    con = (HttpURLConnection) url.openConnection();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                try {
                    con.setRequestMethod("POST");
                } catch (ProtocolException ex) {
                    ex.printStackTrace();
                }
                con.setRequestProperty("Accept", "application/json");
                con.setRequestProperty("Content-Type", "application/json");
                con.setDoOutput(true);
                try(OutputStream os = con.getOutputStream()) {
                    byte[] input = json.getBytes();
                    os.write(input, 0, input.length);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                try {
                    con.getResponseCode();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        frame.add(valider);


        //Ajouter les labels au frame
        frame.add(id);
        frame.add(name);
        frame.add(gamemode);
        frame.add(country);

        //Ajouter les textArea au frame
        frame.add(idTF);
        frame.add(nameTF);
        frame.add(gamemodeTF);
        frame.add(countryTF);

        frame.setSize(400, 500);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
