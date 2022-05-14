package com.cagri.joker.api.integrations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cagri.joker.api.exceptions.BusinessException;

@Service
public class ISBNServiceImpl implements ISBNService{
	
	private static Logger log = LoggerFactory.getLogger(ISBNServiceImpl.class);
	
	@Value("${application.cagri.joker.isbn.url}")
	private String isbnUrl;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public ISBNClientResponse getISBNInfoFromExternalService(ISBNClientRequest request) {
		ISBNClientResponse response = null;
		ResponseEntity<ISBNClientResponse> responseEntity = null;
		
		try {
			String url = isbnUrl;

			HttpEntity<ISBNClientRequest> entity = new HttpEntity<ISBNClientRequest>(request);
			responseEntity = restTemplate.postForEntity(url, entity, ISBNClientResponse.class);
			response = responseEntity.getBody();
			return response;
			
		} catch (Exception e) {
			log.error("get ISBN number from external service ERROR: " , e);
			throw new BusinessException("Error get ISBN number from external service...");
		}
	}


}
