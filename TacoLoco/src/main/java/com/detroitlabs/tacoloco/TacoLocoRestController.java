package com.detroitlabs.tacoloco;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.detroitlabs.tacoloco.dao.GrandTotal;
import com.detroitlabs.tacoloco.dao.Item;
import com.detroitlabs.tacoloco.dao.Order;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@RestController
public class TacoLocoRestController {

	@GetMapping(value = "/index")
	public ModelAndView index() {

		// new creates object variable
		return new ModelAndView("index");
	}

	@PostMapping(value = "/order")
	public GrandTotal caculateTotal(@RequestBody String placedOrder) {
		try {
			placedOrder = URLDecoder.decode(placedOrder, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Removing unwanted text in JSON string from query parameters
		placedOrder = placedOrder.substring(placedOrder.indexOf('=') + 1);
		System.out.println(placedOrder);
		// Converting JSON string to an array list of items using GSON library
		Gson gson = new Gson();

		// Using GSON to map from lists in a JSON structure to Java object
		Type deserializationType = new TypeToken<ArrayList<Item>>() {
		}.getType();

		List<Item> items = gson.fromJson(placedOrder, deserializationType);

		// Parsed JSON, now we need an "Order" object

		Order order = new Order(items);

		// Returns results as JSON
		GrandTotal grandTotal = order.getGrandTotal();
		return grandTotal;

	}
}
