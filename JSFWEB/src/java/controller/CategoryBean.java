/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CategoryDAO;
import entity.Category;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;



/**
 *
 * @author olcay
 */
@Named
@SessionScoped
public class CategoryBean implements Serializable {

    private CategoryDAO dao;
    private Category entity;

    //CRUD
    public String create() {
        this.getDao().create(entity);
        return "index";
    }

    public List<Category> getRead() {
        return this.getDao().read();
    }

    public String updateForm(Category c) {
        this.entity = c;
        return "update";
    }

    public String update() {
        this.getDao().update(entity);
        return "index";
    }

    public void delete(Category c) {
        this.getDao().delete(c);
    }

    public CategoryBean() {
    }

    public CategoryDAO getDao() {
        if(this.dao == null)
            this.dao = new CategoryDAO();
        return dao;
    }

    public void setDao(CategoryDAO dao) {
        this.dao = dao;
    }

    public Category getEntity() {
        if(this.entity == null)
            this.entity = new Category();
        return entity;
    }

    public void setEntity(Category entity) {
        this.entity = entity;
    }

}
