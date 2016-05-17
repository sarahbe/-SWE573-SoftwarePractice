package com.foodcoop.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.foodcoop.domain.Category;
import com.foodcoop.domain.Product;
import com.foodcoop.domain.User;
import com.foodcoop.services.CategoryService;
import com.foodcoop.services.ProducerService;
import com.foodcoop.services.ProductService;
import com.foodcoop.services.UnitService;

@Controller
public class ProductCotroller implements ResourceLoaderAware {
	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	ProducerService producerService;

	@Autowired
	UnitService unitService;
	
	private ResourceLoader resourceLoader;

	@RequestMapping(
			value = "/products")
	public ModelAndView viewProductList(Map<String, Object> model) {
		Map<String, List> map = new HashMap<String, List>();
		List<Product> productList = productService.getProductList();

		for (Product item : productList) {
			item.getProducerName();
		}

		map.put("productList", productList);
		return new ModelAndView("products", "map", map);
	}

	@RequestMapping("/newProduct")
	public ModelAndView registerUser(@ModelAttribute Product product) {

		Map<String, List> map = new HashMap<String, List>();
		map.put("categories", categoryService.getCategoryList());
		map.put("producers", producerService.getProducerList());
		map.put("units", unitService.getUnitList());
		return new ModelAndView("newProduct", "map", map);
	}

	@RequestMapping(
			value = "/insertProduct",
			method = RequestMethod.POST)
	public String inserData(@ModelAttribute Product product) {
		if (product != null) {

			MultipartFile file = product.getFile();
			String path = SavePhoto(file,"prdct"+ product.getProductName());
			try {

				product.setImage(path);

				productService.insertData(product);
			} catch (Exception ex) {

			}

		}

		return "redirect:/products";

	}

	private String SavePhoto(MultipartFile file, String fileName) {
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// String rootPath = System.getProperty("user.dir");
				Resource resource = resourceLoader
						.getResource("/resources/uploads/");
				// file.transferTo(resource.getFile());

				String rootPath = resource.getURL().getPath();
				String urlPath = "resources/uploads/" + fileName + ".jpg";
				File serverFile = new File(
						rootPath + File.separator + fileName + ".jpg");
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				return urlPath;

			} catch (Exception e) {
				return "";
			}

		}
		return "";
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	public Resource getResource(String location) {
		return resourceLoader.getResource(location);
	}

	@RequestMapping("/viewProduct")
	public ModelAndView viewProduct(@RequestParam String id,
			@ModelAttribute Product product) {

		product = productService.getProduct(id);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("product", product);

		return new ModelAndView("viewProduct", "map", map);

	}
}
