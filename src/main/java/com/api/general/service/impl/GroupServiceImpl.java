package com.api.general.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.common.beans.beans.GroupRequest;
import com.api.common.beans.beans.GroupResponse;
import com.api.common.beans.constant.AppConstants;
import com.api.general.model.Group;
import com.api.general.repository.GroupRepository;
import com.api.general.service.IGroupService;

@Service
public class GroupServiceImpl implements IGroupService{
	
	Logger logger = LoggerFactory.getLogger(GroupServiceImpl.class);
	
	@Autowired
	private GroupRepository groupRepository;

	@Override
	public String saveGroup(GroupRequest rq) {
		String rs = null;
		Group group = new Group();
		group.setNama(rq.getNama());
		group.setTglJoin(rq.getTglJoin());
		group.setCreatedAt(new Date());
		
		if (groupRepository.countNameGroup(group.getNama()).equals(0)) {
			groupRepository.save(group);
		}else {
			rs = AppConstants.ALREADY_EXIST;
			logger.error(rs);
		}
		return rs;
	}

	@Override
	public String updateGroup(GroupRequest group) {
		String rs = null;

		try {
			Group groupDto = groupRepository.findById(group.getId()).orElseThrow();
			groupDto.setNama(group.getNama());
			groupDto.setUpdatedAt(new Date());
			groupRepository.save(groupDto);
		} catch (Exception e) {
			rs = AppConstants.DATA_NOT_FOUND;
			logger.error(rs);
		}
		return rs;
	}

	@Override
	public List<GroupResponse> listGroup() {
		List<Group> groups = groupRepository.findAll();
		return groups.stream()
				.map(g -> new GroupResponse(g.getId(), g.getNama(), g.getTglJoin()))
				.collect(Collectors.toList());
	}

	@Override
	public GroupResponse getGroupById(Long id) {
		GroupResponse rs = null;
		try {
			Group g = groupRepository.findById(id).orElseThrow();
			rs = new GroupResponse(g.getId(), g.getNama(), g.getTglJoin());
		} catch (Exception e) {
			logger.error(AppConstants.DATA_NOT_FOUND);
		}
		return rs;
	}
	
	
}
