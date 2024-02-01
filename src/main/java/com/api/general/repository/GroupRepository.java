package com.api.general.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.general.model.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long>{

	// check name uniqe
	@Query("SELECT COUNT(u) FROM Group u WHERE u.nama=?1")
	public Integer countNameGroup(String name);
	
}
