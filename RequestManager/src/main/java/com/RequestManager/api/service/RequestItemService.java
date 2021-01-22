package com.RequestManager.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RequestManager.api.model.RequestItem;
import com.RequestManager.api.repository.RequestItemRepository;

@Service
public class RequestItemService {
	
	//To access the necessary methods
	@Autowired
	private RequestItemRepository requestItemRepository;
	
	public List<RequestItem> getAllItems() {
		List<RequestItem> itemsList = new ArrayList<>();
		requestItemRepository.findAll().forEach(itemsList::add);
		return itemsList;
	}
	
	public Optional<RequestItem> getItem(Integer id) {
		return requestItemRepository.findById(id);
	}
	
	public void addItem(RequestItem requestItem) {
		requestItemRepository.save(requestItem);
	}
	
	public void updateItem(Integer id, RequestItem requestItem) {
		requestItemRepository.save(requestItem);		
	}
	
	public void deleteItem(Integer id) {
		requestItemRepository.deleteById(id);
	}

}
