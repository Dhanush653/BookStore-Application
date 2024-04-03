//package com.bridgelabz.bookstoreapplication.order.repository;
//
//import com.bridgelabz.bookstoreapplication.order.entity.OrderEntity;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//
//public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
//    // Fetch non-canceled orders
//    List<OrderEntity> findByCancelFalse();
//
//    // Fetch orders by Cart's User ID and not canceled
//    List<OrderEntity> findByCart_User_user_idAndCancelFalse(Long userId);
//}
package com.bridgelabz.bookstoreapplication.order.repository;

import com.bridgelabz.bookstoreapplication.order.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    // Fetch non-canceled orders
    List<OrderEntity> findByCancelFalse();

    // Fetch orders by Cart's User ID and not canceled
//    List<OrderEntity> findByCart_User_User_idAndCancelFalse(Long userId);
    @Query("SELECT o FROM OrderEntity o WHERE o.cart.user.user_id = :userId")
    List<OrderEntity> findByUserId(@Param("userId") Long userId);

}
