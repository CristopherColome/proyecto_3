/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.app;

import com.grupo2.view.MainView;
import java.awt.EventQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author ccolome
 */
@Component
public class AplicationView implements CommandLineRunner {

    @Autowired
    private MainView mainView;

    @Override
    public void run(String... args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                mainView.setVisible(true);
            }
        });
    }

}
