/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author cw
 */
public class Controller implements ActionListener {

    private View view;

    public Controller(View view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
               Object source = e.getSource();

        if (source == view.getButton()) {
           view.startGame();
        }}
}

//adds view
//public void addView(View v) {
//        this.view = v;

    


