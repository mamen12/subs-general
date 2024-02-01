package com.api.general.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.common.beans.beans.GroupRequest;
import com.api.common.beans.beans.GroupResponse;
import com.api.common.beans.beans.Response;
import com.api.general.model.Group;
import com.api.general.repository.GroupRepository;
import com.api.general.service.IGroupService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
class GroupServiceImplTest {
	
//	capital lifa
//	pradential
//	eie
//	cigne
//	pagadain
//	bni lifa
//	dplak

	@Autowired
	private IGroupService groupService;

	@Autowired
	private GroupRepository groupRepository;
	
	@BeforeEach
	void setUp() {
//		groupRepository.deleteAll();
	}
	
	@Test
	void test() {
		
		GroupRequest rq = new GroupRequest();
		rq.setNama("capital lifae");
		rq.setTglJoin(new Date());
		
//		Group group = new Group();
//		group.setNama(rq.getNama());
//		group.setTglJoin(rq.getTglJoin());
//		group.setCreatedAt(new Date());
		
		groupService.saveGroup(rq);
		
	}
	
	
	@Test
	void testUpdate() throws JsonProcessingException {

		GroupRequest rq = new GroupRequest();
		rq.setId(3);
		rq.setNama("capital lifae");
		
//		Group group = new Group();
//		group.setId(rq.getId());
//		group.setNama(rq.getNama());
//		group.setUpdatedAt(new Date());
		
		groupService.updateGroup(rq);
		
		
	}
	
	
	@Test
	void testListGroup() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		
		List<Group> groups = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Group group = new Group();
			group.setCreatedAt(new Date());
			group.setNama("test1" +1);
			group.setTglJoin(new Date());
			groups.add(group);
		}
		groupRepository.saveAll(groups);
		
		// get list from repo
		List<Group> groupList = groupRepository.findAll();
		
		Response<List<GroupResponse>> rs = new Response<List<GroupResponse>>();
		List<GroupResponse> listGroups = groupList.stream()
				.map(g -> new GroupResponse(g.getId(), g.getNama(), g.getTglJoin()))
				.collect(Collectors.toList());
		
		rs.setData(listGroups);
		System.out.println(mapper.writeValueAsString(rs));
	}
	
	
	
	@Test
	void testFailed() {
		GroupRequest rq = new GroupRequest();
		rq.setNama("capital lifae");
		rq.setTglJoin(new Date());
		
//		Group group = new Group();
//		group.setNama(rq.getNama());
//		group.setTglJoin(rq.getTglJoin());
//		group.setCreatedAt(new Date());
		
		String response = groupService.saveGroup(rq);
		assertNotNull(response);
	}
	
}
