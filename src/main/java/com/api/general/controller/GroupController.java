package com.api.general.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.api.common.beans.beans.GroupRequest;
import com.api.common.beans.beans.GroupResponse;
import com.api.common.beans.beans.Request;
import com.api.common.beans.beans.Response;
import com.api.common.beans.constant.ApiResponse;
import com.api.general.service.IGroupService;

@RestController
@RequestMapping("/general")
public class GroupController {

	@Autowired
	private IGroupService groupService;
	
	
    @RequestMapping(value = "/group/list", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object listGroup(@RequestBody Request<GroupRequest> rq ){
    	Response<List<GroupResponse>> rs = new Response<>();
		
		List<GroupResponse> groups = groupService.listGroup();
		if (groups.size() > 0) {
			rs.setData(groups);
			rs.setStatusResponse(ApiResponse.SUCCESS);
		}else {
			rs.setStatusResponse(ApiResponse.DATA_NOT_FOUND);
		}
		
		if (ObjectUtils.isEmpty(rq.getRequestHeader()) || ObjectUtils.isEmpty(rq.getRequestHeader().getChanel())) {
			return rs.getData();
		}else {
			return rs;
		}
    }
    
	
}
