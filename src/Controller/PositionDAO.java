/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.CarDetail;
import Model.Cars;
import Model.Position;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Vang
 */
public class PositionDAO extends DAO{
    public PositionDAO(){
        super();
    }
    public ArrayList<Position> getListItem(){
        ArrayList<Position> items = new ArrayList<>();
        
        String sql = "select * from posi order by number_car";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Position item = new Position();
                item.setPosition_id(rs.getInt("position_id"));
                item.setName(rs.getString("name"));
                item.setNumber_car(rs.getString("number_car"));
                item.setStatus(rs.getInt("status"));
                
                items.add(item);
            }
            
        } catch (Exception e) {
        }
        return items;
    }
    public ArrayList<Position> getListItemByCar(String a){
        ArrayList<Position> items = new ArrayList<>();
        
        String sql = "select * from posi where number_car = ? and status = 0";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, a);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Position item = new Position();
                item.setPosition_id(rs.getInt("position_id"));
                item.setName(rs.getString("name"));
                item.setNumber_car(rs.getString("number_car"));
                item.setStatus(rs.getInt("status"));
                
                items.add(item);
            }
            
        } catch (Exception e) {
        }
        return items;
    }
    public ArrayList<Position> getListItemByBill(String a, int b){
        ArrayList<Position> items = new ArrayList<>();
        
        String sql = "select * from posi left join bill on posi.position_id = bill.position_id where (posi.number_car = ? and status = 0) or posi.position_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, a);
            ps.setInt(2, b);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Position item = new Position();
                item.setPosition_id(rs.getInt("position_id"));
                item.setName(rs.getString("name"));
                item.setNumber_car(rs.getString("number_car"));
                item.setStatus(rs.getInt("status"));
                
                items.add(item);
            }
            
        } catch (Exception e) {
        }
        return items;
    }

    public boolean addItem(Position item){
        String sql = "insert into posi(name, number_car,status) values(?,?,?)";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            
            ps.setString(1, item.getName());
            ps.setString(2, item.getNumber_car());
            ps.setInt(3, item.getStatus());
            return ps.executeUpdate() > 0; 
        } catch (Exception e) {
            System.out.println("saiiii");    
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteItem(Position item){
        String sql = "delete from posi where position_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, item.getPosition_id());
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateItem(Position item){
        String sql = "update posi set name = ?, number_car = ?, status = ? where position_id = ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, item.getName());
            ps.setString(2, item.getNumber_car());
            ps.setInt(3, item.getStatus());
            ps.setInt(4, item.getPosition_id());
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    public boolean updateStatus(int position_id){
        String sql = "update posi set status = 1 where position_id = ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, position_id);
            
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    public boolean updateStatus0(int position_id){
        String sql = "update posi set status = 0 where position_id = ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, position_id);
            
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public ArrayList<CarDetail> getListDetail(String numberCar){
        ArrayList<CarDetail> items = new ArrayList<>();
        
        String sql = "select posi.name, user.name, user.phone"
                + " from posi left join bill on posi.position_id = bill.position_id"
                + " left join user on bill.user_id = user.user_id where posi.number_car = ? order by posi.name";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, numberCar);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                CarDetail item = new CarDetail();
                item.setPosition_name(rs.getString("posi.name"));
                item.setUser_name(rs.getString("user.name"));
                item.setPhone(rs.getString("user.phone"));
                
                items.add(item);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }
    
}
