package com.api.general.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.api.general.service.ISaldoService;

@RestController
public class SaldoController {

	@Autowired
	private ISaldoService saldoService;
	
}
