package model;

import java.awt.*;
import java.util.ArrayList;

public class ArrayListPoint extends ArrayList<Point> {
    public ArrayListPoint(){
        super();
    }

    public void setListe(ArrayList<Point> alPoint){
        this.clear();
        this.addAll(alPoint);
    }

    public boolean contient(Point point) {
        for(Point point_compare : this) {
            if(point_compare.x == point.x &&
                    point_compare.y == point.y)
                return true;
        }
        return false;
    }

    public void retirer(Point point) {
        Point point_supprimer = null;
        for(Point point_compare : this) {
            if(point_compare.x == point.x &&
                    point_compare.y == point.y)
                point_supprimer = point_compare;
        }
        this.remove(point_supprimer);
    }
}
