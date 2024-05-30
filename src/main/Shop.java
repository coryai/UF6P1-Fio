package main;

import model.Amount;
import model.Client;
import model.Employee;
import model.Product;
import model.Sale;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import view.LoginView;

public class Shop {
	static private Amount cash = new Amount(100);
	// private Product[] inventory;
	static ArrayList<Product> inventory = new ArrayList<>();
	static private int numberProducts;
	// private Sale[] sales = new Sale[10];
	static ArrayList<Sale> sales = new ArrayList<>();
	static private int Stock = 0;
	static private int saleNumber = 0;
	final static double TAX_RATE = 1.04;
	//Employee employee = new Employee(null, 0);

	
	public static void main(String[] args) throws IOException {
		
		//Employee employee = new Employee(null, 0);

		
		initSession();
		
		/*Scanner scanner = new Scanner(System.in);
		

		
		
		int opcion = 0;
		boolean exit = false;

		do {
			System.out.println("\n");
			System.out.println("===========================");
			System.out.println("Menu principal miTienda.com");
			System.out.println("===========================");
			System.out.println("1) Contar caja");
			System.out.println("2) Añadir producto");
			System.out.println("3) Añadir stock");
			System.out.println("4) Marcar producto proxima caducidad");
			System.out.println("5) Ver inventario");
			System.out.println("6) Venta");
			System.out.println("7) Ver ventas");
			System.out.println("8) Ver valor total de ventas");
			System.out.println("9) Eliminar un producto");
			System.out.println("10) Salir programa");
			System.out.print("Seleccione una opción: ");
			opcion = scanner.nextInt();

			switch (opcion) {
			case 1:
				showCash();
				break;

			case 2:
				addProduct(null,0,0);
				break;

			case 3:
				addStock(null, 0);
				break;

			case 4:
				setExpired();
				break;

			case 5:
				showInventory();
				break;

			case 6:
				sale();
				break;

			case 7:
				showSales();
				break;

			case 8:
				showTotalSale();
				break;

			case 9:
				deleteProduct(null);
				break;

			case 10:
				exit = true;
				break;
			}

		} while (!exit);
		System.out.println("Gracias por comprar en miTienda.com");
                */
	}
	
	
	////////////////
	public static void initSession() {
            
            LoginView loginView = new LoginView();
            loginView.setVisible(true);
		/*boolean logged = false;
		Scanner input = new Scanner(System.in);
		Employee employee = new Employee ("Fio");
		
		do {
			System.out.println("Número de empleado:");
			int user = input.nextInt();
			input.nextLine();
			System.out.println("Contraseña");
			String password = input.nextLine();
			
			logged = employee.login(user, password);
		} while(!logged);*/
	}
	////////////////
	
	
	
	

	/**
	 * load initial inventory to shop
	 */
	public static void loadInventory() throws IOException {
	
                File file = new File(System.getProperty("user.dir") + File.separator + "files");
                if(!file.exists()){
                    file.mkdir();
                }
                
                file = new File(System.getProperty("user.dir") + File.separator + "files" + File.separator + "inputInventory.txt");
                
                if(!file.exists()){
                    file.createNewFile();
                }
                
                
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(";");
				String name = null;
				double wholesalerPrice = 0.0;
				int stock = 0;

				for (String part : parts) {
					String[] keyValue = part.split(":");
					if (keyValue.length != 2) {
						continue; // Saltar partes incorrectas
					}
					String key = keyValue[0].trim();
					String value = keyValue[1].trim();
					switch (key) {
					case "Product":
						name = value;
						break;
					case "Wholesaler Price":
						wholesalerPrice = Double.parseDouble(value);
						break;
					case "Stock":
						stock = Integer.parseInt(value);
						break;
					}
				}
				if (name != null) {
					Product product = new Product(name, wholesalerPrice, true, stock);
					addProduct(product);
				}
			}
			System.out.println("Inventario cargado desde el fichero inputInventory.txt");
		} catch (IOException | NumberFormatException e) {
			System.out.println("Error al cargar el inventario");
			e.printStackTrace();
		}
	}

	/**
	 * show current total cash
	 */
	public static String showCash() {
            String mostrarCash = "Dinero actual: " + cash;
            return mostrarCash;
	}

	/**
	 * add a new product to inventory getting data from console
	 */
	public static boolean addProduct(String nombre, int stock, int precio) {
		/*
		 * if (isInventoryFull()) {
		 * System.out.println("No se pueden añadir más productos"); return; }
		 */
		//Scanner scanner = new Scanner(System.in);
		//System.out.print("Nombre: ");
		//String name = scanner.nextLine();
		//System.out.print("Precio mayorista: ");
		//double wholesalerPrice = scanner.nextDouble();
		//System.out.print("Stock: ");
		//int stock = scanner.nextInt();
            Product product = findProduct(nombre);
                if(product != null){
                    return false;
                    
                }else{
                    addProduct(new Product(nombre, stock, true, precio));
                    return true;
                }
		
                
                
	}

	/**
	 * add stock for a specific product
	 */
	public static boolean addStock(String nombre, int stock) {
		/*Scanner scanner = new Scanner(System.in);
		System.out.print("Seleccione un nombre de producto: ");
		String name = scanner.next();*/
		Product product = findProduct(nombre);

		if (product != null) {
			// ask for stock
			//System.out.print("Seleccione la cantidad a añadir: ");
			//Stock = scanner.nextInt();
			// update stock product
			product.setStock(product.getStock() + stock);
			//System.out.println("El stock del producto " + name + " ha sido actualizado a " + product.getStock());
                        return true;

		} else {
			//System.out.println("No se ha encontrado el producto con nombre " + nombre);
                        return false;
		}
	}

	/**
	 * set a product as expired
	 */
	private static void setExpired() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Seleccione un nombre de producto: ");
		String name = scanner.next();
		Product product = findProduct(name);
		product.expire();
		if (product != null) {
			System.out.println("El stock del producto " + product.getName() + " ha sido actualizado a "
					+ product.getPublicPrice());

		}
	}

	/**
	 * show all inventory
	 */
	public static void showInventory() {
		System.out.println("Contenido actual de la tienda:");
		for (Product product : inventory) {
			if (product != null) {
				System.out.println(product);
			}
		}
	}

	/**
	 * make a sale of products to a client
	 */
	public static void sale() {
		// ask for client name
		// Product[] products = new Product[20];
		ArrayList<Product> products = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Realizar venta, escribir nombre cliente");
		String clientName = sc.nextLine();
		Client client = new Client(clientName); //crear objeto cliente
		// int counter = 0;
		// sale product until input name is not 0
		double totalAmount = 0.0;
		String name = "";
		while (!name.equals("0")) {
			System.out.println("Introduce el nombre del producto, escribir 0 para terminar:");
			name = sc.nextLine();

			if (name.equals("0")) {
				break;
			}
			Product product = findProduct(name);
			boolean productAvailable = false;

			if (product != null && product.isAvailable()) {

				productAvailable = true;
				totalAmount += product.getPublicPrice().getValue();
				product.setStock(product.getStock() - 1);
				// if no more stock, set as not available to sale
				if (product.getStock() == 0) {
					product.setAvailable(false);
				}
				// products[counter] = product;
				products.add(product);
				// counter++;
				System.out.println("Producto añadido con éxito");
			}
			
			
			
			//Llamamos al método pay() del cliente con el total de la compra
		    if (client.pay(new Amount(totalAmount))) {
		        Sale sale = new Sale(client, products, totalAmount * TAX_RATE);
		        sales.add(sale);
		        cash.setValue(totalAmount * TAX_RATE + cash.getValue());
		        System.out.println("Venta realizada con éxito, total: " + totalAmount * TAX_RATE);
		    }
			

			if (!productAvailable) {
				System.out.println("Producto no encontrado o sin stock");
			}
		}

		Sale sale = new Sale(client, products, totalAmount); // hay que crearlo aquí porque anteriormente no
																			// existe un método que cree la venta
		sales.add(sale);
		// otra forma de hacer lo de arriba: sales.add(new Sale(client,products,new
		// Amount(totalAmount)));

		// sales[saleNumber] = new Sale(client,products,new Amount(totalAmount));
		// saleNumber++;

		// show cost total
		totalAmount = totalAmount * TAX_RATE;
		cash.setValue(totalAmount + cash.getValue());
		System.out.println("Venta realizada con éxito, total: " + totalAmount);
	}

	/**
	 * show all sales
	 */
	public static void showSales() {
		System.out.println("Lista de ventas:");
		for (Sale sale : sales) {
			if (sale != null) {
				System.out.println(sale.toString());
			}
		}

		Scanner sc = new Scanner(System.in);
		System.out.println("¿Desea guardar estas ventas en un archivo?(S/N)");
		String option = sc.next();

		if (option.equalsIgnoreCase("S")) {
			try {
				LocalDateTime currentDate = LocalDateTime.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String dateString = currentDate.format(formatter);

				String fileName = "./files/sales_" + dateString + ".txt";

				File file = new File(fileName);

				FileWriter writer = new FileWriter(file);
				PrintWriter printWriter = new PrintWriter(writer);

				int saleNumber = 1;
				for (Sale sale : sales) {
					if (sale != null) {
						printWriter.println(saleNumber + ";Cliente=" + sale.getClient() + ";Fecha=" + sale.getFecha());
						printWriter.println(saleNumber + ";Productos=" + sale.getProducts());
						printWriter.println(saleNumber + ";Importe=" + sale.getImporte());
						saleNumber++;
					}
				}

				printWriter.close();

				System.out.println("Se ha guardado la información de ventas en el archivo: " + fileName);
			} catch (IOException e) {
				System.out.println("Error al guardar la información de ventas.");
				e.printStackTrace();
			}
		} else {
			System.out.println("No se ha guardado la información de ventas.");
		}
	}

	/*
	 * add a product to inventory
	 *
	 * @param product
	 */
	public static void addProduct(Product product) {
		/*
		 * if (isInventoryFull( )) { System.out.
		 * println("No se pueden añadir más productos, se ha alcanzado el máximo de " +
		 * inventory.length); return; }
		 */

		inventory.add(product); // Como ya existe el objeto, no es necesairo volver a crearlo
		// inventory[numberProducts] = product;
		// numberProducts++;
	}

	/**
	 * check if inventory is full or not -------- YA NO ES NECESARIO --------
	 */
	/*
	 * public boolean isInventoryFull() { if (numberProducts == 10) { return true; }
	 * else { return false; }
	 * 
	 * }
	 */

	// show the total amount of all the sales

	public static void showTotalSale() {
		double totalAmount = 0;
		for (Sale sale : sales) {
			if (sale != null) {
				totalAmount += sale.getAmount();
			}
		}
		System.out.println("El valor total de todas las ventas es: " + totalAmount);
	}

	/**
	 * find product by name
	 *
	 * @param product name
	 */
	public static Product findProduct(String name) {
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i) != null && inventory.get(i).getName().equalsIgnoreCase(name)) {
				return inventory.get(i);
			}
		}
		return null;

	}

	public static boolean deleteProduct(String nombre) {
		//Scanner scanner = new Scanner(System.in);
	    //System.out.print("¿Qué producto desea eliminar? ");
	    //String nombreProducto = scanner.nextLine();

	    Product productoBorrado = null;
	    for (Product product : inventory) {
	        if (product != null && product.getName().equalsIgnoreCase(nombre)) {
	            productoBorrado = product;
	            break;
	        }
	    }

	    if (productoBorrado != null) {
	        inventory.remove(productoBorrado);
	        //System.out.println("El producto ha sido eliminado correctamente.");
                return true;
	    } else {
	        //System.out.println("No se encontró el producto en el inventario.");
                return false;
	    }
	}

}






