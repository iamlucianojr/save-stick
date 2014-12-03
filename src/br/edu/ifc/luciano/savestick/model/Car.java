package br.edu.ifc.luciano.savestick.model;

import br.edu.ifc.luciano.savestick.control.ColisionObserver;
import br.edu.ifc.luciano.savestick.control.IsCollisionable;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Car extends Vehicle implements IsCollisionable {
    private static final Color COLOR = Color.RED;
    private static final String PATH_IMAGE_CAR = "/var/www/SaveStick/src/br/edu/ifc/luciano/savestick/assets/car.png";
    private static BufferedImage bufferedImage;
    private static final int SPEED = 20;

    public void setImage() {
        try {
            bufferedImage = ImageIO.read(new File(PATH_IMAGE_CAR));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Car() {
        setBackground(COLOR);
        setImage();
        setVisible(true);
    }

    @Override
    public int getSpeed() {
        return SPEED;
    }

    @Override
    public String getType() {
        return "Car";
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
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
