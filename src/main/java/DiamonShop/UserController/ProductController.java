package DiamonShop.UserController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Service.IProductService;

@Controller
public class ProductController extends BaseController {

	@Autowired
	IProductService _productService;
	
	@RequestMapping(value = { "chi-tiet-san-pham/{id}" })
	public ModelAndView Index(@PathVariable long id) {		
		_mvShare.setViewName("user/product");
		_mvShare.addObject("product", _productService.GetProductByID(id));
		int idCategory = _productService.GetProductByID(id).getId_category();
		_mvShare.addObject("categorys", _homeService.GetDataCategorys());
		_mvShare.addObject("productByCategoryID", _productService.GetProductByCategoryID(idCategory));
		return _mvShare;
	}

}
