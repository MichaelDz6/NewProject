package com.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import com.data.Order;

public class Runner {
	
	private static ArrayList<Order> ordersL = new ArrayList<Order>();
	private static ArrayList<Order> ordersS = new ArrayList<Order>();
	private static volatile boolean running = true;
	private static boolean change = false;

	public static void main(String[] args) {
		Runner runner = new Runner();
		
		long d1 = new Date().getTime();
		
		ordersL.add(new Order(1, 1, d1, 10));
		ordersL.add(new Order(1, 1, d1 + 1000, 13));
		ordersL.add(new Order(1, 1, d1 + 1100, 14));
		ordersL.add(new Order(1, 1, d1 + 1700, 12));
		
		ordersS.add(new Order(1, 1, d1 + 500, 13));
		ordersS.add(new Order(1, 1, d1 + 800, 10));
		ordersS.add(new Order(1, 1, d1 + 900, 18));
		
		runner.sort(ordersL);
		runner.sort(ordersS);
		
		System.out.println("Longs");
		for (int i = 0; i < ordersL.size(); i++) {
			System.out.println((i+1) + ". " + ordersL.get(i).getTime() + ", " + ordersL.get(i).getPrice());	
		}
		System.out.println("Shorts");
		for (int i = 0; i < ordersS.size(); i++) {
			System.out.println((i+1) + ". " + ordersS.get(i).getTime() + ", " + ordersS.get(i).getPrice());	
		}
		
//		while(running) {
//			if(ordersL.size() > 0 && ordersS.size() > 0 && change == true) {
//				
//			}
//		}
		
	}
	
	
	public void sendOrder(int securityID, int position, double price) {
		Date date = new Date();
		if(position == 1) {
			ordersL.add(new Order(securityID, position, date.getTime(), price));
		}else {
			ordersS.add(new Order(securityID, position, date.getTime(), price));
		}
	}
	
	public void matchOrders() {
//		for (int i = 0; i < orders.size(); i++) {
//			
//		}
	}
	
	
	
	private static void sort(ArrayList<Order> orders) {

	    Collections.sort(orders, new Comparator() {

	        public int compare(Object o1, Object o2) {

	            Double x1 = ((Order) o1).getPrice();
	            Double x2 = ((Order) o2).getPrice();
	            int sComp = x1.compareTo(x2);

	            if (sComp != 0) {
	               return sComp;
	            } else {
	               Long d1 = ((Order) o1).getTime();
	               Long d2 = ((Order) o2).getTime();
	               return d1.compareTo(d2);
	            }
	    }});
	}

}
