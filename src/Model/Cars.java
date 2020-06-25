package Model;

import java.util.Date;


/**
 *
 * @author Vang
 */
public class Cars {
    private String number_car;
    private String name;
    private Date date;
    private String time;
    private float price;

    public Cars() {
    }

    public Cars(String number_car, String name, Date date, String time, float price) {
        this.number_car = number_car;
        this.name = name;
        this.date = date;
        this.time = time;
        this.price = price;
    }

    public String getNumber_car() {
        return number_car;
    }

    public void setNumber_car(String number_car) {
        this.number_car = number_car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    
    
}
