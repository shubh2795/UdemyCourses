package UdemyCourse.springBoot.covidTracker.controller;

import UdemyCourse.springBoot.covidTracker.models.LocationRecoveries;
import UdemyCourse.springBoot.covidTracker.services.CovidRecoveryDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

@Controller
public class RecoveriesController {
    @Autowired
    CovidRecoveryDataService covidRecoveryDataService;

    @GetMapping("/recoveries")
    public String recoveries(Model model){
        List<LocationRecoveries> allRecoveryStats = covidRecoveryDataService.getStatisticsList();
        int totalGlobalRecoveries = allRecoveryStats.stream().mapToInt(stat -> stat.getRecoveries()).sum();
        int totalNewRecoveries = allRecoveryStats.stream().mapToInt(stat -> stat.getDifferenceFromPrevDay()).sum();
        Date date = new Date();
        model.addAttribute("date", date);
        model.addAttribute("totalGlobalRecoveries", totalGlobalRecoveries);
        model.addAttribute("locationRecoveryStatistics", covidRecoveryDataService.getStatisticsList());
        model.addAttribute("totalNewRecoveries", totalNewRecoveries);
        return "recoveries";
    }


}
