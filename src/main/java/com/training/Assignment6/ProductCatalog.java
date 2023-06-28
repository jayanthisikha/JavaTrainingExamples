
package com.training.Assignment6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ProductCatalog implements Serializable
{
//	String fileName = "/Java_Project/src/main/java/com/training/Assignment6/phone.txt";
	private Map < String, Product > products;
	public ProductCatalog() 
	{
		products = new HashMap<>();
	}
	public void addProduct(Product product) 
	{
		products.put(product.getName(), product);
	}
	public void removeProduct(Product product)
	{
		products.remove(product.getName());
	}
	public Product getProduct(String name) 
	{
		return products.get(name);
	}
	public Collection <Product> getAllProducts() 
	{
		return products.values();
	}
	public void loadProducts(String fileName) 
	{
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) 
		{
			products = (Map<String, Product>) ois.readObject();
		} 
		
		catch (IOException | ClassNotFoundException e) 
		{
			System.out.println("Error loading products: " + e.getMessage());
		}
	}
	public void saveProducts(String fileName) 
	{
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName)))
		{
			oos.writeObject(products);
		} 
		catch (IOException e) 
		{
			System.out.println("Error saving products: " + e.getMessage());
		}
	}
}
