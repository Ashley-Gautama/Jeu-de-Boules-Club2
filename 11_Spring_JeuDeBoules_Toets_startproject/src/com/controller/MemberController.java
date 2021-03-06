package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.editor.TeamEditor;
import com.model.Member;
import com.model.Team;
import com.service.MemberService;
import com.service.TeamService;

@Controller
@RequestMapping(value = "/member")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private TeamEditor teamEditor;

	private static String titelNieuw = "Nieuw lid";
	private static String titelWijzig = "Wijzig lid";

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Team.class, this.teamEditor);
	}

	@RequestMapping(value = "/memberlist")
	public ModelAndView ledenlijst() {
		ModelAndView memberListView = new ModelAndView("/member/list");
		List<Member> members = memberService.getMembers();
//		List<Team> teams = teamService.getTeams();
//		memberListView.addObject("teams", teams);
		memberListView.addObject("members", members);
		memberListView.addObject("message", "Hello world!");
		return memberListView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView memberAddPage() {
		ModelAndView memberAddView = new ModelAndView("/member/add");
		memberAddView.addObject("paginaTitel", titelNieuw);
		memberAddView.addObject("member", new Member());
		memberAddView.addObject("teamList", teamService.getTeams());
		return memberAddView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView memberAdd(@ModelAttribute Member member) {
		ModelAndView memberListView = new ModelAndView("/member/list");
		memberService.addMember(member);
		List<Member> members = memberService.getMembers();
		memberListView.addObject("members", members);
		String message = "Member was successfully added.";
		memberListView.addObject("message", message);
		return memberListView;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editPage(@PathVariable Integer id) {
		ModelAndView memberEditView = new ModelAndView("/member/edit");
		Member member = memberService.getMember(id);
		memberEditView.addObject("paginaTitel", titelWijzig);
		memberEditView.addObject("member", member);
		memberEditView.addObject("teamList", teamService.getTeams());
		return memberEditView;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView edit(@ModelAttribute("member") Member member) {
		ModelAndView memberlistView = new ModelAndView("/member/list");
		memberService.updateMember(member);
		List<Member> members = memberService.getMembers();
		memberlistView.addObject("members", members);
		String message = "User was successfully edited.";
		memberlistView.addObject("message", message);
		return memberlistView;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteMember(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("/member/list");
		memberService.deleteMember(id);
		List<Member> members = memberService.getMembers();
		modelAndView.addObject("members", members);
		String message = "Member was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}

	@RequestMapping(value = "/deleteFromTeam/{id}", method = RequestMethod.GET)
	public ModelAndView deleteTeam(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("/member/list");
		Member member = memberService.getMember(id);
		String memberName = member.getFirstName() + " " + member.getLastName();
		String teamName = member.getTeam().getName();
		memberService.deleteFromTeam(id);
		List<Member> members = memberService.getMembers();
		modelAndView.addObject("members", members);
		String message = "Member " + memberName + " was successfully removed from team " + teamName + ".";
		modelAndView.addObject("message", message);
		return modelAndView;
	}
}
