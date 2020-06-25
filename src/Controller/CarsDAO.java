/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.Cars;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Vang
 */
public class CarsDAO extends DAO{

    public CarsDAO() {
        super();
    }
    public ArrayList<Cars> getListItem(){
        ArrayList<Cars> items = new ArrayList<>();
        String sql = "select * from cars";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Cars item = new Cars();
                item.setNumber_car(rs.getString("number_car"));
                item.setName(rs.getString("name"));
                item.setDate(rs.getDate("date"));
                item.setTime(rs.getString("time"));
                item.setPrice(rs.getFloat("price"));
                
                items.add(item);
            }
        } catch (Exception e) {
        }
        return items;
    }
    public ArrayList<Cars> getListItemName(){
        ArrayList<Cars> items = new ArrayList<>();
        String sql = "select * from cars group by name order by name";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Cars item = new Cars();
                item.setNumber_car(rs.getString("number_car"));
                item.setName(rs.getString("name"));
                item.setDate(rs.getDate("date"));
                item.setTime(rs.getString("time"));
                item.setPrice(rs.getFloat("price"));
                
                items.add(item);
            }
        } catch (Exception e) {
        }
        return items;
    }
    public ArrayList<Cars> getListItemSearch(String nameSearch, String dateTime){
        ArrayList<Cars> items = new ArrayList<>();
        String sql = "select * from cars where name = ? and date = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nameSearch);
            ps.setString(2, dateTime);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Cars item = new Cars();
                item.setNumber_car(rs.getString("number_car"));
                item.setName(rs.getString("name"));
                item.setDate(rs.getDate("date"));
                item.setTime(rs.getString("time"));
                item.setPrice(rs.getFloat("price"));
                
                items.add(item);
            }
        } catch (Exception e) {
        }
        return items;
    }
    public boolean addItem(Cars item){
        String sql = "insert into cars(number_car, name, date, time, price) values(?,?,?,?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, item.getNumber_car());
            ps.setString(2, item.getName());
            ps.setDate(3, new Date(item.getDate().getTime()));
            ps.setString(4, item.getTime());
            ps.setFloat(5, item.getPrice());
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteItem(Cars item){
        String sql = "delete from cars where number_car = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, item.getNumber_car());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return false;
    }
    public boolean updateItem(Cars item){
        String sql = "UPDATE Cars set name = ?, date = ?, time = ?, price = ? where number_car = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, item.getName());
            ps.setDate(2, new Date(item.getDate().getTime()));
            ps.setString(3, item.getTime());
            ps.setFloat(4, item.getPrice());
            ps.setString(5, item.getNumber_car());
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
}
