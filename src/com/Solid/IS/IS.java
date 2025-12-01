package com.Solid.IS;


interface  TwoD
{
double area();
}

interface  ThreeD 
{
	double area();
	double  volume();
}

class Square implements TwoD
{

	private double side;
	public Square(double side)
	{
		this.side=side;
	}
	@Override
	public double area() {
		
		return side*side;
		
	}
	
}


class Rectangle implements TwoD
{

	private double length,height;
	
	public Rectangle(double length,double height)
	{
		this.length=length;
		this.height=height;
	}
	@Override
	public double area() {
		return length*height;
	}
	
}


class Cube implements ThreeD
{

	double side;
	
	public Cube(double side)
	{
		this.side=side;
	}
	@Override
	public double area() {
		return 6*side*side;
	}

	@Override
	public double volume() {
		return side*side*side;
	}
	
}
public class IS {

	public static void main(String args[])
	{
		
		TwoD td=new Square(4.0);
		TwoD td1=new Rectangle(4.0,4.0);
		
		ThreeD td2=new Cube(3.0);
		
		
		  System.out.println("Square Area: "    + td.area());
	        System.out.println("Rectangle Area: " + td1.area());
	        System.out.println("Cube Area: "      + td2.area());
	        System.out.println("Cube Volume: "    + td2.volume());
		
	}

}
