package com.equabank.skoleni2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
    	StringBuilder buff = new StringBuilder(100);
    	buff.append("<html>");
    	buff.append("<head>");
    	buff.append("</head>");
    	buff.append("<body>");
    	buff.append("<h1>Ahoj lidi!</h1>");
    	buff.append("");
    	buff.append("");
    	buff.append("</body>");
    	buff.append("</html>");
        return buff.toString();
    }

}