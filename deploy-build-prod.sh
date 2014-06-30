#!/bin/bash -e
for APINODE in 1 2 3 4 5 6 7 8 9 10 11 12
do
    API_HOST="cdn-img"${APINODE}".nm.flipkart.com"
    echo "Deploying build on "${API_HOST}
    ssh ${API_HOST} "sudo apt-get update; sudo apt-get install rukmini"
    echo "Deployed build on "${API_HOST}
done
echo "Done"
echo