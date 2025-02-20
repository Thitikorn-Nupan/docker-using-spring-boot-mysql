package com.ttknpdev.buildbasicapiusingspringboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "romances")
public class Romance {
    @Id
    private String rid;
    private String title;
    private Integer price;
}
