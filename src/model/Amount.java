package model;

public class Amount {
	private double value;
	private final String currency = "€";
	
	public Amount(double value) {
		super();
		this.value = value;
	}
	
	public double getValue() {
		return value;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
	
	@Override
	public String toString(){
		return String.valueOf(value) + currency;
	}
}