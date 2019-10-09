package com.owner.test.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	private Producer captchaProducer;

	@RequestMapping("/index")
	public String index() {
		
		return "index";
	}
	
	@RequestMapping("/success")
	public String success() {
		
		return "common/success";
	}
	
	
	@RequestMapping("/failure")
	public String error() {
		
		return "common/error";
	}
	
	@RequestMapping("/validcode")
	public void kaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        
        String code = captchaProducer.createText();
        
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY,code);
        
        BufferedImage bi = captchaProducer.createImage(code);
        
        ServletOutputStream out = response.getOutputStream();
        
        ImageIO.write(bi, "jpg", out);
        
        try {
            out.flush();
        } finally {
            out.close();
        }
	}
}
