package com.api.general.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.general.repository.GroupRepository;
import com.api.general.service.IGroupService;

@Service
public class GroupServiceImpl implements IGroupService{
	
	@Autowired
	private GroupRepository groupRepository;
	
	
	
}
