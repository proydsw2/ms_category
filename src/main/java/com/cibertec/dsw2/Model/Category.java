package com.cibertec.dsw2.Model;

import javax.persistence.*;

@SequenceGenerator(name="seq_category_id", initialValue=1, allocationSize=100)
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_category_id")
    @Column(name = "num_category_id")
    private Long num_category_id;

    @Column(name = "str_description")
    private String str_description;

    public Category(){

    }

    public Category(String str_description) {
        this.str_description = str_description;
    }

    @Override
    public String toString() {
        return "Category{" +
                "num_category_id=" + num_category_id +
                ", str_descripcion='" + str_description + '\'' +
                '}';
    }

    public Long getNum_category_id() {
        return num_category_id;
    }

    public void setNum_category_id(Long num_category_id) {
        this.num_category_id = num_category_id;
    }

    public String getstr_description() {
        return str_description;
    }

    public void setStr_descripcion(String str_description) {
        this.str_description = str_description;
    }
}