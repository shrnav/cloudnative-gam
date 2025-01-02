package com.precisely.gam.gamclient;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="gam-addressing")
public interface GavAddressingProxy {
	
	
	
	@GetMapping(value = "/addressing/verify/country/{country}/input/{input}/city/{city}/sp/{sp}/postCode/{postCode}")
	public String getGAV(@PathVariable String country,@PathVariable String input,@PathVariable String city,@PathVariable String sp,@PathVariable String postCode);
	
	@GetMapping(value = "/addressing/predict/country/{country}/input/{input}/city/{city}/sp/{sp}/postCode/{postCode}")
	public String getGTA(@PathVariable String country,@PathVariable String input,@PathVariable String city,@PathVariable String sp,@PathVariable String postCode);	
	
	@GetMapping(value = "/addressing/predict/options/{gtaOptions}")
	public Map<String,String> getGTAOptions(@PathVariable Map<String,String> gtaOptions);	

}
