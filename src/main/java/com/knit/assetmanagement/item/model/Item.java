package com.knit.assetmanagement.item.model;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, name = "manufacturer")
    private String manufacturer;

    @Column(nullable = false, name = "model")
    private String model;

    @Column(nullable = false, name = "asset_id")
    private Long asset_id;

    @Column(nullable = false, name = "product_number")
    private String product_number;

    @Column(name = "description")
    private String description;

    @Column(name = "vendor_id")
    private Long vendor_id;

    @Column(nullable = false, name = "status")
    private String status;

    @Column(nullable = false, name = "create_date")
    private String create_date;

    @Column(name = "last_updated")
    private String last_updated;

    @Column(nullable = false, name = "asset_quantity")
    private Long asset_quantity;

    @Column(nullable = false, name = "comment")
    private String comment;

    @Column(nullable = false, name = "operator_id")
    private String operator_id;
}
