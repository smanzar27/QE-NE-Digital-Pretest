# QE-NE-Digital-Pretest

Answer to Question 1, 2 and 4 
Excel Sheet: QE NE Digital Pretest
Topic 1: Tell us what kind of test should be conduct (plan and why) to make sure the page is ok. 
Topic 2: Tell us what kind of testcase you want to execute. -> list of Test Cases
Topic 4: SQL Query or refer query.sql file

rerequisite:
1. Install JDK 1.8
2. Install Maven 3 Version
3. Set JAVA_HOME and MAVEN_HOME path
4. Install Chrome Browser

GIT Source		: 	https://github.com/smanzar27/QE-NE-Digital-Pretest.git
Take CheckOut	: 	git clone https://github.com/smanzar27/QE-NE-Digital-Pretest.git


Goto CheckOut Folder:
1. Compile Source Code:		mvn clean install -Dmaven.test.skip=true

Goto CheckOut Folder:
1. Run TestCode:			mvn test -Dtest=CucumberRunner -Dcucumber.filter.tags="@GUI"


 
