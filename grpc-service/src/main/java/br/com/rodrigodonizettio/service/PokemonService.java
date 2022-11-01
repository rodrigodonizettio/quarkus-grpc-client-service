package br.com.rodrigodonizettio.service;

import br.com.rodrigodonizettio.PokemonGrpc;
import br.com.rodrigodonizettio.PokemonGrpcRequestName;
import br.com.rodrigodonizettio.PokemonGrpcServiceGrpc;
import io.grpc.stub.StreamObserver;
import io.quarkus.grpc.GrpcService;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

//NOTE: Enable the lines below to use the Default gRPC API Service
//@GrpcService
//public class PokemonService extends PokemonGrpcServiceGrpc.PokemonGrpcServiceImplBase {
public class PokemonService {

    public void pokemonGrpcAppear(PokemonGrpcRequestName request, StreamObserver<PokemonGrpc> responseObserver) {
        String uuidString = UUID.randomUUID().toString();
        int height = ThreadLocalRandom.current().nextInt(1, 201);
        int weight = height / 2;

        responseObserver.onNext(
                PokemonGrpc.newBuilder()
                        .setUuid(uuidString)
                        .setName(String.format("%s using Default gRPC API", request.getName()))
                        .setHeight(height)
                        .setWeight(weight)
                        .build()
        );
        responseObserver.onCompleted();
    }
}