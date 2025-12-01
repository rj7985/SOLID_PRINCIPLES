
package com.Solid.SRP;

import java.util.ArrayList;
import java.util.List;

class Product
{
	Double price;
	String name;
	
	Product(Double price,String name)
	{
		this.price=price;
		this.name=name;
	}
}

class ShoppingCart
{
	List<Product>products=new ArrayList<>();
	void addProduct(Product p)
	{
		products.add(p);
	}
	
	List<Product>getProduct()
	{
		return products;
	}
	public double calculatePrice()
	
	{
		double total=0.0;
		for(Product po:products)
		{
			total+=po.price;
			
		}
		return total;
		
}
}

class ShoppingPrintInvoice
{
	
	ShoppingCart cart;
	
	public ShoppingPrintInvoice(ShoppingCart cart)
	{
		
		this.cart=cart;
	}
	
	public void printInvoice()
	{
		System.out.println("Shopping card invoice");
		for(Product p:cart.getProduct())
		{
			System.out.println(p.name+"-Rs"+p.price);
		}
		
		
		System.out.println("Total:Rs-"+cart.calculatePrice());
		
	}
	
	
	
}

class ShoppingCartStorage
{
	ShoppingCart cart;
	
	public ShoppingCartStorage(ShoppingCart cart)
	{
		this.cart=cart;
		
	}
	
	public void saveToDb()
	{
		System.out.println("saved in DB");
	}
	
}
	
	

public class Main {
	
	public static void main(String args[])
	{
		
		ShoppingCart cart=new ShoppingCart();
		cart.addProduct(new Product(4000.0,"Laptop"));
		cart.addProduct(new Product(5000.0,"DEll"));
		cart.addProduct(new Product(6000.0,"MAc"));
		cart.addProduct(new Product(7000.0,"Lenevo"));
		
		
		ShoppingPrintInvoice inv=new ShoppingPrintInvoice(cart);
		inv.printInvoice();
		
		
		ShoppingCartStorage st=new ShoppingCartStorage(cart);
		st.saveToDb();
	}

}
