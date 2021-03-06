package com.bridgelabz.fellowship.productmenu;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.bridgelabz.fellowship.inventory.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Inventorymanager {
	// inventory path
	public static String spath = "/home/admin1/Desktop/ganeshproject/InventoryManagement/src/com/bridgelabz/felloship/inventoryfile/inventory.json";

	public static void main(String[] args) {
		priceMenu();
	}

	public static void priceMenu() {
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("*************Inventory Menu****************");
		List<Product> list = null;
		try {
			// Read all inventorys
			list = mapper.readValue(new File(spath), new TypeReference<List<Product>>() {
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (Product product : list) { // show all inventorys
			System.out.print(product.type + ":");
			System.out.println(product.name + " = " + (product.price * product.weight) / product.weight + " / Kg");
		}
		System.out.println();
	}
}