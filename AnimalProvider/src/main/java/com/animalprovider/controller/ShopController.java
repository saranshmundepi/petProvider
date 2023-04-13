package com.animalprovider.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.animalprovider.entities.Shop;
import com.animalprovider.services.ShopService;

@RestController
@RequestMapping("/api/shops")
public class ShopController {

	@Autowired
	private ShopService shopService;

	@GetMapping("getListOfAllShops")
	public List<Shop> getAllShops() {
		return shopService.getAllShops();
	}

	@GetMapping("/getShop/{id}")
	public Shop getShopById(@PathVariable Integer id) {
		return shopService.getShopById(id);

	}

	@PostMapping("/addShop")
	public String saveShop(@RequestBody Shop shop) {
		if (shopService.saveShop(shop))
			return shop.toString() + " Added";
		return shop.toString() + " NOT Added";
	}

	@PostMapping("/addListOfShops")
	public String saveListOfShops(@RequestBody List<Shop> listOfShops) {
		String response = null;
		for (Shop shop : listOfShops)
			response = response + "\n" + saveShop(shop);
		return response;
	}

	@DeleteMapping("/deleteShop/{id}")
	public String deleteShop(@PathVariable Integer id) throws CloneNotSupportedException {
		Shop x = getShopById(id);
		if (Objects.isNull(x))
			return "No such shop present";

		Shop shopClone = x.clone();
		shopService.deleteShop(id);

		x = getShopById(id);
		if (Objects.isNull(x))
			return shopClone.toString() + " Deleted";

		return shopClone.toString() + "Can't not be deleted ";

	}
}
