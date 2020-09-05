package UdemyCourse.springBoot.covidTracker.controller;

import UdemyCourse.springBoot.covidTracker.services.CovidDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    CovidDataService covidDataService;

    @GetMapping("/") // whenever there is a mapping to the root url and we've added hymeleaf as a dependency
     public String home(Model model){
        model.addAttribute("locationStatistics",covidDataService.getStatisticsList());
        return "home";
     }
}
