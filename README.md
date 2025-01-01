# cloudnative-gam-jdk21
Application on top of GA-SDK using jdk 21.

# Image names pushed in docker: Just use docker compose file to run.

navneet204/mmv3-gam-addressing:0.0.1-SNAPSHOT

navneet204/mmv3-gam-client:0.0.1-SNAPSHOT

navneet204/mmv3-gam-gateway:0.0.1-SNAPSHOT

navneet204/mmv3-gam-naming-server:0.0.1-SNAPSHOT


=====================================================================

# How to create Docker Images:

1: Make sure data location and resource location path in application.properties of gam-addressing should be commented.

2:Using eclipse, execute maven goal spring-boot:build-image -DskipTests to generate the images.

![image](https://github.com/user-attachments/assets/2f1c29a3-3232-4900-a8d1-97ee5b02acec)


3: Open the docker desktop and check for the images. 

=====================================================================
 
# How to run Docker images.

Go to the directory, where docker-compose.yaml exist.

execute "docker compose up" command.

Below urls should work once everything is up.

To down the container use "docker compose down" command.

=====================================================================

# URL via Direct server code.

//for GAV

http://localhost:8181/addressing/verify/country/can/input/55%20Adelaide%20St%20E/city/Toronto/sp/%22%22/postCode/M5C%201K6

//for GTA

http://localhost:8181/addressing/predict/country/can/input/55%20Adelaide%20St%20E/city/Toronto/sp/%22%22/postCode/M5C%201K6



# Url to call from client code using feign client.

//for GAV

http://localhost:8081/gav-client/country/can/input/55%20abc/city/Toronto/sp/%22%22/postCode/M5C%20201K6

//for GTA

http://localhost:8081/gta-client/country/can/input/55%20abc/city/Toronto/sp/%22%22/postCode/M5C%20201K6


//For GAV via post

http://localhost:8081/gav-client-post


//For GTA via post

http://localhost:8081/gta-client-post


Sample json while calling things via post.

{"country": "IND", "input": "909 isai tola khati baba", "city": "Jhansi", "sp": "Uttar Pradesh", "postCode": "284003"}

![image](https://github.com/user-attachments/assets/8b8819f1-2565-4994-af39-0af407abe742)


# Using API Gateway

//for GAV

http://localhost:8766/gam-client/gav-client/country/can/input/55%20abc/city/Toronto/sp/%22%22/postCode/M5C%20201K6

//for GTA

http://localhost:8766/gam-client/gta-client/country/can/input/55%20abc/city/Toronto/sp/%22%22/postCode/M5C%20201K6

//for GAV via post

http://localhost:8766/gam-client/gav-client-post


//for GTA via post

http://localhost:8766/gam-client/gta-client-post




# To check hardcoded error message working

http://localhost:8766 /GAM-CLIENT/gam-client/usa/2507%20Ne%20Andresen%20%20Rd%20B/Vancouver/oo/999

