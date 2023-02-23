

# How to run

First add CoinMarketCap API key to docker-compose env

```bash
./mvnw clean
./mvnw package -Dmaven.test.skip
docker compose up
```

* kafka-ui on `localhost:8080`