/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import javax.swing.SwingUtilities;

/**
 *
 * @author cw
 */
public class Main {

    public static void main(String[] args) {
        
        View frame = new View();
        Controller myController = new Controller(frame);
        frame.addController(myController);

        SwingUtilities.invokeLater(frame);

    }
}
