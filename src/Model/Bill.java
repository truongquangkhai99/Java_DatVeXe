/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author Vang
 */
public class Bill {
    private int bill_id;
    private int user_id;
    private String number_car;
    private int position_id;
    private int place_id;

    public Bill() {
    }

    public Bill(int bill_id, int user_id, String number_car, int position_id, int place_id) {
        this.bill_id = bill_id;
        this.user_id = user_id;
        this.number_car = number_car;
        this.position_id = position_id;
        this.place_id = place_id;
    }

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getNumber_car() {
        return number_car;
    }

    public void setNumber_car(String number_car) {
        this.number_car = number_car;
    }

    public int getPosition_id() {
        return position_id;
    }

    public void setPosition_id(int position_id) {
        this.position_id = position_id;
    }

    public int getPlace_id() {
        return place_id;
    }

    public void setPlace_id(int place_id) {
        this.place_id = place_id;
    }

    public Bill(int user_id, String number_car, int position_id, int place_id) {
        this.user_id = user_id;
        this.number_car = number_car;
        this.position_id = position_id;
        this.place_id = place_id;
    }
    
    
}
