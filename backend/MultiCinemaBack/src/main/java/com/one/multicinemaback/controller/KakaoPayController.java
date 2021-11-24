package com.one.multicinemaback.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.boot.json.JsonParser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.one.multicinemaback.dto.KakaoPayDto;
import com.one.multicinemaback.service.KakaoPayService;

@RestController
public class KakaoPayController {
	
	@Autowired
	KakaoPayService kservice;

	@RequestMapping(value = "/kakaopay", method =RequestMethod.GET)
	public String kakaopay(String id, String product, String count, String payprice) throws UnsupportedEncodingException {
		System.out.println("KakaoPayController kakaopay()");
		System.out.println(id);
		String pname = URLEncoder.encode(product, "UTF-8");
		System.out.println(pname);
		try {
			URL address = new URL("https://kapi.kakao.com/v1/payment/ready");
			HttpURLConnection conn = (HttpURLConnection) address.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Authorization", "KakaoAK 704f7b7e7e27e8835b13944d7744c8c0");
			conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			conn.setDoOutput(true);
			String parameter = "cid=TC0ONETIME&partner_order_id=1&partner_user_id=MultiCinema&item_name=" + pname + "&quantity=" + count + "&total_amount=" + payprice + "&vat_amount=200&tax_free_amount=0&approval_url=http://localhost:8090/MultiCinemaFront/views/kakaopay/kakaoPaySuccess.html?id=" + id + "&fail_url=https://localhost/fail&cancel_url=https://localhost/cancel";
			OutputStream give = conn.getOutputStream();
			DataOutputStream datagive = new DataOutputStream(give);
			datagive.writeBytes(parameter);
			datagive.close();
			
			int result = conn.getResponseCode();
			
			InputStream receive;
			if(result == 200) {
				receive = conn.getInputStream();
			}else {
				receive = conn.getErrorStream();
			}
			
			InputStreamReader reader = new InputStreamReader(receive);
			
			BufferedReader caster = new BufferedReader(reader);
			
			/*
			JSONObject pay = new JSONObject(caster.readLine());
			String tid = pay.getString("tid");
			*/
			
			return caster.readLine();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "{\"result\":\"NO\"}";
	}
	
	@RequestMapping(value = "/kakaopayready", method = RequestMethod.GET)
	public String kakaopayready(String tid, Model model, String url) {
		
		System.out.println(tid);
		
		/*
		System.out.println(url);
		
		kakaoinfo.setTid(tid);
		
		String tidd = kakaoinfo.getTid();
		
		model.addAttribute("tid", tidd);
		*/
		
		return "redirect:" + url;
	}
	
	@RequestMapping(value = "/insertpay", method = RequestMethod.GET)
	public String insertpay(KakaoPayDto dto) {
		System.out.println("KakaoPayController insertpay()");
		System.out.println(dto);
		
		kservice.insertpay(dto);
		
		return "success";
	}
	
	@RequestMapping(value = "/getspay", method = RequestMethod.POST)
	public KakaoPayDto getspay(String tid) {
		System.out.println("KakaoPayController getspay()");
		System.out.println(tid);
		
		KakaoPayDto dto = kservice.getspay(tid);
		
		System.out.println(dto);
		
		return dto;
	}
}
