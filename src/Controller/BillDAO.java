/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Bill;
import Model.BillDetail;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Vang
 */
public class BillDAO extends DAO {

    public BillDAO() {
        super();
    }

    public ArrayList<BillDetail> getListItem(int maKh) {
        ArrayList<BillDetail> items = new ArrayList<>();
        String sql = "select bill_id, cars.number_car, cars.name, cars.date, cars.time, cars.price, posi.name, place.name from"
                + " bill inner join cars on bill.number_car = cars.number_car"
                + " inner join posi on bill.position_id = posi.position_id "
                + "inner join place on bill.place_id = place.place_id where bill.user_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, maKh);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                BillDetail item = new BillDetail(
                        rs.getInt("bill_id"),
                        rs.getString("cars.number_car"),
                        rs.getString("cars.name"),
                        rs.getDate("cars.date"),
                        rs.getString("cars.time"),
                        rs.getFloat("cars.price"),
                        rs.getString("posi.name"),
                        rs.getString("place.name")
                );

                items.add(item);
            }
        } catch (Exception e) {
        }
        return items;
    }

    public Bill getItem(int bill_id) {
        Bill item = new Bill();
        String sql = "select * from bill where bill_id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, bill_id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                item = new Bill(
                        rs.getInt("bill_id"),
                        rs.getInt("user_id"),
                        rs.getString("number_car"),
                        rs.getInt("position_id"),
                        rs.getInt("place_id")
                );

            }
        } catch (Exception e) {
        }
        return item;
    }

    public boolean addItem(Bill item) {
        String sql = "insert into bill(user_id, number_car, position_id, place_id) values(?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, item.getUser_id());
            ps.setString(2, item.getNumber_car());
            ps.setInt(3, item.getPosition_id());
            ps.setInt(4, item.getPlace_id());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean UpdateItem(int ghe,int diemdon, int id) {
        String sql = "update bill set position_id = ?, place_id = ? where bill_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, ghe);
            ps.setInt(2, diemdon);
            ps.setInt(3, id);

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean DeleteItem(int id) {
        String sql = "delete from bill where bill_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
