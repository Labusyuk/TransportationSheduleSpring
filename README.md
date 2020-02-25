# Transportation Shedule
Java Spring. Continuation of project development logistic system showcase (https://github.com/Labusyuk/TransportationShedule). 

This project was released with mysql, mariaDB, mongoDB.
##### Instructions to run the project:

1. Download and install jdk 1.8, Git,.
2. Clone project: git clone https://github.com/Labusyuk/TransportationSheduleSpring.git
3. Prepare database. Configuration application.properties.
3. cd to project folder and mvnw clean install
4. Maybe you must install some library in Tomcat lib folder, its: commons-collections, jsoup. In my case there is C:\Program Files\Apache Software Foundation\Tomcat 9.0\lib.
4. execute "java -jar transportation2-1.0-SNAPSHOT.jar" in command line/=.

##### Note: 
The program parses and stores transport data, routes, stops, schedules in db from site www.depo.vn.ua. Parsing takes a long time (10min). To start parse data go to *host*/update in browser.
There's really a lot of information out there, at each stop, on your schedule: weekdays and weekends. Routes in one transport in different directions are regarded as different ((Залізничний вокзал - Вишенька   /  Вишенька - Залізничний вокзал ).

##### Available pages:
 * / - main page. If you didn't authorized you would be redirected Spring auth page.
 * /update - update database. Start process parsing from www.depo.vn.ua.
 * /info - information of capacity database.
 * /find - controller of route building.
 * /logout - logout from Spring Security.
 * /test - testing development
##### The look of the web page of the service

![Look of the web page](https://raw.githubusercontent.com/Labusyuk/TransportationSheduleSpring/master/other/mainpage.png)

##### Image ER-diagram database of the project;

<p align="center">
  <img src="https://raw.githubusercontent.com/Labusyuk/TransportationSheduleSpring/master/other/transportionshedule2.png">
</p>

##### Image of several web-pages of te project;

######      Login pages:
<p align="center">
  <img src="https://raw.githubusercontent.com/Labusyuk/TransportationSheduleSpring/master/other/login_page.png">
</p>

######      Info pages:
<p align="center">
  <img src="https://raw.githubusercontent.com/Labusyuk/TransportationSheduleSpring/master/other/inforamtionpage.png">
</p>
