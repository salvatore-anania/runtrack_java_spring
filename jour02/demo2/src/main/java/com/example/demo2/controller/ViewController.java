package com.example.demo2.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.constraints.Min;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;


@Controller
public class ViewController {

	public class Formulaire{
		
		@Min(value = 18, message = "Vous devez être majeur")
		private int age;

		Formulaire(){
			age = 0;
		}
		
		public void setAge(int age) {
			this.age = age;
		}
		public int getAge() {
			return age;
		}
	}
	private String message = "";
	@GetMapping("view")
	// send an object list to the view.html and control a form
	public String view(Model model) {
		List<String> list = List.of("one ", "two ", "three !");
		model.addAttribute("list", list);
		model.addAttribute("formulaire", new Formulaire());
		return "view";
	}


	@PostMapping("view")
	public String test(@Valid Formulaire formulaire, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "view";
		}
		model.addAttribute("message", "Bienvenue sur la page de test");
		return "view";
	}

}

