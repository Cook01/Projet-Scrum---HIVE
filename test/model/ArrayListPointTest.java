package model;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

public class ArrayListPointTest {
    @Test
    public void contient_un_point(){
        ArrayListPoint arrayListPoint = new ArrayListPoint();
        Point point = new Point(3,10);
        arrayListPoint.add(point);
        Assert.assertTrue(arrayListPoint.contient(new Point(3,10)));
    }

    @Test
    public void contient_pas_un_point(){
        ArrayListPoint arrayListPoint = new ArrayListPoint();
        Point point = new Point(3, 10);
        arrayListPoint.add(point);
        Assert.assertFalse(arrayListPoint.contient(new Point(5, 6)));
    }

    @Test
    public void ajout_nouvelle_element_sans_precedent(){
        ArrayListPoint arrayListPoint = new ArrayListPoint();
        Point point = new Point(5, 10);
        ArrayList<Point> arrayList = new ArrayList<Point>();
        Point pointSnd = new Point(6, 18);

        arrayListPoint.add(point);
        Assert.assertTrue(arrayListPoint.contient(new Point(5, 10)));
        arrayList.add(pointSnd);
        arrayListPoint.setListe(arrayList);
        Assert.assertTrue(arrayListPoint.contient(new Point(6, 18)));
        Assert.assertFalse(arrayListPoint.contient(new Point(5, 10)));
    }

    @Test
    public void retirer_un_point(){
        ArrayListPoint arrayListPoint = new ArrayListPoint();
        Point point = new Point(5, 7);
        arrayListPoint.add(point);
        arrayListPoint.retirer(point);
        Assert.assertFalse(arrayListPoint.contient(new Point(5, 7)));
    }
}