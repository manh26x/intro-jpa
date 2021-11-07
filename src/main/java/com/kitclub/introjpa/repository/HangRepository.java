package com.kitclub.introjpa.repository;

import com.kitclub.introjpa.entity.Hang;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface HangRepository extends JpaRepository<Hang, Integer> {
    List<Hang> findAll();
    List<Hang> findHangByIdOrNameContains(Integer id, String name);
}
