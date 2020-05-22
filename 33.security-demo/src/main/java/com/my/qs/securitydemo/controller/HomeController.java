package com.my.qs.securitydemo.controller;

import com.my.qs.securitydemo.util.CodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

@Controller
public class HomeController {

	@GetMapping({"/index", "/"})
	public String index(){
		return "index";
	}

	@GetMapping("/login")
	public String login(){
		return "login";
	}
	@GetMapping("/hello")
	public String hello(){
		return "hello";
	}

	@GetMapping("/code/image")
	public void imageCode(HttpServletResponse response, HttpSession session){
		Map<String, Object> codeAndPic = CodeUtil.generateCodeAndPic();
		session.setAttribute("IMAGE_CODE", codeAndPic.get("code"));
		BufferedImage codePic = (BufferedImage)codeAndPic.get("codePic");
		response.setContentType("image/jpeg");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		try {
			ImageIO.write(codePic, "JPEG", response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
