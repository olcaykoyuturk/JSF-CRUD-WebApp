/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import util.DBConnection;
import entity.Category;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author olcay
 */
public class CategoryDAO extends DBConnection {
    //CRUD

    public void create(Category c) {
        try {
            Statement st = connect().createStatement();
            st.executeUpdate("INSERT INTO category (name) VALUES ('" + c.getName() + "')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Category> read() {
        List<Category> list = new ArrayList<>();
        try {
            Statement st = connect().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM category ORDER BY category_id asc");
            while (rs.next()) {
                Category tmp = new Category(rs.getInt("category_id"), rs.getString("name"));
                list.add(tmp);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void update(Category c) {
        try {
            Statement st = connect().createStatement();
            st.executeUpdate("UPDATE category SET name ='" + c.getName() + "' "
                    + "WHERE category_id = '" + c.getCategoryID() + "' ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Category c) {
        try {
            Statement st = connect().createStatement();
            st.executeUpdate("DELETE FROM category WHERE category_id=" + c.getCategoryID());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
