package com.payilagam.AdvancedJava.Controller;

import com.payilagam.AdvancedJava.Service.goldCalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("/home")
public class PayilgamController {

    @ResponseBody
    @RequestMapping("/welcome")
    public String welcome(@RequestParam String name)
    {
        System.out.println("welcome to payilagam");
        return "hai :"+name;
    }

    @ResponseBody
    @RequestMapping("/page/{page}")
    public String pathvariable(@PathVariable int page)
    {
                return "welcome to page"+page;
    }

    @ResponseBody
    @RequestMapping("/gold")
    public String goldUnit(@RequestParam double amount)
    {
        goldCalculatorService gu = new goldCalculatorService();
        double output = gu.calculate(amount);
        return ("you can buy "+output+" units of gold");

    }


}
