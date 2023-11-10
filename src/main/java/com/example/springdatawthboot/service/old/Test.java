package com.example.springdatawthboot.service.old;

public class Test {


    public static void main(String[] args) {
        int i = 0;
        String rec = "";
        Test test = new Test();
        test.check(i, rec);
    }


    private String check(int i, String rec){
        i++;
        String name = "AliAsgariEmad";
        int size = name.toCharArray().length;
        if (i > size){
            return rec;
        }

        rec += name.charAt(size - i);
        System.out.println(rec);

            return check(i, rec);
    }


}
