package com.api.general.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.general.model.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long>{

}
