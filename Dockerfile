FROM anapsix/alpine-java
MAINTAINER KrishanPal 
COPY RestaurantMenu.jar /home/RestaurantMenu.jar
CMD ["java","-jar","/home/RestaurantMenu.jar"]