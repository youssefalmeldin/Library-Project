package com.library.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tittle;
    private LocalDateTime publish_dateTime;
    private double version;

    @ManyToOne(cascade = CascadeType.ALL)
    private Author author;

}
