#!/bin/bash
echo "*** Building app ..."
./mvnw clean package
echo "*** Selecting the production space in epa-ccte organization..."
cf target -o epa-ccte -s prod
echo "*** Deleting previous app instance..."
cf delete -f -r ccte-exposure-prod
echo "*** Pushing the app with stg manifest file..."
cf push -f manifest-prod.yml --no-start
echo "*** Binding the database service to the app..."
cf bind-service ccte-exposure-prod ccte-db-prod2
echo "*** Restaging the app to enable the server connection..."
cf restage ccte-exposure-prod
echo "*** Showing recent logs of the app..."
cf logs ccte-exposure-prod --recent
