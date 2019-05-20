Programming language used: Java

Edit the following properties in persistence.xml in src/META-INF in Eclipse:

```
<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/<your_db_name>" />
<property name="javax.persistence.jdbc.user" value="<your_db_username>" />
<property name="javax.persistence.jdbc.password"
value="<your_db_password>" />

```

Alternatively, you can enter the database details directly in executable jar file(RestaurantMenu.jar).