package br.edu.ifc.luciano.savestick.model;

import br.edu.ifc.luciano.savestick.model.ActorObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Map extends JPanel {
    private String pathImg;
    private BufferedImage img;
    private int positionAxysX = 0;
    private int positionAxysY = 0;

    public void setupUI(int width, int height){
        setBounds(0, 0, width, height);
        setLayout(null);
        setImage();
    }

    public void setImage() {
        try {
            this.img = ImageIO.read(new File(pathImg));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    protected void setPathImg(String pathImg) {
        this.pathImg = pathImg;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics gr = (Graphics2D) g.create();
        gr.drawImage(img, positionAxysX, positionAxysY, getWidth(), getHeight(), this);
        gr.dispose();
    }

    public String getPathImg() {
        return pathImg;
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public int getPositionAxysX() {
        return positionAxysX;
    }

    public void setPositionAxysX(int positionAxysX) {
        this.positionAxysX = positionAxysX;
    }

    public int getPositionAxysY() {
        return positionAxysY;
    }

    public void setPositionAxysY(int positionAxysY) {
        this.positionAxysY = positionAxysY;
    }
}
