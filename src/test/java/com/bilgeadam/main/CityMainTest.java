package com.bilgeadam.main;

import com.bilgeadam.controller.CityController;
import com.bilgeadam.entity.CityEntity;
import com.bilgeadam.util.EColor;

public class CityMainTest {
	
	public static void main(String[] args) {
		// JPQL- HQL-SQL
		
		//// Create
		for (int i = 0; i < 10; i++) {
			CityEntity cityEnty = new CityEntity("İstanbul" + (i + 1), "Bahçe" + (i * 25), EColor.mavi);
			CityController studentController1 = new CityController();
			studentController1.create(cityEnty);
		}
		
		//// find
		// CityController studentController2 = new CityController();
		// int id = 1;
		// studentController2.find(id);
		
		// // delete
		// CityController cityController3 = new CityController();
		// CityEntity cityEntity3 = new CityEntity();
		// cityEntity3.setId(2);
		// cityController3.delete(cityEntity3);
		
		// // update
		// CityEntity studentEntity4 = new CityEntity("Malatya", "Kayısı");
		// studentEntity4.setId(1);
		// CityController studentController4 = new CityController();
		// studentController4.update(studentEntity4);
		
		//// list
		// CityController studentController4 = new CityController();
		// for (CityEntity temp : studentController4.list()) {
		// System.out.println(temp);
		// }
		
	}
	
}
