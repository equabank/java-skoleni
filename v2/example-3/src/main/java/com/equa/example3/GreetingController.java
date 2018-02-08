package com.equa.example3;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GreetingController {

	@GetMapping("/greeting")
	public String greetingForm(Model model) {
		Greeting g = new Greeting();
		g.setContent("Pes");
		model.addAttribute("greeting", g);
		return "greeting";
	}

	@PostMapping("/greeting")
	public String greetingSubmit(Model model, @ModelAttribute Greeting g) {
		List<String> pok = new ArrayList<>();
		pok.add("Karel");
		pok.add("Honza");
		pok.add("Zdenek");
		pok.add("Roman");
		model.addAttribute("seznam", pok);
		model.addAttribute("greeting", g);
		return "result";
	}

}