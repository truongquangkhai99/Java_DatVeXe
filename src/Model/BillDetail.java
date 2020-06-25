/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.sql.Date;

/**
 *
 * @author Vang
 */
public class BillDetail {
    private int bill_id;
    private String number_car;
    private String name_car;
    private Date date;
    private String time;
    private float price;
    private String name_posi;
    private String name_place;

    public BillDetail() {
    }

    public BillDetail(String number_car, String name_car, Date date, String time, float price, String name_posi, String name_place) {
        this.number_car = number_car;
        this.name_car = name_car;
        this.date = date;
        this.time = time;
        this.price = price;
        this.name_posi = name_posi;
        this.name_place = name_place;
    }

    public BillDetail(int bill_id, String number_car, String name_car, Date date, String time, float price, String name_posi, String name_place) {
        this.bill_id = bill_id;
        this.number_car = number_car;
        this.name_car = name_car;
        this.date = date;
        this.time = time;
        this.price = price;
        this.name_posi = name_posi;
        this.name_place = name_place;
    }

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public String getNumber_car() {
        return number_car;
    }

    public void setNumber_car(String number_car) {
        this.number_car = number_car;
    }

    public String getName_car() {
        return name_car;
    }

    public void setName_car(String name_car) {
        this.name_car = name_car;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName_posi() {
        return name_posi;
    }

    public void setName_posi(String name_posi) {
        this.name_posi = name_posi;
    }

    public String getName_place() {
        return name_place;
    }

    public void setName_place(String name_place) {
        this.name_place = name_place;
    }
    
    
}
