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

import com.tombaysales.domain.Bid;
import com.tombaysales.dto.BidDTO;
import com.tombaysales.dto.BidSearchDTO;
import com.tombaysales.dto.BidPageDTO;
import com.tombaysales.service.BidService;
import com.tombaysales.dto.common.RequestDTO;
import com.tombaysales.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/bid")
@RestController
public class BidController {

	private final static Logger logger = LoggerFactory.getLogger(BidController.class);

	@Autowired
	BidService bidService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<Bid> getAll() {

		List<Bid> bids = bidService.findAll();
		
		return bids;	
	}

	@GetMapping(value = "/{bidId}")
	@ResponseBody
	public BidDTO getBid(@PathVariable Integer bidId) {
		
		return (bidService.getBidDTOById(bidId));
	}

 	@RequestMapping(value = "/addBid", method = RequestMethod.POST)
	public ResponseEntity<?> addBid(@RequestBody BidDTO bidDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = bidService.addBid(bidDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/bids")
	public ResponseEntity<BidPageDTO> getBids(BidSearchDTO bidSearchDTO) {
 
		return bidService.getBids(bidSearchDTO);
	}	

	@RequestMapping(value = "/updateBid", method = RequestMethod.POST)
	public ResponseEntity<?> updateBid(@RequestBody BidDTO bidDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = bidService.updateBid(bidDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
