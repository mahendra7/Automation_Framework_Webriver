# Automation_Framework_Webriver
Automation Testing Framework built with Webdriver, Maven, Testng, Java.

This project will create two users on http://hellosign.com and register the users for a free individual plan using Firefox.

1. Clone the Repository using git clone. $ git clone https://github.com/mahendra7/Automation_Framework_Webriver.git

2. Change directory using the cd command to Automation_Framework_Webriver. $ cd Automation_Framework_Webriver/

3. You should see pom.xml in the Automation_Framework_Webriver directory. $ ls
RemoteSystemsTempFiles		pom.xml				target				testng.xml
dependency-reduced-pom.xml	src				test-output

4. Run mvn compile to compile the project. $ mvn compile 
You should see the [INFO] BUILD SUCCESS message in your terminal.

5. Run mvn test to run the automation tests in the project. $ mvn test 
You should see the following success message in your terminal after the tests have been run.
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
