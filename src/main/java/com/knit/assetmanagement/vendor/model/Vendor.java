package com.knit.assetmanagement.vendor.model;

import lombok.*;

import javax.persistence.*;

@Entity()
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "vendors")
public class Vendor {
    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, name = "name")
    private String name;
    @Column(nullable = false, name = "address")
    private String address;
    @Column(nullable = false, name = "phone")
    private String phone;
    @Column(nullable = false, name = "email")
    private String email;

    @Column(name = "website")
    private String website;

    @Column(name = "description")
    private String description;

    public Vendor(String name, String address, String phone, String email){
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
}
