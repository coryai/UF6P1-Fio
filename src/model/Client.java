package model;

import main.Payable;

public class Client extends Person implements Payable {
	int MEMBER_ID = 456;
	Amount Balance = new Amount(50);
	public Client(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean pay(Amount amount) {
        double newBalance = Balance.getValue() - amount.getValue();
        if (newBalance >= 0) {
            Balance.setValue(newBalance);
            System.out.println("Venta realizada con éxito. Saldo actual: " + Balance.getValue());
            return true;
        } else {
            System.out.println("Venta realizada con éxito. El cliente debe: " + Balance.getValue());
            return false;
        }
	}
	public String toUpperCase() {
		// TODO Auto-generated method stub
		return null;
	}



}