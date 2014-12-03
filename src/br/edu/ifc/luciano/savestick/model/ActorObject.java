package br.edu.ifc.luciano.savestick.model;

import br.edu.ifc.luciano.savestick.control.IsCollisionable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class ActorObject extends JPanel implements IsCollisionable {
    protected int axisX;
    protected int axisY;
    protected int width;
    protected int height;
    protected int speed = 20;
    private String type = "ActorObject";

    public int getAxisX() {
        return axisX;
    }

    public void setAxisX(int axisX) {
        this.axisX = axisX;
    }

    public int getAxisY() {
        return axisY;
    }

    public void setAxisY(int axisY) {
        this.axisY = axisY;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getType() {
        return type;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isCollision(){
        return false;
    }

    @Override
    public Point getP1() {
        return null;
    }

    @Override
    public Point getP2() {
        return null;
    }

    @Override
    public Point getP3() {
        return null;
    }

    @Override
    public Point getP4() {
        return null;
    }

    @Override
    public Point[] getPointArray() {
        return null;
    }
}
