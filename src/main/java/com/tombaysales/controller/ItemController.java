package com.tombaysales.controller;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.ArrayList;


import com.tombaysales.util.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.Date;

import com.tombaysales.domain.Item;
import com.tombaysales.dto.ItemDTO;
import com.tombaysales.dto.ItemSearchDTO;
import com.tombaysales.dto.ItemPageDTO;
import com.tombaysales.service.ItemService;
import com.tombaysales.dto.common.RequestDTO;
import com.tombaysales.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/item")
@RestController
public class ItemController {

	private final static Logger logger = LoggerFactory.getLogger(ItemController.class);

	@Autowired
	ItemService itemService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<Item> getAll() {

		List<Item> items = itemService.findAll();
		
		return items;	
	}

	@GetMapping(value = "/{itemId}")
	@ResponseBody
	public ItemDTO getItem(@PathVariable Integer itemId) {
		
		return (itemService.getItemDTOById(itemId));
	}

 	@RequestMapping(value = "/addItem", method = RequestMethod.POST)
	public ResponseEntity<?> addItem(@RequestBody ItemDTO itemDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = itemService.addItem(itemDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/items")
	public ResponseEntity<ItemPageDTO> getItems(ItemSearchDTO itemSearchDTO) {
 
		return itemService.getItems(itemSearchDTO);
	}	

	@RequestMapping(value = "/updateItem", method = RequestMethod.POST)
	public ResponseEntity<?> updateItem(@RequestBody ItemDTO itemDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = itemService.updateItem(itemDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
