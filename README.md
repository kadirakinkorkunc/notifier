## About

This application retrieves ready to send messages from a data source and takes actions on it.

### Configurations
```
message.count-to-process-at-once = 2 # job will take this as record count to fetch
message.scheduler-fixed-rate-in-ms = 120000 # default to 2 min
message.sender.webhook-client = https://xyzt # webhook client 
```

### API
You can discover the API from the configured Swagger path
````
springdoc.swagger-ui.path=/swagger-ui.html
````

# How to run
You can use the docker-compose.yml that resides in the root of the project.

```
docker compose up -d
```