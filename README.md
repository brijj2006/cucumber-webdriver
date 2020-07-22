# cucumber-webdriver
 cucumber-webdriver framework skeleton
 
### Tech-Specs
```
Java                                   #programming language
Selenium/WebDriver                     #UI automation API
Maven                                  #build and dependency management 
Cucumber                               #BDD framework - test runner/reports
Spring Framework/Page Object Model     #dependecy injection/design pattern
Log4j                                  #logging 
```

### Framework Structure  

**Driver Management Classes**  
```
BaseDriver        #base functions
BeanUtil          #bean handling in non spring classes
DriverManager     #spring based driver manager
```

**Page Factory Pattern**  
```
pages/*.java    #page classes
```

**Glue Code**    
```
glue/*.java     #step definition classes
```

**Project configuration files**  
```
config.properties          #application config 
applicationContext.xml     #spring config 
Cucumber.xml               #spring config 
log4j.properties           #log config
```

**Test Specs**  
```
RunTest                               #cucumber test run configurations
features/google_search.feature        #Feature file having the test scenarios/user stories
```

**Reports/Logs**  
```
cucumber-reports/index.html         #cucumber test report for the test execution
log4j-bgp.log                       #test execution log file have the full details of each steps executed
```

**Run Cucumber Tests**  
```
right click on RunTest > Run ‘RunTest’
```

**Framework Snapshot**  

![image](https://user-images.githubusercontent.com/50976445/88057415-a14d0880-cb94-11ea-810a-dbeaed5b87a7.png)  


**Test Log**  

![image](https://user-images.githubusercontent.com/50976445/88056459-2cc59a00-cb93-11ea-8419-c855c1e58026.png)  


**Cucumber Report**  

![image](https://user-images.githubusercontent.com/50976445/88056561-5aaade80-cb93-11ea-8e30-3c18c753f00e.png)  


***end of document***  
