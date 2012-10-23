This contains the set of instructions required to build and run the Client Server application.

Building the Project.
====================

Pre-requisites
--------------
JDK 1.5.x or higher
Maven 2 or higher
set java_home and m2_home.
eClipse 3.5 or higher

Steps:
------
1 - download the project.
2 - Go to the project home directory of ClientServerComunication, and run 
    $ mvn clean package
    
3 - Import project to your IDE 
	a) To import your project into eclipse IDE
			$ mvn eclipse:eclipse
 			Import the project into eclipse IDE (Existing Projects in Workspace > Browse and locate the extracted "TollGis" folder). 
    


Running the application.
========================

Go to target folder and 
	1.	To Start the server (Please start the server first)
			java -DrunAs=server -jar toll-gis.jar
		
	2.	To Start the client
			java -DrunAs=client -jar toll-gis.jar
		
To send messages, please follow the prompts made by the client
	
	Additional Information on the client prompts
	   Please enter server IP address:please type the server ip or "localhost" if you are running locally
       Please enter server port      : Default is 7777 (this is configurable)
       
       


