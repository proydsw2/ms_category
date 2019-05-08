package com.cibertec.dsw2.Model;

import javax.persistence.*;

@SequenceGenerator(name="seq_category_id", initialValue=1, allocationSize=100)
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_category_id")
    @Column(name = "num_category_id")
    private Long num_category_id;

    @Column(name = "str_descripcion")
    private String str_descripcion;

    public Category(){

    }

    public Category(String str_descripcion) {
        this.str_descripcion = str_descripcion;
    }

    @Override
    public String toString() {
        return "Category{" +
                "num_category_id=" + num_category_id +
                ", str_descripcion='" + str_descripcion + '\'' +
                '}';
    }

    public Long getNum_category_id() {
        return num_category_id;
    }

    public void setNum_category_id(Long num_category_id) {
        this.num_category_id = num_category_id;
    }

    public String getStr_descripcion() {
        return str_descripcion;
    }

    public void setStr_descripcion(String str_descripcion) {
        this.str_descripcion = str_descripcion;
    }
}