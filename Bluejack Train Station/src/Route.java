import java.util.ArrayList;

public class Route {
	private String destination;
	private int distance;
	private String id;
	private int price;
	
	
	
	public Route(String destination, int distance) {
		String id = "BJ";
		
		this.destination = destination;
		this.distance = distance;
		
		for(int i = 0; i<3; i++) {
			int random = (int) (Math.random()*10);
			id += random;
		}
		this.id = id;
		
		this.price = price;
	}
	
	
	ArrayList<Route> routeList = new ArrayList<>();
	
	public ArrayList<Route> getAllRoute() {
		return routeList;
	}
	
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPrice() {
		
		price = (distance/2*1000) + 10000;
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
	
	
}
