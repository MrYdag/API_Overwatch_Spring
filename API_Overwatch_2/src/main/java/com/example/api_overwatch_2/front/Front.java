package com.example.api_overwatch_2.front;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Front {
    public static void main(String[] args) {
        //Créer un nouveau frame pour stocker le bouton
        JFrame frame = new JFrame("Overwatch");

        JLabel label = new JLabel("Gestion des Maps");
        label.setBounds(200,30,150,40);
        frame.add(label);

        //Créer le bouton
        JButton addMap = new JButton("Ajouter Map");
        JButton removeMap = new JButton("Supprimer Map");
        JButton searchMap = new JButton("Rechercher Map");
        JButton modifyMap = new JButton("Modifier Map");

        //Définir la position du bouton
        addMap.setBounds(50,100,150,40);
        removeMap.setBounds(250,100,150,40);
        searchMap.setBounds(50,200,150,40);
        modifyMap.setBounds(250,200,150,40);

        addMap.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new AddMap();
            }
        });

        removeMap.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DeleteMap();
            }
        });

        searchMap.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SearchMap();
            }
        });

        modifyMap.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ModifyMap();
            }
        });


        //Ajouter le bouton et le textArea au frame
        frame.add(addMap);
        frame.add(removeMap);
        frame.add(searchMap);
        frame.add(modifyMap);
        frame.setSize(500,300);
        frame.setLayout(null);
        frame.setVisible(true);

    }
}

