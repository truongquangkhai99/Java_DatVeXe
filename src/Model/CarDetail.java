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
public class CarDetail {
    private int position_id;
    private String position_name;
    private String user_name;
    private String phone;

    public CarDetail() {
    }

    public CarDetail(int position_id, String position_name, String user_name, String phone) {
        this.position_id = position_id;
        this.position_name = position_name;
        this.user_name = user_name;
        this.phone = phone;
    }

    public int getPosition_id() {
        return position_id;
    }

    public void setPosition_id(int position_id) {
        this.position_id = position_id;
    }

    public String getPosition_name() {
        return position_name;
    }

    public void setPosition_name(String position_name) {
        this.position_name = position_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
}
