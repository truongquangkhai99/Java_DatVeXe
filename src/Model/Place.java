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
public class Place {
    private int place_id;
    private String name;
    private String number_car;

    public Place() {
    }

    public Place(int place_id, String name, String number_car) {
        this.place_id = place_id;
        this.name = name;
        this.number_car = number_car;
    }

    public Place(String name, String number_car) {
        this.name = name;
        this.number_car = number_car;
    }
    
    public int getPlace_id() {
        return place_id;
    }

    public void setPlace_id(int place_id) {
        this.place_id = place_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber_car() {
        return number_car;
    }

    public void setNumber_car(String number_car) {
        this.number_car = number_car;
    }
    
    
}
