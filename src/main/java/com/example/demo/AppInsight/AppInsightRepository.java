package com.example.demo.AppInsight;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppInsightRepository extends MongoRepository<AppInsight,String>{
	
	List<Object> findByAppNameAndFlowName(String appName,String flowName);

}
