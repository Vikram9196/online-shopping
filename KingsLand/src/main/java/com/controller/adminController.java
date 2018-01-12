
package com.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.DaoImpl.*;
import com.model.Category;
import com.model.Product;
import com.model.Supplier;

@Controller
@RequestMapping("/admin")
public class adminController {

	@Autowired
	SupplierDaoImpl supplierDaoImpl;

	@Autowired
	CategoryDaoImpl categoryDaoImpl;

	@Autowired
	ProductDaoImpl productDaoImpl;
	
	@Autowired
	CartDaoImpl cartDaoImpl;
	
	@Autowired
	OrdersDaoImpl ordersDaoImpl;

	@RequestMapping("/adding")
	public String adding() {
		return "adding";
	}
	
	@RequestMapping("/admin/index")
	public String home() {
		return "index";
	}
	
	@RequestMapping(value="/saveSupp", method=RequestMethod.POST)
	@Transactional
	public ModelAndView saveSuppData(@RequestParam("sid")int sid,@RequestParam("supplierName")String supplierName){
		 ModelAndView mv=new  ModelAndView();
		 Supplier ss=new Supplier();
		 ss.setSid(sid);
		 ss.setSupplierName(supplierName);
		 supplierDaoImpl.insertSupplier(ss);
		 mv.setViewName("adding");
		 return mv;
	}
	
	@RequestMapping(value="/saveCat", method=RequestMethod.POST)
	@Transactional
	public ModelAndView saveCatData(@RequestParam("cid")int cid,@RequestParam("categoryName")String categoryName){
		 ModelAndView mv=new  ModelAndView();
		 Category c=new Category();
		 c.setCid(cid);
		 c.setCategoryName(categoryName);
		 categoryDaoImpl.insertCategory(c);
		 mv.setViewName("adding");
		 return mv;
	
		 
		 
	}
	
	@RequestMapping(value="/saveProduct", method=RequestMethod.POST)
	@Transactional
	public String saveProd(HttpServletRequest request, @RequestParam("file")MultipartFile file)
	{
		Product prod = new Product();
		prod.setProductName(request.getParameter("pName"));
		prod.setPrice(Double.parseDouble(request.getParameter("pPrice")));
		prod.setDescription(request.getParameter("pDescription"));
		prod.setStock(Integer.parseInt(request.getParameter("pStock")));
	//	String cat=request.getParameter("pCategory");
	//	String sat=request.getParameter("pSupplier");
		prod.setCategory(categoryDaoImpl.findByCatId(Integer.parseInt(request.getParameter("pCategory"))));
		prod.setSupplier(supplierDaoImpl.findBySuppId(Integer.parseInt(request.getParameter("pSupplier"))));
		
		String filepath=request.getSession().getServletContext().getRealPath("/");
		String filename=file.getOriginalFilename();
		productDaoImpl.insertProduct(prod);
		System.out.println("file path"+filepath);
		try{
			byte imagebyte[]=file.getBytes();
			BufferedOutputStream fos=new BufferedOutputStream(new FileOutputStream(filepath+"/resources/"+filename));
			fos.write(imagebyte);
			fos.close();
		}
		catch(IOException e){
			e.printStackTrace();
			
		}
		return "adding";
	}
	
	@ModelAttribute
	public void loadingDataInPage(Model m){
		m.addAttribute("satList", supplierDaoImpl.retrive());
		m.addAttribute("catList", categoryDaoImpl.retrive());
		m.addAttribute("prodList", productDaoImpl.retrive());
		
	}
	
	@RequestMapping("/productList")
	public ModelAndView prodlist()
	{
		ModelAndView mv= new ModelAndView();
		mv.addObject("prodList", productDaoImpl.retrive());
		mv.setViewName("productAdminList");
		return mv;
	}
	
	@RequestMapping("/supplierList")
	public ModelAndView supplist()
	{
		ModelAndView mv= new ModelAndView();
		mv.addObject("satList", supplierDaoImpl.retrive());
		mv.setViewName("suppAdminList");
		return mv;
	}
	
	@RequestMapping("/categoryList")
	public ModelAndView catlist()
	{
		ModelAndView mv= new ModelAndView();
		mv.addObject("catList", categoryDaoImpl.retrive());
		mv.setViewName("categoryAdminList");
		return mv;
	}
	

	@RequestMapping("/deleteProd/{pid}")
	public String deleteProduct(@PathVariable("pid")int pid)
	{
		productDaoImpl.deleteProd(pid);
		return "redirect:/admin/productList?del";
	}
	
	@RequestMapping("/updateProd")
	public ModelAndView updateProduct(@RequestParam("pid")int pid)
	{
		ModelAndView mv= new ModelAndView();
		Product p=productDaoImpl.findByPID(pid);
		mv.addObject("prod",p);
		mv.addObject("catList", categoryDaoImpl.retrive());
		mv.addObject("satList", supplierDaoImpl.retrive());
		mv.setViewName("updateProduct");
		return mv;
	}
	
	@RequestMapping(value="/productUpdate", method=RequestMethod.POST)
	//@Transactional
	public String updateProd(HttpServletRequest request, @RequestParam("file")MultipartFile file)
	{
		String pid = request.getParameter("pId");
		Product prod = new Product();
		prod.setPid(Integer.parseInt(pid));
		prod.setProductName(request.getParameter("pName"));
		prod.setPrice(Double.parseDouble(request.getParameter("pPrice")));
		prod.setDescription(request.getParameter("pDescription"));
		prod.setStock(Integer.parseInt(request.getParameter("pStock")));
		//String cat=request.getParameter("pCategory");
		//String sat=request.getParameter("pSupplier");
		prod.setCategory(categoryDaoImpl.findByCatId(Integer.parseInt(request.getParameter("pCategory"))));
		prod.setSupplier(supplierDaoImpl.findBySuppId(Integer.parseInt(request.getParameter("pSupplier"))));
		
		String filepath=request.getSession().getServletContext().getRealPath("/");
		String filename=file.getOriginalFilename();
		
		prod.setImgName(filename);
		productDaoImpl.updateProd(prod);
		System.out.println("file path"+filepath);
		try{
			byte imagebyte[]=file.getBytes();
			BufferedOutputStream fos=new BufferedOutputStream(new FileOutputStream(filepath+"/resources/"+filename));
			fos.write(imagebyte);
			fos.close();
		}
		catch(IOException e){
			e.printStackTrace();
			
		}
		return "redirect:/admin/productList?update";
	}
	
	@RequestMapping("/deleteCat/{cid}")
	public String deleteCategory(@PathVariable("cid")int cid)
	{
		categoryDaoImpl.deleteCategory(cid);
		return "redirect:/admin/categoryList?del";
	}
	
	@RequestMapping("/updateCat")
	public ModelAndView updateCategory(@RequestParam("cid")int cid)
	{
		ModelAndView mv= new ModelAndView();
		Category c=categoryDaoImpl.findByCatId(cid);
		mv.addObject("cat",c);
		/*mv.addObject("catList", categoryDaoImpl.retrive());
		mv.addObject("satList", supplierDaoImpl.retrive());*/
		mv.setViewName("updateCategory");
		return mv;
	}
	@RequestMapping(value="/categoryUpdate", method=RequestMethod.POST)
	public String updateCat(HttpServletRequest request)
	{
		String cid = request.getParameter("cId");
		Category cat = new Category();
		cat.setCid(Integer.parseInt(cid));
		cat.setCategoryName(request.getParameter("cName"));
		categoryDaoImpl.updateCategory(cat);
		
		return "redirect:/admin/categoryList?update";
}
	
	@RequestMapping("/deleteSupp/{sid}")
	public String deleteSupplier(@PathVariable("sid")int sid)
	{
		supplierDaoImpl.deleteSupplier(sid);
		return "redirect:/admin/supplierList?del";
	}
	
	@RequestMapping("/updateSupp")
	public ModelAndView updateSupplier(@RequestParam("sid")int sid)
	{
		ModelAndView mv= new ModelAndView();
		Supplier s=supplierDaoImpl.findBySuppId(sid);
		mv.addObject("supp",s);
		/*mv.addObject("catList", categoryDaoImpl.retrive());
		mv.addObject("satList", supplierDaoImpl.retrive());*/
		mv.setViewName("updateSupplier");
		return mv;
	}
	@RequestMapping(value="/supplierUpdate", method=RequestMethod.POST)
	public String updateSupp(HttpServletRequest request)
	{
		String sid = request.getParameter("sId");
		Supplier supp = new Supplier();
		supp.setSid(Integer.parseInt(sid));
		supp.setSupplierName(request.getParameter("sName"));
		supplierDaoImpl.updateSupplier(supp);
		
		return "redirect:/admin/supplierList?update";
}

}