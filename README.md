# sendIt
Alex Key, Asa Murphy, Chassidy Foreman, Patrick Parker, Zachary Goldberg<br>
We want to create a desktop application that will allow users to send files in between devices.<br>
The target group could be for students and the general working class who may need to transfer data between work stations.<br>
We are doing this because we feel like transferring data via email is a hinderence to an individuals productivity and effieicency at getting work done.<br>

## General Info
![Logo](./logo/logo.png) <!--Application logo --> <!--Application logo -->


## Technologies
<ul>
  <li>https://www.mysql.com/</li>
  <li>Java</li>
</ul>

## Features
<ul>
  <li>Desktop Server - A server to connect the clients, run by the admin.</li>
  <li>Desktop Interface - Allows users to interact and navigate with the program.
</ul>

## Accomplishments
<ul>
  <li><strong>Asa Murphy:</strong> Developed the user home GUI and responsible for implementing computer directory accessbility, and linking the text GUI feature. (Files Developed: ChooseFile.java, SenditGui.java, sendit-icon.png, sendit.png). Developed Admin GUI interface for backend server and application monitoring.</li>
  <strong>Alex Key:</strong> All files inside db directory were done by Alex Key. This includes the connector.java, as well as the connector_doc.txt. A mySQL database was setup on my local machine to test the connector, but theres no code for that. The artifact is used for querying / inserting / updating / deleting table columns in our database. My next step will be to install and setup the db on our server, as soon as the server is ready.
  <br>
  <strong>Sprint 2:</strong>Designed user table for use in database and help setup database on server. Artifact: db_design branch: db_design.txt. This is used to create user's and log them in. Next step will be too setup a subclass for Admin user, and store in DB.
  </li>
  <li>
    <strong>Chassidy Foreman:</strong> Created the basic text GUI with button functionality to be handed off to the team for additional linking to server and other GUIs. Developed the login GUI to be linked to the updated Text GUI for the future client. The next step will be updating the layout of the text GUI to make it more appealing to the user. Created an account sign-up GUI for the application and added that to the login GUI that will be connected to the database in the future.
  </li>
  <li>
    <strong>Zachary Goldberg:</strong> Sprint 1: Created the server and linked all pieces together. The next step is to create a method for handling other files types. Sprint 2: Hooked database into the server. Going forward I am hoping to get full user login functionality and user seperation working.
  </li>
  <li>
    <strong>Patrick Parker:</strong> Sprint 1: Created Client side of program to link up to server. Sprint 2: Redid base code for server and client for sending and recieving objects instead of strings. Added in some functionality for image sending and recieving. Going Forward: Working on getting more features added and updating any code that could use refactoring.
  </li>
</ul>
