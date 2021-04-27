package ru.arturios.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "title", length = 128)
    private String title;

    @Column(name = "price")
    private int price;
}
