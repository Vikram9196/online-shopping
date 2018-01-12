package com.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

//import org.omg.CORBA.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.DaoImpl.*;
import com.model.*;

@Controller
public class CartController {

	@Autowired
	SupplierDaoImpl supplierDaoImpl;
	
	@Autowired
	UserDaoImpl userDaoImpl;
	
	@Autowired
	CategoryDaoImpl categoryDaoImpl;
	
	@Autowired
	ProductDaoImpl productDaoImpl;
	
	@Autowired
	CartDaoImpl cartDaoImpl;
	
	@Autowired
	OrdersDaoImpl ordersDaoImpl;
	
	@RequestMapping(value="/prodDetails/{pid}", method=RequestMethod.GET)
	public ModelAndView prodDet(@PathVariable("pid")int pid)
	{
		ModelAndView mv= new ModelAndView();
		Product p= productDaoImpl.findByPID(pid);
		mv.addObject("product", p);
		mv.setViewName("prodDetails");
		return mv;
	}
	
	@RequestMapping(value="/addToCart", method=RequestMethod.POST)
	@Transactional
	public ModelAndView addtoCart(HttpServletRequest request){
		 ModelAndView mv=new  ModelAndView();
		 Principal principal= request.getUserPrincipal();
		 String userEmail =principal.getName();
		 
		 try
		 {
			 int pid= Integer.parseInt(request.getParameter("pid"));
			 String productName=request.getParameter("pName");
			 int qty=Integer.parseInt(request.getParameter("pQty"));
			 double price=Double.parseDouble(request.getParameter("pPrice"));
			 String imgName=request.getParameter("imgName");
			 
			 Cart cartExist= cartDaoImpl.getCartById(pid, userEmail);
			 if(cartExist== null)
			 {
				Cart c=new Cart();
				
				c.setCartProductId(pid);
				c.setCartProductName(productName);
				c.setCartQuantity(qty);
				c.setCartPrice(price);
				c.setCartImage(imgName);
				
				User u=userDaoImpl.findUserByEmail(userEmail);
				c.setCartUserDetails(u);
				cartDaoImpl.insertCart(c);
			 }
			 else if (cartExist!=null)
			 {
				 Cart c=new Cart();
				 c.setCartId(cartExist.getCartId());
				 c.setCartProductName(productName);
				 c.setCartProductId(pid);
				 c.setCartQuantity(cartExist.getCartQuantity()+qty);
				 c.setCartPrice(price);
				 c.setCartImage(imgName);
				
					
				 User u=userDaoImpl.findUserByEmail(userEmail);
				 c.setCartUserDetails(u);
					cartDaoImpl.updateCart(c);
			 }
			 
			 mv.addObject("cartInfo",cartDaoImpl.findByCartId(userEmail));
			 mv.setViewName("cart");
			 return mv;
		 }
		 catch(Exception e){
			 e.printStackTrace();
			 mv.addObject("cartInfo",cartDaoImpl.findByCartId(userEmail));
			 mv.setViewName("cart");
			 return mv;
			 
		 }
	}
	
	@RequestMapping(value="/checkout", method=RequestMethod.GET)
	public ModelAndView checkoutprocess(HttpServletRequest req){
		 ModelAndView mv=new  ModelAndView();
		 Principal principal= req.getUserPrincipal();
		 String userEmail =principal.getName();
		 
		 User c=userDaoImpl.findUserByEmail(userEmail);
		 List<Cart> cart= cartDaoImpl.findByCartId(userEmail);
		 mv.addObject("user",c);
		 mv.addObject("cart",cart);
		 return mv;
	}
	
	
	@RequestMapping(value="/orderprocess", method=RequestMethod.POST)
	public ModelAndView orderprocess(HttpServletRequest req){
		 ModelAndView mv=new  ModelAndView();
		 Orders order=new Orders();
		 Principal principal= req.getUserPrincipal();
		 String userEmail =principal.getName();
		 
		 Double total= Double.parseDouble(req.getParameter("total"));
		 String payment=req.getParameter("payment");
		 
		 User users= userDaoImpl.findUserByEmail(userEmail);
		 order.setUser(users);
		 order.setTotal(total);
		 order.setPayment(payment);
		 ordersDaoImpl.insertOrder(order);
		 mv.addObject("orderDetails",users);
		 mv.setViewName("ack");
		 return mv;
		 

}
	
	@RequestMapping(value="/deletePCart/{cartId}")
	public ModelAndView deleteCartItem(@PathVariable("cartId")int cartId,HttpServletRequest req)
	{
		ModelAndView mv=new ModelAndView();
		Principal principal=req.getUserPrincipal();
		String userEmail=principal.getName();
		cartDaoImpl.deleteCart(cartId);
		mv.addObject("cartInfo",cartDaoImpl.findByCartId(userEmail));
		mv.setViewName("cart");
		
		return mv;
	}
	
	@RequestMapping(value="/goToCart",method=RequestMethod.GET)
	public ModelAndView gotocart(HttpServletRequest req)
	{
		ModelAndView mv=new ModelAndView();
		Principal principal=req.getUserPrincipal();
		String userEmail=principal.getName();
		mv.addObject("cartInfo",cartDaoImpl.findByCartId(userEmail));
		mv.setViewName("cart");
		return mv;
	}
}
