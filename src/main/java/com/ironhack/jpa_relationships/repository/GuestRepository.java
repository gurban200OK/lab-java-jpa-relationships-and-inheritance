package com.ironhack.jpa_relationships.repository;

import com.ironhack.jpa_relationships.entity.Guest;
import com.ironhack.jpa_relationships.entity.GuestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
    List<Guest> findByStatus(GuestStatus status);
}
