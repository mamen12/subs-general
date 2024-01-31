package com.api.general.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.general.repository.SaldoRepository;
import com.api.general.service.ISaldoService;

@Service
public class SaldoServiceImpl implements ISaldoService{

	
	@Autowired
	private SaldoRepository saldoRepository;
	
	
}
