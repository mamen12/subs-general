package com.api.general.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.common.beans.beans.Request;
import com.api.common.beans.beans.Response;
import com.api.common.beans.beans.SaldoRequest;
import com.api.common.beans.beans.SaldoResponse;
import com.api.common.beans.constant.ApiResponse;
import com.api.general.service.ISaldoService;

@RestController
@RequestMapping("/general")
public class SaldoController {

	@Autowired
	private ISaldoService saldoService;
	
	
	@RequestMapping(value = "/saldo/list", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<SaldoResponse>> listGroup(@RequestBody Request<SaldoRequest> rq ){
    	Response<List<SaldoResponse>> rs = new Response<>();
		
		List<SaldoResponse> saldos = saldoService.listSaldo();
		if (saldos.size() > 0) {
			rs.setData(saldos);
			rs.setStatusResponse(ApiResponse.SUCCESS);
		}else {
			rs.setStatusResponse(ApiResponse.DATA_NOT_FOUND);
		}
    	return rs;
    }
}
