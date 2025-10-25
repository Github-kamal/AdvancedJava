package com.payilagam.AdvancedJava.Controller;

import com.payilagam.AdvancedJava.Pojo.TrainerPojo;
import com.payilagam.AdvancedJava.Service.TrainerService;
import com.payilagam.AdvancedJava.Service.goldCalculatorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//Logger logger = LoggerFactory.getLogger(PayilgamController.class);

@RestController
@RequestMapping("/home")
public class PayilgamController {


    @Autowired
    TrainerService ts;

    @RequestMapping("/")
    public String home() {
        return "home";
    }


    @ResponseBody
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(@RequestParam(defaultValue = "Guest") String name) {
        System.out.println("welcome to payilagam");
        return "hai :" + name;
    }

    @ResponseBody
    @RequestMapping("/page/{page}")
    public String pathvariable(@PathVariable int page) {
        return "welcome to page" + page;
    }

    @ResponseBody
    @RequestMapping("/gold")
    public String goldUnit(@RequestParam double amount) {
        goldCalculatorService gu = new goldCalculatorService();
        double output = gu.calculate(amount);
        return ("you can buy " + output + " units of gold");

    }

    @PostMapping("/addTrainer")
    public String addTrainer(@RequestBody TrainerPojo pojo) {
        /*logger.info("Adding trainer: " + pojo.getName());
        logger.info("Trainer experience: " + pojo.getExperience());
        logger.info("Trainer subject: " + pojo.getSubject());
        logger.info("Trainer ID: " + pojo.getId()); */
        ts.addTrainer(pojo);
        return "Trainer added successfully";


    }

    @GetMapping("/getTrainer/{id}")
    public ResponseEntity<TrainerPojo> getTrainer(@PathVariable int id) {

        ResponseEntity<TrainerPojo> response = null;
        if (ts.getTrainer(id) != null) {
            TrainerPojo trainerPojo = ts.getTrainer(id);
            response = ResponseEntity.ok(trainerPojo);
        } else {

                 response = ResponseEntity.status(404).body(null);
        }
        return response;
    }




    @DeleteMapping("/removeTrainer/{id}")
    public ResponseEntity<String> removeTrainer(@PathVariable int id) {
        ts.deleteTrainer(id);
        return ResponseEntity.ok("Trainer deleted successfully");
    }

    @PutMapping("/updateTrainer/")
    public String updateTrainer(@RequestBody TrainerPojo pojo) {
        ts.updateTrainer(pojo);
        return "Trainer updated successfully";
    }


    @GetMapping("/deleteTrainer/{id}")
    public String deleteTrainer(@PathVariable int id) {

        ts.deleteTrainer(id);
        return "Trainer deleted successfully";

    }

}

