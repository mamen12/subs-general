package com.api.general.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.api.common.beans.beans.GroupRequest;
import com.api.common.beans.beans.GroupResponse;
import com.api.common.beans.beans.Request;
import com.api.common.beans.beans.Response;
import com.api.common.beans.constant.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@AutoConfigureMockMvc
class GroupControllerTest {

	@Autowired
    private MockMvc mockMvc;
	
	@Test
	void test() throws JsonProcessingException, Exception {
		ObjectMapper mapper = new ObjectMapper();
		Request<GroupRequest> rq = new Request<GroupRequest>();
		
		 mockMvc.perform(
	                post("/group/list")
	                        .accept(MediaType.APPLICATION_JSON)
	                        .contentType(MediaType.APPLICATION_JSON)
	                        .content(mapper.writeValueAsString(rq))
	        ).andExpectAll(
	                status().isOk()
	        ).andDo(result -> {
	            Response<GroupResponse> response = mapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
	            });
	            assertEquals(response.getStatus(), ApiResponse.SUCCESS.getCode().toString());
	        });
		
	}

}
