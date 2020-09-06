package UdemyCourse.springBoot.covidTracker.controller;

import UdemyCourse.springBoot.covidTracker.models.LocationStatistics;
import UdemyCourse.springBoot.covidTracker.services.CovidDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    CovidDataService covidDataService;

    @GetMapping("/") // whenever there is a mapping to the root url and we've added hymeleaf as a dependency
    public String home(Model model) {
        Date date = new Date();
        List<LocationStatistics> allStats = covidDataService.getStatisticsList();
        int totalGlobalCases = allStats.stream().mapToInt(stat -> stat.getTotalCases()).sum();
        int totalNewCases = allStats.stream().mapToInt(stat -> stat.getDifferenceFromPrevDay()).sum();
        model.addAttribute("locationStatistics", covidDataService.getStatisticsList());
        model.addAttribute("totalGlobalCases", totalGlobalCases);
        model.addAttribute("totalNewCases", totalNewCases);
        model.addAttribute("date", date);
        return "home";
    }
}
