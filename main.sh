#!/bin/bash +vx
LIB_PATH=$"./lib/eclipselink.jar:./lib/javax.persistence.source_2.1.1.v201509150925.jar:./lib/javax.persistence_2.1.1.v201509150925.jar:./lib/mysql-connector-java-8.0.16.jar"

java -classpath bin/classes:$LIB_PATH RestaurantForm 