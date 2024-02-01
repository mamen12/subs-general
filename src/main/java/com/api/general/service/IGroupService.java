package com.api.general.service;

import java.util.List;

import com.api.common.beans.beans.GroupRequest;
import com.api.common.beans.beans.GroupResponse;

public interface IGroupService {

	public String saveGroup(GroupRequest group);
	
	public String updateGroup(GroupRequest group);
	
	public List<GroupResponse> listGroup();
	
	public GroupResponse getGroupById(Long id);
	
	
}
