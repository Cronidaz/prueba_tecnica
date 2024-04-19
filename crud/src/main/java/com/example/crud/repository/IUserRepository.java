package com.example.crud.repository;

import com.example.crud.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<UserModel, Long> {

    @Query("select u from  UserModel u where u.email = :email")
    Optional<UserModel> findByEmail(@Param("email") String email);

    @Query("select u from  UserModel u where u.email = :email and u.password = :password")
    Optional<UserModel> findByEmailAndPwd(@Param("email") String email, @Param("password") String password);
}
