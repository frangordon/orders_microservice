Microservices Exercise - Orders Backend
=========================================

## Setup

If you are running this backend or any of the other four Microservices Exercise backends for the first time, then you will need to setup the database so that you can start. This involves:
  1. Creating the database
  2. Editing the 'application.properties' file
  
### Creating the Database

You will need to start by verifying that the 'setup.sh' script has the correct user information (your MariaDB root user password).

Navigate to the file (located within the 'setup' folder next to the 'java' folder) and open it in your desired editor. Ensure that you replace the specified password in the file with your own. It should look similar to what is shown bellow with your own password replacing 'passwordHere':

```
mysql --user=root --password=passwordHere < initialise.sql
```

Once this is done, save the file. Now, you will need to make the file executable. Open your terminal, and navigate to the setup folder containing the 'setup.sh' file. When you arrive at the directory, enter the following command to make the file executable, and then to run the file and create your Store database.

1.  `chmod a+x setup.sh`

2.  `./setup.sh`

Now to verify your database exists, run the following commands:

1. `mysql`
2. `show databases;`

The Store database should be shown in a table of all the existing databases on your machine.

<img width="159" alt="image" src="https://user-images.githubusercontent.com/101400425/190202753-78bbbfb5-1af2-42f7-82ae-ed406b9994de.png">

### Editing the 'application.properties' File

You will now need to edit your 'application.properties' file to ensure the backend works as intended.

Navigate to the file (located within the 'resources' folder next to the 'java' folder) and open it in your desired editor. Ensure that you replace the specified password in the file with your own. It should look similar to what is shown bellow with your own password replacing 'passwordHere':

```
server.port=5003
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
spring.datasource.url=jdbc:mariadb://localhost:3306/Store
spring.datasource.username = root
spring.datasource.password = passwordHere
spring.jpa.hibernate.ddl-auto = update
```

Once this is done, save the file.

You are now ready to run the backend

## Running the Backend

To run the backend, you will need to run the 'DemoApplication' file (located within the 'java' folder) within an appropriate IDE such as IntelliJ. This should initialise spring boot and your backend should be working. Test this using software like Postman or Insomnia by sending a GET request to the following address:

```
localhost:5003/orders
```

This should return an empty JSON response if the database is currently empty.

```
[]
```

If this works, it means the backend is functional and you can now use it.

Have fun!

