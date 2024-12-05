package com.jsp.hibernate.Shopping_Cart.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.build.AllowSysOut;

import com.jsp.hibernate.Shopping_Cart.entity.Cart;
import com.jsp.hibernate.Shopping_Cart.entity.Product;
import com.jsp.hibernate.Shopping_Cart.entity.User;

public class ShoppingCartDao {
	static Scanner scan=new Scanner(System.in);
	public static Session getSession()
	{
	 Configuration cfg=new Configuration().configure().
			 addAnnotatedClass(Cart.class).addAnnotatedClass(User.class).
			 addAnnotatedClass(Product.class);
    SessionFactory sf=cfg.buildSessionFactory();
    Session session=sf.openSession();
   
	return session;	
	}
	public void addProduct()
	{
		System.out.println("Enter the Product Id:");
		int id=scan.nextInt();
		System.out.println("Enter the Product Name:");
		String name=scan.next();
		System.out.println("Enter the Product Brand:");
		String brand=scan.next();
		System.out.println("Enter the Product price:");
		int price=scan.nextInt();
		
		Product product1=new Product();
		product1.setProdouctName(name);
		product1.setProductId(id);
		product1.setProductBrand(brand);
		product1.setProductPrice(price);
		
		Session session=getSession();
		Transaction tran=session.beginTransaction();
		session.save(product1);
		tran.commit();
		session.save(product1);
		session.close();
		
		
	}
	public void addUserWithCart()
	{
		System.out.println("Enter the User Id:");
		int id=scan.nextInt();
		System.out.println("Enter the User Name:");
		String name=scan.next();
		System.out.println("Enter the UserEmail Brand:");
		String email=scan.next();
		System.out.println("Enter the Age:");
		int age=scan.nextInt();
		System.out.println("Enter the User City:");
		String city=scan.next();
		
		System.out.println("Enter the Cart Id:");
		int cId=scan.nextInt();
		
		Cart cart1=new Cart();
		cart1.setCartId(cId);
		
		
		
		User user1=new User();
		user1.setCart(cart1);
		user1.setUserAge(age);
		user1.setUserCity(city);
		user1.setUserEmail(email);
		user1.setUserId(id);
		user1.setUserName(name);
		
		
		
		
		
		Session session=getSession();
		Transaction tran=session.beginTransaction();
		session.save(user1);
		session.save(cart1);
		tran.commit();
		session.close();
		
	}
	public void addProductToCart() {
		Session session=getSession();
		Transaction tran=session.beginTransaction();
		//Searching the Product from the database through id
		System.out.println("Enter the Product Id:");
		Product existingProduct=session.get(Product.class,scan.nextInt());
		if(existingProduct!=null)
		{
			System.out.println("Enter the User Id:");
			User existingUser=session.get(User.class,scan.nextInt());
			if(existingUser!=null)
			{
				Cart cart=existingUser.getCart();
				List<Product> pList=new ArrayList<Product>();
				pList.add(existingProduct);
				cart.setProducts(pList);
//				List<Product> pList=cart.getProducts();
//				pList.add(existingProduct);
//				session.update(cart);
				session.save(cart);
				
			}
			else
			{
			System.out.println("User not Found!!!!!!!");
			}
		}else
		{
			System.out.println("Product not Found!!!!");
		}
		tran.commit();
		session.close();
		
	}
	public void removeProductFromCart() {
		
		Session session=getSession();
		Transaction tran=session.getTransaction();
		System.out.println("Enter the User Id:");
		User existingUser=session.get(User.class,scan.nextInt());
		if(existingUser!=null)
		{
			
			Cart cart=existingUser.getCart();
			List<Product> existingProductList=cart.getProducts();
			for(Product product:existingProductList) {
				System.out.println(product);
			}
			System.out.println("Enter the Product Id for removal:");
			
			
		
			Product existingProduct=session.get(Product.class,scan.nextInt());
			
			
					
			existingProductList.remove(existingProduct);
			cart.setProducts(existingProductList);
			session.save(cart);
			
		
			
				
			
		}
		else
		{
			System.out.println("User Doesn't Exist");
		}
		
		
		tran.commit();
		session.close();
		
	}
	public void findAllProductFromCart() {
	
		Session session=getSession();
		Transaction tran=session.getTransaction();
		System.out.println("Enter the User Id:");
		User existingUser=session.get(User.class,scan.nextInt());
		if(existingUser!=null)
		{
			
			Cart cart=existingUser.getCart();
			List<Product> existingProductList=cart.getProducts();
			for(Product product:existingProductList)
			{
				System.out.println(product);
			}}
			else 
			{
				System.out.println("User not found !!!!");
			}
	
}}