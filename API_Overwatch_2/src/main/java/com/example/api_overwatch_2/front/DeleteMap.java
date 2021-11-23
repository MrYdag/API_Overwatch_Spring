package com.example.api_overwatch_2.front;

import com.example.api_overwatch_2.Map;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class DeleteMap {

    public DeleteMap() {
        JFrame frame = new JFrame("Supprimer une Map");

        JLabel label = new JLabel("Supprimer une Map");
        label.setBounds(150, 10, 150, 40);
        frame.add(label);

        //Créer les labels
        JLabel id = new JLabel("ID");

        //Créer des textArea
        JTextField idTF = new JTextField();

        //Définir la position des labels
        id.setBounds(30, 50, 150, 40);

        idTF.setBounds(200, 50, 150, 40);

        // Le bouton pour commit
        JButton valider = new JButton("Valider");
        valider.setBounds(150, 400, 200, 50);

        valider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Map map = new Map();
                map.setId(Integer.valueOf(idTF.getText()));


                URL url = null;
                try {
                    url = new URL("http://localhost:8081/Maps/" + idTF.getText());
                } catch (MalformedURLException ex) {
                    ex.printStackTrace();
                }
                HttpURLConnection con = null;
                try {
                    con = (HttpURLConnection) url.openConnection();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                try {
                    con.setRequestMethod("DELETE");
                } catch (ProtocolException ex) {
                    ex.printStackTrace();
                }
                BufferedReader in = null;
                try {
                    in = new BufferedReader(
                            new InputStreamReader(con.getInputStream()));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                String inputLine = null;
                StringBuilder content = new StringBuilder();
                while (true) {
                    try {
                        if (!((inputLine = in.readLine()) != null)) break;
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    content.append(inputLine);
                }
                try {
                    in.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                System.out.println(map.toString());
            }
        });
        frame.add(valider);


        //Ajouter les labels au frame
        frame.add(id);

        //Ajouter les textArea au frame
        frame.add(idTF);

        frame.setSize(400, 500);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}

