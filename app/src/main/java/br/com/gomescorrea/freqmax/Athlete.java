package br.com.gomescorrea.freqmax;

import java.util.Comparator;

public class Athlete {
    private String name;
    private int age;
    private int fcm;

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return this.age;
    }

    public void setAge(Integer age){
        this.age = age;
    }

    public String getFcm(){
        return (220 - this.age) + "";
    }

    public static Comparator<Athlete> AthleteFCMDescendingComparator = new Comparator<Athlete>() {
        @Override
        public int compare(Athlete o1, Athlete o2) {
            return Integer.parseInt(o2.getFcm()) - Integer.parseInt(o1.getFcm());
        }
    };

    @Override
    public String toString() {
        return "Adicionado atleta " + name +
                " idade " + age +
                " e FCM de " + this.getFcm();
    }
}
