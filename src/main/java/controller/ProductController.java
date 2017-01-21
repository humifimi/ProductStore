package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import domain.Product;
import service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;

	@RequestMapping(value = "/Products/add", method = RequestMethod.GET)
	public String getAddNewProductForm(Model model) {

		Product newProduct = new Product();
		model.addAttribute("newProduct", newProduct);
		return "addProduct";
	}

	@RequestMapping(value = "/Products/add", method = RequestMethod.POST)
	public String processAddNewProductForm(
			@ModelAttribute("newProduct")Product newProduct) {
	
		productService.addProduct(newProduct);
		return "viewProduct";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "redirect:/Products/add";
	}
	
	/*@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String showProductListForm(Model model){
		
		return "viewProduct";
	}*/
	

}
