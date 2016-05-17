package com.foodcoop.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.foodcoop.domain.Producer;

import com.foodcoop.services.ProducerService;

@Controller
public class ProducerController implements ResourceLoaderAware{
	@Autowired
	ProducerService producerService;
	
	private ResourceLoader resourceLoader;
	
	  @RequestMapping(value = "/producers")
		public ModelAndView viewProducerList(Map<String, Object> model) {
			Map<String, List> map = new HashMap<String, List>();
			List<Producer> producerList = producerService.getProducerList();

			map.put("producerList", producerList);
			return new ModelAndView("producers", "map", map);
		}
	  
	  
	   @RequestMapping("/newProducer")
	   public ModelAndView newProducer(@ModelAttribute Producer producer) {
       
	    return new ModelAndView("newProducer");
	   }
	   
	@RequestMapping("/insertProducer")
	public String inserData(@ModelAttribute Producer producer) {
		if (producer != null) {
			
			MultipartFile file = producer.getFile();
			String path = SavePhoto(file, "prdcr" + producer.getProducerName());
			try {
				producer.setImage(path);

				producerService.insertData(producer);
			} catch (Exception ex) {

			}
		}

		return "redirect:/producers";
	}
	
		@RequestMapping(value="/viewProducer" )
		public ModelAndView viewProducer(@RequestParam String id,
				@ModelAttribute Producer producer) {

			producer = producerService.getProducer(id);

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("producer", producer);

			return new ModelAndView("viewProducer", "map", map);

		}
		
		

		private String SavePhoto(MultipartFile file, String fileName) {
			if (!file.isEmpty()) {
				try {
					byte[] bytes = file.getBytes();

					// String rootPath = System.getProperty("user.dir");
					Resource resource = resourceLoader.getResource("/resources/uploads/");
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
		
}
