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
public class Position {
    private int position_id;
    private String name;
    private String number_car;
    private int status;

    public Position() {
    }

    public Position(String name, String number_car, int status) {
        this.name = name;
        this.number_car = number_car;
        this.status = status;
    }

    public Position(int position_id, String name, String number_car, int status) {
        this.position_id = position_id;
        this.name = name;
        this.number_car = number_car;
        this.status = status;
    }

    public int getPosition_id() {
        return position_id;
    }

    public void setPosition_id(int position_id) {
        this.position_id = position_id;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    
}
