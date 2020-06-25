/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.CarDetail;
import Model.Cars;
import Model.Place;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Vang
 */
public class PlaceDAO extends DAO{
    public PlaceDAO(){
        super();
    }
    public ArrayList<Place> getListItem(){
        ArrayList<Place> itemsCars = new ArrayList<>();
        String sql = "select * from place order by name";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            
            while(rs.next()){
                Place itemPalace = new Place();
                itemPalace.setPlace_id(rs.getInt("place_id"));
                itemPalace.setName(rs.getString("name"));
                itemPalace.setNumber_car(rs.getString("number_car"));
                
                
                itemsCars.add(itemPalace);
            }
        } catch (Exception e) {
        }
        return itemsCars;
    }
    public ArrayList<Place> getListItemCars(String a){
        ArrayList<Place> itemsCars = new ArrayList<>();
        String sql = "select * from place where number_car = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, a);
            ResultSet rs = ps.executeQuery();
            
            
            while(rs.next()){
                Place itemPalace = new Place();
                itemPalace.setPlace_id(rs.getInt("place_id"));
                itemPalace.setName(rs.getString("name"));
                itemPalace.setNumber_car(rs.getString("number_car"));
                
                
                itemsCars.add(itemPalace);
            }
        } catch (Exception e) {
        }
        return itemsCars;
    }
    public boolean addItem(Place item){
        String sql = "insert into place(name, number_car) values(?,?)";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            
            ps.setString(1, item.getName());
            ps.setString(2, item.getNumber_car());
            return ps.executeUpdate() > 0; 
        } catch (Exception e) {
            System.out.println("saiiii");    
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateItem(Place item){
        String sql = "update place set name = ?, number_car = ? where place_id= ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, item.getName());
            ps.setString(2, item.getNumber_car());
            ps.setInt(3, item.getPlace_id());
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    public boolean deleteItem(Place item){
        String sql = "delete from place where place_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, item.getPlace_id());
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    

}
