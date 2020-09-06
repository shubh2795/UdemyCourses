package UdemyCourse.springBoot.covidTracker.controller;

import UdemyCourse.springBoot.covidTracker.models.LocationDeaths;
import UdemyCourse.springBoot.covidTracker.services.CovidDeathDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

@Controller
public class DeathsController {

    @Autowired
    CovidDeathDataService covidDeathDataService;

    @GetMapping("/deaths")
    public String deaths(Model model){
        Date date = new Date();
        List<LocationDeaths> allDeathStats = covidDeathDataService.getStatisticsList();
        int totalGlobalDeaths = allDeathStats.stream().mapToInt(stat -> stat.getDeaths()).sum();
        int totalNewDeaths = allDeathStats.stream().mapToInt(stat -> stat.getDifferenceFromPrevDay()).sum();
        model.addAttribute("locationDeathStatistics", covidDeathDataService.getStatisticsList());
        model.addAttribute("totalGlobalDeaths", totalGlobalDeaths);
        model.addAttribute("totalNewDeaths", totalNewDeaths);
        model.addAttribute("date", date);
        return("deaths");
    }


}
