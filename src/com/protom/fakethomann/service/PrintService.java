package com.protom.fakethomann.service;

import com.protom.fakethomann.model.entity.User;

public class PrintService {
	
	
	public void printAnUser(User user) {
		
		
		System.out.println("Print::");
		
		if(user!=null) {
			
			System.out.println("username:"+user.getUsername());
			System.out.println("name:"+user.getName());
			System.out.println("surname:"+user.getSurname());
		
		}	else {
			
				System.out.println("User not found!");
		}
		
		System.out.println("-----------");
		
	}

}
