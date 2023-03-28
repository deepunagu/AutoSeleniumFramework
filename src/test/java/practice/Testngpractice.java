package practice;

import org.testng.annotations.Test;

public class Testngpractice {

	@Test(enabled=false)
	public void createUser(){
		System.out.println("create");
	}
	
	@Test(priority=2)
	public void updateUser() {
		System.out.println("update");
	}
	
	@Test(priority=3)
	public void deleteUser() {
		System.out.println("delete");
	}
}


