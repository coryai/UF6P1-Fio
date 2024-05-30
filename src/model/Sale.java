package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Sale {
	private Client client;
	private ArrayList<Product> products;
	private Amount amount;
	LocalDateTime saleDateTime;

	public Sale(Client client, ArrayList<Product> products, double amount) {
		super();
		this.client = client;
		this.products = products;
		this.amount = new Amount(amount);
		this.saleDateTime = LocalDateTime.now();
	}

	public String getClient() {
		return client.getName();
	}

	public void setClient(String client) {
		this.client.setName(client);
	}

	public ArrayList<Product>  getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product>  products) {
		this.products = products;
	}

	public double getAmount() {
		return amount.getValue();
	}

	public void setAmount(double amount) {
		this.amount.setValue(amount);
	}
	
	

	@Override
	public String toString() {
		String productNames ="";
		String client = "\nClient:" +  this.client.toUpperCase() + "\n" ;
		for (Product product : this.products) {
			if (product != null) {
				if (product.getName() != null) {
					productNames += product.getName() + " Cost: " + product.getPublicPrice() +"\n";

				}
			}
		}
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
        String saleDateFormatted = saleDateTime.format(formatter);
        
		return client + "products:\n" + productNames + "amount=[" + amount + "]\n" + "Sale Date and Time: " + saleDateFormatted + "\n";

	}

	public int getFecha() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getImporte() {
		// TODO Auto-generated method stub
		return 0;
	}

}