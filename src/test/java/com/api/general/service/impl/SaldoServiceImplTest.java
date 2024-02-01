package com.api.general.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.common.beans.beans.SaldoRequest;
import com.api.general.service.ISaldoService;

@SpringBootTest
class SaldoServiceImplTest {

	@Autowired
	private ISaldoService saldoService;
	
	@Test
	void test() {
		SaldoRequest saldo = new SaldoRequest();
		saldo.setAmount(new BigDecimal(9000000));
		saldo.setJenis("Asuransi");
		
		String rs =  saldoService.saveSaldo(saldo);
		assertNull(rs);
	}

}
