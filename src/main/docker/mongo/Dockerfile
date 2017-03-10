FROM mongo
COPY mongo_db_dump.json /mongo_db_dump.json
CMD mongoimport --host mongodb --db portal --collection students --type json --file /mongo_db_dump.json --jsonArray