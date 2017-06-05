package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.Clinic;
import com.service.ClinicService;

@Controller
@RequestMapping(value = "/clinic")
public class ClinicController {
	
	@Autowired
	private ClinicService clinicService;

	@RequestMapping(value = "/list")
	public ModelAndView clinicList() {
		ModelAndView mav = new ModelAndView("/clinic/list");
		List<Clinic> clinicList = clinicService.getClinics();
		mav.addObject("clinicList", clinicList);
		return mav;
	}
}
