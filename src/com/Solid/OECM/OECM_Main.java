package com.Solid.OECM;


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

interface ShoppingCartStorage
{
	//ShoppingCart cart;
	
	public void save(ShoppingCart cart);
	
	
}

class SaveToMysql implements ShoppingCartStorage
{

	@Override
	public void save(ShoppingCart cart) {
		System.out.println("Saved in mysql");
		
	}
	
}
class SaveToMongoDB implements ShoppingCartStorage
{

	@Override
	public void save(ShoppingCart cart) {
		System.out.println("Saved in mongoDB");
		
	}
	
}
class SaveToFile implements ShoppingCartStorage
{

	@Override
	public void save(ShoppingCart cart) {
		System.out.println("Saved in file");
		
	}
	
}
	
	
public class OECM_Main {
	
	public static void main(String args[])
	{
		
		ShoppingCart st=new ShoppingCart();
		st.addProduct(new Product(111.1,"ghee"));
		st.addProduct(new Product(222.1,"Gehu"));
		st.addProduct(new Product(333.1,"Sauce"));
		st.addProduct(new Product(444.1,"Butter"));
		st.addProduct(new Product(555.1,"Bread"));
		
		
		ShoppingPrintInvoice sp=new ShoppingPrintInvoice(st);
		
	sp.printInvoice();
		
		ShoppingCartStorage sg=new SaveToMysql();
		sg.save(st);
		ShoppingCartStorage sg2=new SaveToMongoDB();
		sg2.save(st);
		
		ShoppingCartStorage sg3=new SaveToFile();
		sg3.save(st);
		
		
		
	}

}
