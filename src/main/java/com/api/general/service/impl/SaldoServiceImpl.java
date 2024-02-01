package com.api.general.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.common.beans.beans.SaldoRequest;
import com.api.common.beans.beans.SaldoResponse;
import com.api.common.beans.constant.AppConstants;
import com.api.general.model.Saldo;
import com.api.general.repository.SaldoRepository;
import com.api.general.service.ISaldoService;

@Service
public class SaldoServiceImpl implements ISaldoService{

	Logger logger = LoggerFactory.getLogger(SaldoServiceImpl.class);

	
	@Autowired
	private SaldoRepository saldoRepository;

	@Override
	public String saveSaldo(SaldoRequest rq) {
		String rs = null;
		Saldo saldo = new Saldo();
		saldo.setJenis(rq.getJenis());
		saldo.setAmount(rq.getAmount());
		saldo.setCreatedAt(new Date());
		
		try {
			saldoRepository.save(saldo);
		} catch (Exception e) {
			rs= AppConstants.ALREADY_EXIST;
		}
		return rs;
	}

	@Override
	public String updateSaldo(SaldoRequest rq) {
		String rs = null;
		try {
			Saldo saldo = saldoRepository.findById(rq.getId()).orElseThrow();
			saldo.setAmount(rq.getAmount());
			saldo.setUpdatedAt(new Date());
			
			saldoRepository.save(saldo);
		} catch (Exception e) {
			rs = AppConstants.DATA_NOT_FOUND;
		}
		return rs;
	}

	@Override
	public List<SaldoResponse> listSaldo() {
		List<SaldoResponse> rs = new ArrayList<SaldoResponse>();
		
		List<Saldo> saldos = saldoRepository.findAll();
		
		rs = saldos.stream()
				.map(s -> new SaldoResponse(s.getId(), s.getJenis(), s.getAmount()))
				.collect(Collectors.toList());
		return rs;
	}

	@Override
	public SaldoResponse getSaldoById(Long id) {
		SaldoResponse rs = null;
		try {
			Saldo saldo = saldoRepository.findById(id).orElseThrow();
			rs = new SaldoResponse(saldo.getId(), saldo.getJenis(), saldo.getAmount());
		} catch (Exception e) {
			logger.error(e.getMessage() + AppConstants.DATA_NOT_FOUND);
		}
		return rs;
	}
	
	
}
