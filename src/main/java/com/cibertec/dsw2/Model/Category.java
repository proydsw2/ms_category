package com.cibertec.dsw2.Model;

import lombok.*;
import javax.persistence.*;

@SequenceGenerator(name="seq_category_id", allocationSize=1)
@Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_category_id")
    @Column(name = "num_category_id")
    private Integer num_category_id;

    @Column(name = "str_description")
    private String str_description;

}