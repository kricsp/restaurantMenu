LIB_PATH=./lib/eclipselink.jar:./lib/javax.persistence.source_2.1.1.v201509150925.jar:./lib/javax.persistence_2.1.1.v201509150925.jar:./lib/mysql-connector-java-8.0.16.jar
all: clean
	mkdir bin
	mkdir bin/classes
	javac -classpath $(LIB_PATH) -d bin/classes/ src/BreakfastMenu.java src/DinnerMenu.java src/Dish.java src/LunchMenu.java src/MainMenu.java src/RestaurantForm.java


clean:
	rm -rf bin/

