//package com.bridgelabz.bookstoreapplication.order.entity;
//
//
//import com.bridgelabz.bookstoreapplication.cart.entity.CartEntity;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.ToString;
//
//import java.time.LocalDateTime;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
//@Entity
//@Table(name = "order_details")
//public class OrderEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long order_id;
//
//    @OneToOne
//    @JoinColumn(name = "cart_id", referencedColumnName = "cart_id")
//    private CartEntity cart;
//
//    @Column(nullable = false)
//    private LocalDateTime orderDate;
//
//    @Column(nullable = false)
//    private Boolean cancel;
//
//    @Column(length = 500)
//    private String address;
//
//}
package com.bridgelabz.bookstoreapplication.order.entity;

import com.bridgelabz.bookstoreapplication.cart.entity.CartEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "order_details")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;

    @OneToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "cart_id")
    private CartEntity cart;

    @Column(nullable = false)
    private LocalDateTime orderDate;

    @Column(nullable = false)
    private Boolean cancel;

    @Column(length = 500)
    private String address;
}
