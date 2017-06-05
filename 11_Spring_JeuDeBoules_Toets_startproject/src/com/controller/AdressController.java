package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.editor.MemberEditor;
import com.model.Adress;
import com.model.Member;
import com.model.Team;
import com.service.AdressService;
import com.service.MemberService;

@Controller
@RequestMapping(value = "/adress")
public class AdressController {
	
	@Autowired
	private AdressService as;
	
	@Autowired
	private MemberService ms;
	
	@Autowired
	private MemberEditor memberEditor;

	public AdressController() {

	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Member.class, this.memberEditor);
	}

	@RequestMapping(value = "/listadresses")
	public ModelAndView showAdresses() {
		ModelAndView mav=new ModelAndView("/adress/listadresses");
		List<Adress> adresses=as.listAdresses();
		mav.addObject("adresses",adresses);
		return mav;
		
	}
	
	@RequestMapping(value = "/newadress")
	public ModelAndView newAdresse() {
		ModelAndView mav=new ModelAndView("/adress/newadress");
		Adress adress=new Adress();
		List<Member> members=ms.getMembers();
		mav.addObject("members",members);
		mav.addObject("adress",adress);
		return mav;
		
	}
	
	@RequestMapping(value = "/create")
	public ModelAndView create(@ModelAttribute Adress adress) {
		ModelAndView mav=new ModelAndView("/adress/listadresses");
		System.out.println("in method create adress: "+adress);
		as.createAdress(adress);
		List<Adress> adresses=as.listAdresses();
		mav.addObject("adresses",adresses);
		return mav;
		
	}
	
	@RequestMapping(value = "/{id}")
	public ModelAndView show(@PathVariable long id) {
		ModelAndView mav=new ModelAndView("/adress/show");
		Adress adress=as.getAdressbyId(id);
		mav.addObject("adress",adress);
		return mav;
		
	}

}
