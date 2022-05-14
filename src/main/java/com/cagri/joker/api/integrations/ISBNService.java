package com.cagri.joker.api.integrations;

public interface ISBNService {

	ISBNClientResponse getISBNInfoFromExternalService(ISBNClientRequest request);

}
