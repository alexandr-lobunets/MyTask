FROM mongo

COPY students.json /students.json
CMD mongoimport --host mongodb --db portal --collection students --type json --file /students.json --jsonArray