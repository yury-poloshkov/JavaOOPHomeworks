package org.example.MyList;


import org.example.Interface.GBList;

public class Main {
    public static void main(String[] args) {
        GBList<Number> gbList = new GBArrayList<>();
        gbList.add(1);
        gbList.add(3.1415926);
        gbList.join(1).join(2).join(3);
        System.out.println(gbList);
        gbList.update(0, 1.213213f);
        System.out.println(gbList.size());

    }
}
