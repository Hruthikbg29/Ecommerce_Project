package com.Project.Service;

import org.json.JSONObject;

public interface PaymentService {
	JSONObject createOrder(Integer amount) throws Exception;
}
