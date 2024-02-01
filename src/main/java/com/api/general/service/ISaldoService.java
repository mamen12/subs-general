package com.api.general.service;

import java.util.List;

import com.api.common.beans.beans.SaldoRequest;
import com.api.common.beans.beans.SaldoResponse;

public interface ISaldoService {

	public String saveSaldo(SaldoRequest rq);
	
	public String updateSaldo(SaldoRequest saldo);
	
	public List<SaldoResponse> listSaldo();
	
	public SaldoResponse getSaldoById(Long id);
}
