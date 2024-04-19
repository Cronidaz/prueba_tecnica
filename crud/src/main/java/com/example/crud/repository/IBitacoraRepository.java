package com.example.crud.repository;

import com.example.crud.model.BitacoraModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBitacoraRepository extends JpaRepository<BitacoraModel, Long> {

    @Query("SELECT b FROM BitacoraModel b WHERE b.id = :id")
    List<BitacoraModel> findByUserId(@Param("id") Long id);
}
