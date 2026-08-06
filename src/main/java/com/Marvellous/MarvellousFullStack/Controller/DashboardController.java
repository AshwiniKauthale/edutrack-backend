package com.Marvellous.MarvellousFullStack.Controller;

import com.Marvellous.MarvellousFullStack.DTO.DashboardChartDTO;
import com.Marvellous.MarvellousFullStack.DTO.DashboardStats;
import com.Marvellous.MarvellousFullStack.Service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin(origins = {
        "http://localhost:5173",
        "https://edutrack-frontend-topaz.vercel.app"
})
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping
    public DashboardStats getStats() {
        return dashboardService.getDashboardStats();
    }

    @GetMapping("/charts")
    public DashboardChartDTO getCharts() {
        return dashboardService.getChartData();
    }
}