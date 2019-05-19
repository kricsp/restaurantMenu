Programming language used: Java

Edit the following properties in persistence.xml in src/META-INF:

<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/<your_db_name>" />
<property name="javax.persistence.jdbc.user" value="<your_db_username>" />
<property name="javax.persistence.jdbc.password"
value="<your_db_password>" />

To compile the code on *nix computers execute the following commands:

To compile and run the program:

$ make

Execute the following file:

$ ./main.sh 
