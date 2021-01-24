package com.RequestManager.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.RequestManager.api.model.RequestItem;
import com.RequestManager.api.service.RequestItemService;

@Controller
public class RequestItemController {
	
	//To access the necessary methods to change data in the DB
	@Autowired
	private RequestItemService requestItemService;
	
	//Passes index.html and the necessary data when starting the application
	@RequestMapping(value= "/")
	public String index(Model model) {
		List<RequestItem> requestItems = requestItemService.getAllItems();
		model.addAttribute("items", requestItems);
		return "index";
	}
	
	//Passes newitem.html to display a view for a new item to be placed in the DB 
	@RequestMapping(value= "/new")
	public static String showNewForm(Model model) {
		RequestItem requestItem = new RequestItem();
		model.addAttribute("item", requestItem);
		return "newitem";
	}
	
	//Takes field values to be placed in a new DB entry
	@RequestMapping(value= "/save", method= RequestMethod.POST)
	public String save(@ModelAttribute("item") RequestItem requestItem) {
		requestItem.setStatus("Unapproved");
		requestItemService.addItem(requestItem);
		return "redirect:/";
	}
	
	//Passes setstatus.html and a requestItem (by id) to display a view for editing the status field of a DB entry
	 @RequestMapping("/setstatus/{id}")
	 public ModelAndView showEditForm(@PathVariable(name= "id") Integer id) {
		 ModelAndView mav = new ModelAndView("setstatus");
		 Optional<RequestItem> requestItem = requestItemService.getItem(id);
		 mav.addObject("requestItem", requestItem);		 
		 return mav;
	 }
	
	//Takes field values and a new field value for requestItem.status to be changed in DB
	 @RequestMapping("/updatestatus")
	 public String updateStatus(@ModelAttribute("requestItem") RequestItem requestItem) {
		// For displaying proper word form (approve + d = approved)
		if(requestItem.getStatus().length() == 7) {
			requestItem.setStatus("" + requestItem.getStatus() + "d");			
		}
		requestItemService.updateItem(requestItem.getId(), requestItem);
		 return "redirect:/";
	 }
	

	 //Deletes DB entry by id
	 @RequestMapping("/delete/{id}")
	 public String deleteRequestItem(@PathVariable(name= "id") Integer id) {
		 requestItemService.deleteItem(id);
		 return "redirect:/";
	 }

}
