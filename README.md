# ZFGC3
It's a secret to everyone.  

## Installation
Install JDK 8 https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html
Install Tomcat 9 https://tomcat.apache.org/download-90.cgi
Install Eclipse Java EE https://www.eclipse.org/downloads/packages/

Create a workspace folder separate from where this repo is cloned
Load this folder into Eclipse
Import the project as an "existing maven project"
Right click the project, Go to Run As, Run Configurations
Click Maven Build, then create new
Enter ${workspace_loc:/forum} into base directory
Enter clean install into Goals
Check skip Tests
On the JRE tab, set the alternate JRE to jdk 1.8
Click Apply, then Run to build the .war
Go to the servers tab and add a new Tomcat 9 server
Deploy the project to the server
Clean the server then start in debug mode
