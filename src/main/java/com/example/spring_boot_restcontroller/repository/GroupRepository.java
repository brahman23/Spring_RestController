package com.example.spring_boot_restcontroller.repository;

import com.example.spring_boot_restcontroller.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
}