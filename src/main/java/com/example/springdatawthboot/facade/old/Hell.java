package com.example.springdatawthboot.facade.old;

public class Hell {

    static Weirdo weirdo = new Weirdo() {
        @Override
        public void move() {
            System.out.println("ove");
        }
    };


    public static void main(String[] args) {
        weirdo.move();
    }


}
