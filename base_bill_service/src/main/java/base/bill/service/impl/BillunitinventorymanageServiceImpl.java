package base.bill.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spr.contents.msg.Results;

import base.bill.service.BillunitinventorymanageService;
@SuppressWarnings("unused")
@Service
public class BillunitinventorymanageServiceImpl implements BillunitinventorymanageService{
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public Results<Object> getBillunitinventorymanageBycon(String bill_name) {
	System.out.println("111111111");
	String url = "http://NON-TAX-CORE/billManagement/billBankCountList";

	// 执行HTTP请求
	ResponseEntity<Results> postForEntity = restTemplate.postForEntity(url, bill_name, Results.class);

	return postForEntity.getBody();
	}
}
