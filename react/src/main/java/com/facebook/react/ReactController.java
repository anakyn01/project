package com.facebook.react;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.facebook.react.service.ReactService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ReactController {
	
	@Autowired
	ReactService reactService;
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@GetMapping(value = "/")
	public String home() {
		
		return "home";
	}
	
	@GetMapping(value ="sub/create")
	public String getCreate() {
		return "sub/create";
	}
	@PostMapping(value ="sub/create")
	public String postCreate(@RequestParam Map<String, Object> map) {
		int reactContSeq = this.reactService.create(map);
		return "redirect:/read/" + String.valueOf(reactContSeq);
	}
	
	@GetMapping(value ="sub/list")
	public String list() {
		return "sub/list";
	}
	
	
	
	
	
	
	
	
}
