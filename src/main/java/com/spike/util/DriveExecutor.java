package com.spike.util;


public class DriveExecutor {

			public void drive(Class<? extends Vehicle> clazz) {
				try {
					Vehicle v = clazz.newInstance();
					v.drive();
				} catch (InstantiationException e) {
					e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
				} catch (IllegalAccessException e) {
					e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
				}

			}


		   public static void main(String[] args) {
			   DriveExecutor executor = new DriveExecutor();
			   executor.drive(Van.class);
		   }

}
