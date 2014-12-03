package br.edu.ifc.luciano.savestick.model;

import br.edu.ifc.luciano.savestick.control.IsCollisionable;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Stick extends ActorObject implements IsCollisionable {
    private static Stick instance = new Stick();
    private static final String URL_IMAGE = "/var/www/SaveStick/src/br/edu/ifc/luciano/savestick/assets/stick.png";
    private BufferedImage bufferedImage;
    private static int width = 40;
    private static int height = 40;
    private static final int SPEED = 20;

    public static synchronized Stick getInstance() {
        if (instance == null) instance = new Stick();
        return instance;
    }

    public void setImage() throws IOException {
        bufferedImage =  ImageIO.read(new File(URL_IMAGE));
    }

    public void moviment (KeyEvent e) {
        if (e.getKeyCode() == e.VK_UP) {
            setLocation(getX(), getY() - SPEED);
        }
        if (e.getKeyCode() == e.VK_DOWN) {
            setLocation(getX(), getY() + SPEED);
        }
        if(e.getKeyCode() == e.VK_LEFT){
            setLocation(getX() - SPEED, getY());
        }
        if(e.getKeyCode() == e.VK_RIGHT){
            setLocation(getX() + SPEED, getY());
        }
    }

    private Stick() {
        try {
            setImage();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setLocationStart(){
        setBounds(getParent().getWidth() / 2 - getWidth() / 2, getParent().getHeight() - getHeight(), getWidth(), getHeight());
    }

    @Override
    public int getSpeed() {
        return SPEED;
    }

    @Override
    public String getType() {
        return "Stick";
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        assert bufferedImage != null;
        assert getHeight() != 0;
        assert getWidth() != 0;
        Graphics gr = (Graphics2D) g.create();
        gr.drawImage(bufferedImage, getAxisX(), getAxisY(), getWidth(), getHeight(), this);
        gr.dispose();
        repaint();
    }

    @Override
    public Point getP1() {
        return new Point(getX() + getWidth() / 2, getY());
    }

    @Override
    public Point getP2() {
        return new Point(getX() + getWidth(), getY() + getHeight() / 2);
    }

    @Override
    public Point getP3() {
        return new Point(getX() + getWidth() / 2, getY() + getHeight());
    }

    @Override
    public Point getP4() {
        return new Point(getX(), getY() + getHeight() / 2);
    }

    @Override
    public Point[] getPointArray(){
        return new Point[]{getP1(), getP2(), getP3(), getP4()};
    }
}
