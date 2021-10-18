# QE-NE-Digital-Pretest

Answer to Question 1, 2 and 4 
Excel Sheet: QE NE Digital Pretest
Topic 1: Tell us what kind of test should be conduct (plan and why) to make sure the page is ok. 
Topic 2: Tell us what kind of testcase you want to execute. -> list of Test Cases
Topic 4: SQL Query or refer query.sql file

Prerequisite:
1. Install JDK 1.8
2. Install Maven 3 Version
3. Set JAVA_HOME and MAVEN_HOME path
4. Install Chrome Browser


QA Framework Technology: Java, Maven, GIT, Selenium, Cucumber, Extent Cucumber Report 

GIT Source		: 	https://github.com/smanzar27/QE-NE-Digital-Pretest.git
Take CheckOut	: 	git clone https://github.com/smanzar27/QE-NE-Digital-Pretest.git


Goto CheckOut Folder:
1. Compile Source Code:		mvn clean install -Dmaven.test.skip=true

Goto CheckOut Folder:
1. Run TestCode:			mvn test -Dtest=CucumberRunner -Dcucumber.filter.tags="@GUI"

Report Folder:
it will contains following files
a) Cucumber Report HTML Report
b) Cucumber Report PDF Formt
c) screenshot in case test failure

config.xml is Jenkins Job to run Test Cases, 
it can be imported to new Jenkins Server to run TC from Jenkins

consoleText.txt is console log of Jenkins Job


 
