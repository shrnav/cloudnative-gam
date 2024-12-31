# cloudnative-gam-jdk21
Application on top of GA-SDK

# Image names pushed in docker: Just use docker compose file to run.

navneet204/mmv3-gam-addressing:0.0.1-SNAPSHOT
navneet204/mmv3-gam-client:0.0.1-SNAPSHOT
navneet204/mmv3-gam-gateway:0.0.1-SNAPSHOT
navneet204/mmv3-gam-naming-server:0.0.1-SNAPSHOT
===============================================================================


# Direst server code.
//for GAV
http://localhost:8181/addressing/verify/country/can/input/55%20Adelaide%20St%20E/city/Toronto/sp/%22%22/postCode/M5C%201K6
//for GTA
http://localhost:8181/addressing/predict/country/can/input/55%20Adelaide%20St%20E/city/Toronto/sp/%22%22/postCode/M5C%201K6



# Url to call from client code using feign client.
//for GAV
http://localhost:8081/gav-client/country/can/input/55%20abc/city/Toronto/sp/%22%22/postCode/M5C%20201K6
for GTA
http://localhost:8081/gta-client/country/can/input/55%20abc/city/Toronto/sp/%22%22/postCode/M5C%20201K6




# Using API Gateway
//for GAV
http://localhost:8766/gam-client/gav-client/country/can/input/55%20abc/city/Toronto/sp/%22%22/postCode/M5C%20201K6
//for GTA
http://localhost:8766/gam-client/gta-client/country/can/input/55%20abc/city/Toronto/sp/%22%22/postCode/M5C%20201K6

To check harcodeed error message working
http://localhost:8766 /GAM-CLIENT/gam-client/usa/2507%20Ne%20Andresen%20%20Rd%20B/Vancouver/oo/999

