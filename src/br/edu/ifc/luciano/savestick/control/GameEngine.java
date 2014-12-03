package br.edu.ifc.luciano.savestick.control;

import br.edu.ifc.luciano.savestick.model.ActorObject;
import br.edu.ifc.luciano.savestick.model.Map;
import br.edu.ifc.luciano.savestick.model.Stick;
import br.edu.ifc.luciano.savestick.view.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class GameEngine implements ActionListener, ColisionObserver{
    private static GameEngine instance = new GameEngine();
    private List<ActorObject> aActorObject = new ArrayList<ActorObject>();
    private Screen screen = Screen.getInstance();
    private Map map;
    private ActorObject stick = Stick.getInstance();
//    private Properties configProperties = new Properties();

    public static GameEngine getInstance() {
        if (instance == null) instance = new GameEngine();
        return instance;
    }

    private GameEngine() {
        gameStart();
    }

    private void gameStart(){

        MapFactory mapFactory = new MapFactory();
        map = mapFactory.getMap("STREETMAP");

        ActorObjectFactory actorObjectFactory = new ActorObjectFactory();

//        stick.setBounds(map.getWidth() / 2 - stick.getWidth() / 2, map.getHeight() - stick.getHeight(), stick.getWidth(), stick.getHeight());

//        try {
//            configProperties.load(new FileInputStream("/var/www/SaveStick/src/br/edu/ifc/luciano/savestick/assets/config.properties"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        /** CAR **/
        ActorObject car = actorObjectFactory.getActorObject("Car");
        car.setLocation(0, 100);
        aActorObject.add(car);

        /** TRUCK **/
        ActorObject truck = actorObjectFactory.getActorObject("Truck");
        truck.setLocation(100, 200);
        aActorObject.add(truck);

        /** MOTORCYCLE **/
        ActorObject motorcycle = actorObjectFactory.getActorObject("Motorcycle");
        motorcycle.setLocation(200, 300);
        aActorObject.add(motorcycle);

        /** MOTORCYCLE **/
        ActorObject motorcycle2 = actorObjectFactory.getActorObject("Motorcycle");
        motorcycle2.setLocation(600, 340);
        aActorObject.add(motorcycle2);

        /** TRUCK **/
        ActorObject truck2 = actorObjectFactory.getActorObject("Truck");
        truck2.setLocation(300, 400);
        aActorObject.add(truck2);

        map.add(stick);
        for (ActorObject actorObject : aActorObject) {
            map.add(actorObject);
//            System.out.println("actorObject (Vehicle) = " + actorObject.getX()+" = "+actorObject.getY());
        }

        ((Stick) stick).setLocationStart();

        screen.setMap(map);
        screen.setStick((Stick) stick);

        screen.repaint();

        Timer timer = new Timer(1000/50, this);

        timer.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (ActorObject actor: aActorObject) {

            actor.setLocation(actor.getX() + actor.getSpeed(), actor.getY());

            if (actor.getX() > screen.getWidth()) {
                actor.setLocation(0, actor.getY());
            }

            readyMapCollision(actor, stick);

            if (isWinner()) {
                JOptionPane.showMessageDialog(null, "Parabéns você completou o objetivo");
                restart();
            }

            screen.repaint();
        }
    }

    public void restart(){
        ((Stick) stick).setLocationStart();
    }

    public boolean isWinner(){
        boolean flag = false;
        if (stick.getY() < 0) flag = true;
        return flag;
    }

    public void readyMapCollision(ActorObject actorObjectA, ActorObject actorObjectB) {
        if (isCollision(actorObjectA.getP4(), actorObjectB) || isCollision(actorObjectA.getP2(), actorObjectB) || isCollision(actorObjectA.getP1(), actorObjectB) || isCollision(actorObjectA.getP3(), actorObjectB)) {
            //Olha que coisa horrível de se ver
            JOptionPane.showMessageDialog(null, "Você foi atingido por um veiculo, tente novamente");
            ((Stick) actorObjectB).setLocationStart();
        }

//        if (isCollision(actorObjectA.getX(), actorObjectA.getY() + actorObjectA.getHeight() / 2, actorObjectB.getX(), actorObjectB.getY(), actorObjectB.getWidth(), actorObjectB.getHeight())
//            || isCollision(actorObjectA.getX() + actorObjectA.getWidth(), actorObjectA.getY() + actorObjectA.getHeight() / 2, actorObjectB.getX(), actorObjectB.getY(), actorObjectB.getWidth(), actorObjectB.getHeight())
//            || isCollision(actorObjectA.getX() + actorObjectA.getWidth() / 2, actorObjectA.getY(), actorObjectB.getX(), actorObjectB.getY(), actorObjectB.getWidth(), actorObjectB.getHeight())
//            || isCollision(actorObjectA.getX() + actorObjectA.getWidth()/2, actorObjectA.getY()+actorObjectA.getHeight(),       actorObjectB.getX(), actorObjectB.getY(), actorObjectB.getWidth(), actorObjectB.getHeight()))
//        {
//            actorObjectB.setBounds(map.getWidth() / 2 - stick.getWidth() / 2, map.getHeight() - stick.getHeight(), stick.getWidth(), stick.getHeight());
//        }
    }

    public boolean isCollision(int pontoX, int pontoY, int x, int y, int w, int h) {
        if ((pontoX >= x && pontoX <= x + w) && (pontoY >= y && pontoY <= y + h)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isCollision(Point point, ActorObject actorObjectColliser) {
        if ((point.getX() >= actorObjectColliser.getX() && point.getX() <= actorObjectColliser.getX() + actorObjectColliser.getWidth()) && (point.getY() >= actorObjectColliser.getY() && point.getY() <= actorObjectColliser.getY() + actorObjectColliser.getHeight())) {
            return true;
        } else {
            return false;
        }
    }

}
