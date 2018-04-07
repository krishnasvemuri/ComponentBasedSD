/*Krishna Sindhuri Vemuri G01024066 SWE 645 HomeWork 1 */
/* This file contains installation and set up instructions to deploy and run the assignment*/

Procedure to the Project 
------------------------


Step1 :
-------
Check if your sytem has JDK 1.7 so that you can run Tomcat or JBoss.
If not download JDK 1.7, it can be found on   http://www.oracle.com/technetwork/java/javase/downloads/index.html


Step 2:
-------
If you have not installed Tomcat prior, then make sure you download Tomcat 7 or later versions on your system. 
This can be downloaded from https://tomcat.apache.org/download
Download and save the zip file (32 bit or 64 bit version depending on your O/S)
Unzip the file and install.
Once started, Tomcat will be up and running at http://localhost:8080(check this on the browser).


Step 3 :
--------
If you have not installed Eclipse IDE(J2EE) prior, please download it using http://www.eclipse.org
Open eclipse and create a new dynamic web project by clicking on File-> New -> Dynamic Web Project
Browse through thr Tomcat installation directory and add the downloaded Tomcat server on it. 
Once the server is running, you can access the homepage at localhost:8080( check this on the browser).


Step 4 : 
--------
Once the server is running import the war file on to the Dynamic Web Project and run the Project on the Tomcat Server. 
If everything works fine then you may see the project on http://localhost/8080.


Step 5 : 
--------
Use the following links to view the html page on the aws s3 and ec2.
S3- https://s3.amazonaws.com/swe645-vemuri/index.html
EC2- http://ec2-54-243-9-192.compute-1.amazonaws.com/Web/survey.html



Deploying files on AWS S3
--------------------------


Step 1 :
--------
Create an AWS account and Login.
Or 
Login to your AWSaccount if it already exists  


Step 2 :
--------
Go to resources-> Storage -> click on S3


Step 3 : 
--------
Click on create bucket
Name the bucket 
Select the region 
Click next 
Click next 
Set permission to "grant public read access to the bucket"
Click next
Review and create the bucket.


Step 4 :
--------
To upload required files on the create bucket.
Click on Properties
Click on Static Website hosting
Select "Use this bucket to host a website"
Click on Save
Name your index document.
Upload required files from your System.
Click next and Under “Manage public permissions”, select “Grant public read access to select “Grant public read access to select “Grant public read access to select “Grant public read access to select “Grant public read access to select “Grant public read access to select “Grant public read access to the objects” 
Press next
Press upload


Step 5 :
-------- 
https://s3.amazonaws.com/swe645-vemuri/index.html
Using the above link, the static webpage can be viewed.



To deploy and terminate an EC2 instance
---------------------------------------


Step 1 :
--------
Login to your AWS account.


Step 2 :
--------
Go to resource groups and under compute select EC2


Step 3 :
--------
Click on Launch instance.
Choose an Amazon Machine Image (AMI) - tomcat powered by bitnami
Choose an instance type - t1.micro or t2.micro(generally the free instance) and click next to configure instance details
Choose the default settings and click next to add storage 
Choose the default options and click next to ttag instance
Name your tag instance and click next to configure security group
Choose the default options and click on review and Launch
Review the instance and Launch the instance.
Once you have launched your instance choose a key value pair to access to the private key.
Now click launch.
Click on view instances.


Step 4 :
--------
Once your instance is running copy the public DNS name and open it in the browser.
You should be seeing your tomcat there.


Step 5 :
--------
You can keep running your instance or terminate ant anytime by clicking on the instance state and selecting the desired option.



To deploy WAR file on EC2.
---------------------------


Step 1 :
--------
Download the FTP client WinSCP using https://sourceforge.net/projects/winscp/files/latest/download


Step 2 :
--------
Copy the public DNs of your instance insto hostname
Select SCP as the file protocol.
Type in "bitnami" as the username
Then select the advanced settings


Step 3 :
--------
Click on SCP/Shell environment
select sudo su- shell and click OK


Step 4 :
--------
Click on Authentication SSH and browse to the path of the .pem file of your instance.
Click OK
Click OK to convert the .pem to .ppk file


Step 5 :
--------
Save all the settings
Add the WAR file to opt/bitnami/apache-tomcat/webapps folder path 
Access this project through the browser using the link 
http://ec2-54-243-9-192.compute-1.amazonaws.com/Web/survey.html
