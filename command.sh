#Interact with API
docker compose up springapi
curl -X POST http://localhost:8080/account/123456/1000
curl http://localhost:8080/account/123456
curl -X POST http://localhost:8080/transfer/123456/654321/5  