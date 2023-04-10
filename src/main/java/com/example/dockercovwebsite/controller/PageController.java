package com.example.dockercovwebsite.controller;

import java.util.List;

import com.example.dockercovwebsite.model.CoronaVirusStatsLocation;
import com.example.dockercovwebsite.service.CoronaVirusData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PageController {

    @Autowired
    CoronaVirusData coronaVirusData;
    
    @RequestMapping("/")
    public String index(Model model){
        List<CoronaVirusStatsLocation> allstats = coronaVirusData.getAllstats();
        int sum = allstats.stream().mapToInt(stats -> stats.getCases()).sum();
        int total_sum = allstats.stream().mapToInt(stats -> stats.getTotalCases()).sum();
        model.addAttribute("stats", allstats);
        model.addAttribute("todays_sum", sum);
        model.addAttribute("sum", total_sum);
        return "home";
    }
    
}
