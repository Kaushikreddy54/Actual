package com.example.demo.AppInsight;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Application.ApplicationService;
import com.example.demo.Flow.FlowService;

@RestController
public class AppInsightController {
	
	@Autowired
	AppInsightService ais;
	@Autowired
    FlowService fs;
	@Autowired
    ApplicationService as;

    @PostMapping("/apis")
    public String addAppInsight(@Validated @RequestBody AppInsight ai)
    {
    	return ais.addAppInsight(ai);
    }

    @GetMapping("/apis/{appName}/{flowName}")
    public List<Object> getAppInsightByAppNameAndFlowName(@PathVariable String appName,@PathVariable String flowName)
    {
    	List<Object> obj=new ArrayList<>();
    	obj.add(ais.getAppInsightByAppNameAndFlowName(appName,flowName));
    	obj.add(fs.getFlowByAppNameAndFlowName(appName,flowName));
    	obj.add(as.getApplicationByAppNameAndFlowName(appName,flowName));
    	return obj;
    }
    
    @GetMapping("/apises")
    public List<AppInsight> getAllAppInsights()
    {
    	return ais.getAll();
    }
    
    @PutMapping("/apis/{id}")
    public AppInsight updateAppInsight(@PathVariable String id,@Validated @RequestBody AppInsight ai)
    {
    	return ais.update(id, ai);
    }

    @DeleteMapping("/apis/{id}")
    public String deleteAppInsight(@PathVariable String id)
    {
    	return ais.deleteAppInsight(id);
    }

}
