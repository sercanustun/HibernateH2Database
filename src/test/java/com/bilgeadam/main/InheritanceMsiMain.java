package com.bilgeadam.main;

import com.bilgeadam.controller.MsiController;
import com.bilgeadam.entity.MsiEntity;

public class InheritanceMsiMain {
	
	public static void main(String[] args) {
		
		//// Create
		for (int i = 0; i < 10; i++) {
			MsiEntity cityEnty = new MsiEntity("ram44", "cpu34", "okey");
			MsiController msiController = new MsiController();
			msiController.create(cityEnty);
		}
		
	}
	
}
