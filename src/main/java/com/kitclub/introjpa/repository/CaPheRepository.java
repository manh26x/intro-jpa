package com.kitclub.introjpa.repository;

import com.kitclub.introjpa.entity.CaPhe;
import com.kitclub.introjpa.response.CaPheResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;

public interface CaPheRepository extends JpaRepository<CaPhe, Integer> {

    @Query("SELECT new com.kitclub.introjpa.response.CaPheResponse(" +
            "c.id, c.name, c.hang.name) from CaPhe c " +
            "where (:hangId is null or c.hang.id = :hangId) " +
            " and (:capheName is null or c.name like %:capheName%)")
    List<CaPheResponse> customQuery(String capheName, Integer hangId);
}
