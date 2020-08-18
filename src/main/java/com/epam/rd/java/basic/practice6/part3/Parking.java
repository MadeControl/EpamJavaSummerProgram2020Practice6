package com.epam.rd.java.basic.practice6.part3;

public class Parking {

    private final int capacity;
    private String stateParking;
    
    public Parking(int capacity) {
        this.capacity = capacity;
        this.stateParking = createStateParking();
    }
    
    public boolean arrive(int k) {

        if(k >= capacity){
            throw new IllegalArgumentException();
        }

        String[] array = stateParking.split("");

        if(array[k].equals("0")) {
            stateParking = new StringBuilder(stateParking)
                    .replace(k, k+1, "1")
                    .toString();
            return true;
        }

        for(int i = k; i < capacity; i++) {
            if(array[i].equals("0")) {
                stateParking = new StringBuilder(stateParking)
                        .replace(i, i+1, "1")
                        .toString();
                return true;
            }
        }

        for(int i = 0; i < k; i++) {
            if(array[i].equals("0")) {
                stateParking = new StringBuilder(stateParking)
                        .replace(i, i+1, "1")
                        .toString();
                return true;
            }
        }

        return false;
        
    }
    
    public boolean depart(int k) {

        String letter = stateParking.substring(k,k+1);

        if(letter.equals("1")) {
            stateParking = new StringBuilder(stateParking).replace(k, k+1, "0").toString();
            return true;
        }

        return false;
    }
    
    public void print() {
        System.out.println(stateParking);
    }

    public String createStateParking() {

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < capacity; i++) {
            sb.append("0");
        }

        return sb.toString();
    }

    public String getStateParking() {
        return stateParking;
    }
}
