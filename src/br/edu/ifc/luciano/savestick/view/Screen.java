package br.edu.ifc.luciano.savestick.view;

import br.edu.ifc.luciano.savestick.model.Map;
import br.edu.ifc.luciano.savestick.model.Stick;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Singleton pattern implemented
 **/

public class Screen extends JFrame implements KeyListener{
    private static Screen instance = new Screen();
    private Stick stick;
    private int width = 800;
    private int height = 600;

    public static synchronized Screen getInstance(){
        if (instance == null) instance = new Screen();
        return instance;
    }

    private Screen() {
        setupUI();
    }

    private void setupUI() {
        setTitle("Save Stick!!");
        setResizable(true);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        System.out.println("center = " + center.getLocation());
        System.out.println("width = " + width);
        System.out.println("height = " + height);
        setBounds(center.x - width / 2, center.y - height / 2, width, height);
        addKeyListener(this);
    }

    public void setStick(Stick stick){
        this.stick = stick;
    }

    public void setMap(Map map) {
        setContentPane(map);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        Stick stick1 = (Stick) stick;
        stick1.moviment(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}