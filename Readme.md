Programming language used: Java

Design:

Every class is called from main UI class - RestaurantForm.java.
The 3 classes BreakfastMenu, LunchMenu and DinnerMenu each have methods to add, delete, modify and swap dishes and are called via button click.

Edit the following properties in persistence.xml in src/META-INF in Eclipse:

```
<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/<your_db_name>" />
<property name="javax.persistence.jdbc.user" value="<your_db_username>" />
<property name="javax.persistence.jdbc.password" value="<your_db_password>" />

```

Alternatively, you can enter the database details directly in executable jar file(RestaurantMenu.jar).

Run the jar file and you'll find a UI to enter database details. Next you'll see the buttons to add, remove dish, update its price and description as well as to swap it between breakfast, lunch and dinner.


To build docker:

docker build -t imageRestaurantMenu .

To run inside container :

docker run imageRestaurantMenu