package br.edu.ifc.luciano.savestick.model;

import br.edu.ifc.luciano.savestick.control.IsCollisionable;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Motorcycle extends Vehicle implements IsCollisionable {
    private static final Color COLOR = Color.BLUE;
    private static final String PATH_IMAGE = "/var/www/SaveStick/src/br/edu/ifc/luciano/savestick/assets/motorcycle.gif";
    private static BufferedImage bufferedImage;
    private static final int SPEED = 25;

    public void setImage() {
        try {
            this.bufferedImage = ImageIO.read(new File(PATH_IMAGE));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Motorcycle() {
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
        return "Motorcycle";
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
