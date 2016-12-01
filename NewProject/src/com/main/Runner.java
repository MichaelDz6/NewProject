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
		
		ordersL.add(new Order(1, 1, d1, 10, 1));
		ordersL.add(new Order(1, 1, d1 + 1000, 12, 5));
		ordersL.add(new Order(1, 1, d1 + 1100, 14, 14));
		ordersL.add(new Order(1, 1, d1 + 1700, 12,3 ));
		
		ordersS.add(new Order(1, 1, d1 + 500, 13, 7));
		ordersS.add(new Order(1, 1, d1 + 800, 10, 9));
		ordersS.add(new Order(1, 1, d1 + 900, 18, 3));
		
		runner.sort(ordersL);
		runner.sort(ordersS);
		
		System.out.println("Longs");
		for (int i = 0; i < ordersL.size(); i++) {
			System.out.println((i+1) + ". " + ordersL.get(i).getTime() + ", " + ordersL.get(i).getPrice() + ", Volume = " + ordersL.get(i).getVolume() );	
//			System.out.println((i+1) + ". " + ordersL.print());
		}
		System.out.println("Shorts");
		for (int i = 0; i < ordersS.size(); i++) {
			System.out.println((i+1) + ". " + ordersS.get(i).getTime() + ", " + ordersS.get(i).getPrice() + ", Volume = " + ordersS.get(i).getVolume() );	
//			System.out.println((i+1) + ". " + ordersS.p);
		}
		
//		while(running) {
//			if(ordersL.size() > 0 && ordersS.size() > 0 && change == true) {
//				
//			}
//		}
		
	}
	
	
	public void sendOrder(int securityID, int position, double price, int volume) {
		Date date = new Date();
		if(position == 1) {
			ordersL.add(new Order(securityID, position, date.getTime(), price, volume));
		}else {
			ordersS.add(new Order(securityID, position, date.getTime(), price, volume));
		}
	}
	
	public void matchOrders() {
		boolean match = true;
		
		while(match){
			if(ordersL.get(0).getPrice() >= ordersS.get(0).getPrice()){
				
			}else{
				match = false;
			}
		}
		

	}
	
	
	
	private static void sort(ArrayList<Order> orders) {

	    Collections.sort(orders, new Comparator() {

	        public int compare(Object o1, Object o2) {

	            Double x1 = ((Order) o1).getPrice();
	            Double x2 = ((Order) o2).getPrice();
	            int sComp = x1.compareTo(x2);

	            if (sComp != 0) {
	               return -sComp;
	            } else {
	               Long d1 = ((Order) o1).getTime();
	               Long d2 = ((Order) o2).getTime();
	               return d1.compareTo(d2);
	            }
	    }});
	}

}
