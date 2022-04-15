package com.springlec.base0602.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base0602.command.BCommand;

@Controller
public class BController {
	
	private BCommand listCommand = null;
	private BCommand writeCommand = null;
	private BCommand updateCommand = null;
	private BCommand deleteCommand = null;
	private BCommand contentCommand = null;

	
	@Autowired
	public void auto(BCommand list, BCommand write, BCommand update, BCommand delete, BCommand content) {
		this.listCommand = list;
		this.writeCommand =write;
		this.updateCommand =update;
		this.deleteCommand =delete;
		this.contentCommand =content;
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
		
//		command = new BListCommand();
//		command.execute(model);
		listCommand.execute(model);
		
		return"list";
	}
	
	@RequestMapping("/write_view")
		public String mvWrite() {
			return "write_view";
		
	}
	
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("write()");
		
		//--요소 하나하나를 받아오면 길어지기 때문에 리퀘스트로 통으로 받아온다. 
		model.addAttribute("request",request);
//		command = new BWriteCommand();
//		command.execute(model);
		writeCommand.execute(model);
		
		return "redirect:list";
		
	}
	
	@RequestMapping("/content_view")
	public String content(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
//		command = new BContentCommand();
//		command.execute(model);
		contentCommand.execute(model);
		
		return "content_view";
	}
	
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
//		command = new BUpdateCommand();
//		command.execute(model);
		updateCommand.execute(model);
		
		return "redirect:list";
	}
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
//		command = new BDeleteCommand();
//		command.execute(model);
		deleteCommand.execute(model);
		
		return "redirect:list";
	}
	
	
}
