package com.catolicasc.maisbarato.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
public class WebController {
  
	
	@RequestMapping(value={"/","home"})
    public String index(){
        return "home";
    }
  
    @RequestMapping(value="/403")
    public String Error403(){
        return "403";
    }
}