package com.example.demo.controllers;
import org.springframework.stereotype.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String greeting(Model model) {
        model.addAttribute("Calc", "Калькулятор");
        model.addAttribute("Action", "Выберите метод");
        return "home";
    }

    @GetMapping("/p")
    public String greet(Model model) {
        return "Post";
    }

    @PostMapping("/Post")
    public String PostRes(@RequestParam(value = "Pervoe",  required = false)
                          String a,@RequestParam(value = "Znak",  required = false, defaultValue = "2")
                          String b,@RequestParam(value = "Vtoroe",  required = false)
                          String c, Model model) {
        double itog;
        String Resault = "Что-то сделали не так";
        try {
            if (b.equals("+")) {
                itog = Double.parseDouble(a) + Double.parseDouble(c);
                model.addAttribute("znaki", itog);
            }
            if (b.equals("-")) {
                itog = Double.parseDouble(a) - Double.parseDouble(c);
                model.addAttribute("znaki", itog);
            }
            if (b.equals("*")) {
                itog = Double.parseDouble(a) * Double.parseDouble(c);
                model.addAttribute("znaki", itog);
            }
            if (b.equals("/") && !c.equals("0")) {
                itog = Double.parseDouble(a) / Double.parseDouble(c);
                model.addAttribute("znaki", itog);
            }
        } catch (NumberFormatException e) {
            model.addAttribute("znaki", Resault);
        }
        return "Result";
    }

    @GetMapping("/Get")
    public String GetRes(@RequestParam(value = "Pervoe",  required = false)
                         String a,@RequestParam(value = "Znak",  required = false, defaultValue = "+")
                         String b,@RequestParam(value = "Vtoroe",  required = false)
                         String c, Model model) {
        double itog;
        String Resault = "Вы не выбрали значения";
        try {
            if (b.equals("+")) {
                itog = Double.parseDouble(a) + Double.parseDouble(c);
                model.addAttribute("znaki", itog);
            }
            if (b.equals("-")) {
                itog = Double.parseDouble(a) - Double.parseDouble(c);
                model.addAttribute("znaki", itog);
            }
            if (b.equals("*")) {
                itog = Double.parseDouble(a) * Double.parseDouble(c);
                model.addAttribute("znaki", itog);
            }
            if (b.equals("/") && !c.equals("0")) {
                itog = Double.parseDouble(a) / Double.parseDouble(c);
                model.addAttribute("znaki", itog);
            }
        } catch (NumberFormatException e) {
            model.addAttribute("znaki", Resault);
        }
        return "Get";
    }
}