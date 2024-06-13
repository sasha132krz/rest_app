package org.example.db.model;

import lombok.Data;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Entity
@Table(name = "PieceOfArt")
@Data
public class PieceOfArt {
    public PieceOfArt() {
    }

    public PieceOfArt(String name, Integer year, Integer price) {
        this.name = name;
        this.year = year;
        this.price = price;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Column(name = "year")
    private Integer year;

    @Column(name = "price")
    private Integer price;

    @Transactional
    public void setCategory(Category category) {
        this.category = category;
    }

    @Transactional
    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}