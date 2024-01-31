package com.api.general.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.api.general.service.IGroupService;

@RestController
public class GroupController {

	@Autowired
	private IGroupService groupService;
	
	
	
}
