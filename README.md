CB_UserCRUD
==================

This web application is a simple Create, Read, Update and Destroy (CRUD) user administration system. It was develop to be integrated to a major supervisory system for automatic cat litter boxes (CleanBOX) in the context of internet of things (IoT). Although currently not yet communicating with the IoT devices, it's integrated with a MySQL database management system to handle the users information. The back-end was developed in 'pure Java' to work with the Apache Tomcat HTTP web server environment. The front-end was build with HTML and CSS.

---

## How to Run

To run the application, there must be configured an environment with the Apache Tomcat server. A distribuion is provided to be installed in a local machine at https://tomcat.apache.org/. As well, the MySQL Connector/J driver is necessary to support the communication of the java application with the MySQL database and is freely provided at https://dev.mysql.com/downloads/connector/j/. Optionally, a distribution of a database management system can be installed locally, like PostgreSQL. The hole database structure creation and a few SQL example queries are provided at src/model/MySQLqueries.sql as a groundwork to run the web guest application.

---
#### Home Screen

<img src="https://github.com/rodrigojost/CB_UserCRUD/blob/master/assets/index.png">

#### User Register Screen

It's possible to register users with the following information.

<img src="https://github.com/rodrigojost/CB_UserCRUD/blob/master/assets/cadUsuario.png">

#### User Registry Editing Screen

It's possible to edit an user registry through the following page.

<img src="https://github.com/rodrigojost/CB_UserCRUD/blob/master/assets/edUsuario.png">

#### User Search and Destroy Screen

It's possible to perform a search for users through their e-mail address as follows. Returned results can be deleted or edited.

<img src="https://github.com/rodrigojost/CB_UserCRUD/blob/master/assets/conUsuario.png">