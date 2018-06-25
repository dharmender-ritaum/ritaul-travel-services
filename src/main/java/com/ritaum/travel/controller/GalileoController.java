package com.ritaum.travel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ritaum.travel.services.GalileoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/galileo")
@Api(value = "Galileo services")
public class GalileoController {

	public static final Logger logger = LoggerFactory.getLogger(GalileoController.class);

	@Autowired
	private GalileoService galileoService;

	@ApiOperation(value = "Get Availability", notes = "API to get available flights")
	@RequestMapping(value = "/getAvail/", method = RequestMethod.GET)
	public void getAvail() {
		logger.info("getting air avalilability from galileo");
		
		galileoService.getAvailability();
		
		logger.info("After getting air avalilability from galileo");
		
	}

}