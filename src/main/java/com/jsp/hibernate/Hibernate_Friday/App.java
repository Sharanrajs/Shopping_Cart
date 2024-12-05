package com.jsp.hibernate.Hibernate_Friday;

import java.util.Scanner;

import com.jsp.hibernate.Shopping_Cart.dao.ShoppingCartDao;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      Scanner scan=new Scanner(System.in);
      
      int choice=0;
      
      while(choice!=6) {
    	  
     
      System.out.println("Enter the your Choice:\n1-AddProduct\n2-UserWithCart"
      		+ "\n3-ProductToCart\n4-RemoveProductFromCart\n5-FindAllProductFromCart\n6-exit");
       choice=scan.nextInt();
      ShoppingCartDao dao=new ShoppingCartDao();
      switch(choice)
      {
      case 1:
    	  dao.addProduct();
    	  break;
      case 2:
    	  dao.addUserWithCart();
    	  break;
   
      case 3:
    	  dao.addProductToCart();
    	  break;
      case 4:
    	  dao.removeProductFromCart();
    	  break;
      case 5:
    	  dao.findAllProductFromCart();
    	  break;
    	  default:
    		  System.out.println("Default Choice");
    	  
      }
    }}
}
