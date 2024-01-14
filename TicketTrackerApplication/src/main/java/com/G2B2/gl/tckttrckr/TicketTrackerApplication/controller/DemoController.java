package com.G2B2.gl.tckttrckr.TicketTrackerApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class DemoController {
	@GetMapping("/hi")
//	@ResponseBody
	public String hi(Model model) {
		model.addAttribute("msg", "Hi controller");
		return "home/hi";
	}

	@GetMapping("/hello")
//	@ResponseBody
	public String hello(Model model) {
		model.addAttribute("msg", "Hello controller");
		return "hello";
	}
}
