import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static ArrayList<Route> routeList = new ArrayList<>();
	static Scanner scan = new Scanner(System.in);
	public void insertRoute() {
		
		
		String destination = null;
		String id = null;
		int distance = 0;
		
		
		do {
			System.out.print("Input route destinantion [Jakarta | Bogor | Depok | Tangerang | Bekasi] : ");
			destination = scan.nextLine();
			
			if(destination.equals("Jakarta") || destination.equals("Depok") || destination.equals("Bogor")
					|| destination.equals("Tangerang") || destination.equals("Bekasi")) {
				break;
			}
		}while (true);
		do {
			System.out.println("Input route distance [1...1000]");
			distance = scan.nextInt();
			scan.nextLine();
		}while (distance < 1 || distance > 1000);
		
		Route r = new Route(destination, distance);
		routeList.add(r);
	}
	
	public String generateID() {
		String id = "BJ";
		
		for(int i = 0; i<3; i++) {
			int random = (int) (Math.random()*10);
			id += random;
		}
		return id;
	}
	
	public void  viewRoute() {
		
		
		if(routeList.size() == 0) {
			System.out.println("There are no routes available");
			scan.nextLine();
		}else {
			System.out.printf("| %3s | %10s | %5s | %7s |\n", "ID", "To", "Distance", "Price");
			for(int i = 0; i<routeList.size(); i++) {
				System.out.printf("| %3s | %10s | %5s | %7s |\n", routeList.get(i).getId(),routeList.get(i).getDestination() , 
						routeList.get(i).getDistance(), routeList.get(i).getPrice());
			}
		}
		
		
	}
	
	public void updateRoute() {

		String destination = null;
		int price = 0;
		int distance = 0;
	
		
		if(routeList.size() == 0) {
			System.out.println("There are no routes available");
			scan.nextLine();
		}else {
			viewRoute();
			
			System.out.print("Input Route ID to Update : ");
			
			String updateId = scan.nextLine();
			
			int foundIndex = -1;
			
			for(int i = 0; i<routeList.size(); i++) {
				if(routeList.get(i).getId().equals(updateId)) {
					foundIndex = i;
				}
			}
			
			if(foundIndex == -1) {
				System.out.println("Route ID is invalid");
			}else {
				do {
					System.out.print("Input route destinantion [Jakarta | Bogor | Depok | Tangerang | Bekasi] : ");
					destination = scan.nextLine();
					
					if(destination.equals("Jakarta") || destination.equals("Depok") || destination.equals("Bogor")
							|| destination.equals("Tangerang") || destination.equals("Bekasi")) {
						break;
					}
					
				}while (true);
				do {
					System.out.println("Input route distance [1...1000]");
					distance = scan.nextInt();
					scan.nextLine();
				}while (distance < 1 || distance > 1000);
				
				routeList.get(foundIndex).setDestination(destination);
				routeList.get(foundIndex).setDistance(distance);
			}
			
		}
	}
	
	public Main() {
	
		int input = 0;
		
		
		
			do {
				
				System.out.println("BlueJack Station");
				System.out.println("================");
				System.out.println("1. Insert Route");
				System.out.println("2. View Routes");
				System.out.println("3. Update Routes");
				System.out.println("4. Exit");
				System.out.print(">> ");
			
				
				try {
					input = scan.nextInt();
					scan.nextLine();
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				
				if(input == 1) {
					insertRoute();
					
				}else if(input == 2) {
					viewRoute();
				}else if(input == 3) {
					updateRoute();
				}
				
			} while(input != 4 );
	}
		
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
