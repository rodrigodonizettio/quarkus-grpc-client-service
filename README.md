# gRPC with Quarkus

This project uses the Quarkus gRPC dependency (quarkus-grpc) to establish communication between two applications (Client and Service) using gRPC.

## gRPC Service with Quarkus

Thanks to Quarkus gRPC dependency (quarkus-grpc), Maven generates during build step all Java gRPC classes based on the .proto file located in **src/main/proto**.

This application provides gRPC Service based on Mutiny (**MutinyPokemonService**) and also through the Default gRPC API Service (**PokemonService**).

## gRPC Client with Quarkus

Thanks to Quarkus gRPC dependency (quarkus-grpc), Maven generates during build step all Java gRPC classes based on the .proto file located in **src/main/proto**.

This application provides gRPC Client exposed by a REST API at the endpoint **http://localhost:8081/pokemon-appear/{name}** that calls the gRPC Service application.