/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Vang
 */
public class UserDAO extends DAO {

    public UserDAO() {
        super();
    }

    public User checkLogin(String phone, String password) {
        String role = null;
        User item = new User();
//        item = null;
        String sql = "select * from user where phone = ? and password = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, phone);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                item.setUser_id(rs.getInt("user_id"));
                item.setPhone(rs.getString("phone"));
                item.setPassword(rs.getString("password"));
                item.setRole(rs.getString("role")); 
            }else{
                item = null;
            }
        } catch (Exception e) {
        }
        return item;
    }
    public boolean register(User item){
        String sql = "insert into user(name, phone, address, password, role) values(?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, item.getName());
            ps.setString(2, item.getPhone());
            ps.setString(3, item.getAddress());
            ps.setString(4, item.getPassword());
            ps.setString(5, item.getRole());
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return false;
    }
    public int getIdUser(User item){
        String sql = "select * from user where name = ? and phone = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, item.getName());
            ps.setString(2, item.getPhone());
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                item.setUser_id(rs.getInt("user_id"));
            }
            return item.getUser_id();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item.getUser_id();
    }

}
