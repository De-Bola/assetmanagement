package com.knit.assetmanagement.vendor.model;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Vendor {
    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;

    public Vendor(String name, String address){
        this.name = name;
        this.address = address;
    }
}
