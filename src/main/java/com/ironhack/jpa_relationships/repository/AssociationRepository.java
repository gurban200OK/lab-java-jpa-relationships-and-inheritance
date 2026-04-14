package com.ironhack.jpa_relationships.repository;

import com.ironhack.jpa_relationships.entity.Association;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociationRepository extends JpaRepository<Association, Long> {
}
