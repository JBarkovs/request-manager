package com.RequestManager.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.RequestManager.api.model.RequestItem;

public interface RequestItemRepository extends CrudRepository<RequestItem, Integer> {

}
