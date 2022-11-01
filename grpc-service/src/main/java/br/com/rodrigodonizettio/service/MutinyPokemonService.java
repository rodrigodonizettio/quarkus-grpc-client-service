package br.com.rodrigodonizettio.service;

import br.com.rodrigodonizettio.PokemonGrpc;
import br.com.rodrigodonizettio.PokemonGrpcRequestName;
import br.com.rodrigodonizettio.PokemonGrpcService;
import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Uni;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@GrpcService
public class MutinyPokemonService implements PokemonGrpcService {

    @Override
    public Uni<PokemonGrpc> pokemonGrpcAppear(PokemonGrpcRequestName request) {
        String uuidString = UUID.randomUUID().toString();
        int height = ThreadLocalRandom.current().nextInt(1, 201);
        int weight = height / 2;

        return Uni.createFrom().item(() ->
                PokemonGrpc.newBuilder()
                        .setUuid(uuidString)
                        .setName(String.format("%s using Mutiny", request.getName()))
                        .setHeight(height)
                        .setWeight(weight)
                        .build()
        );
    }
}