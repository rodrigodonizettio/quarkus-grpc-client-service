package br.com.rodrigodonizettio.resource;

import br.com.rodrigodonizettio.PokemonGrpcRequestName;
import br.com.rodrigodonizettio.PokemonGrpcService;
import com.google.protobuf.AbstractMessage;
import io.quarkus.grpc.GrpcClient;
import io.smallrye.mutiny.Uni;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("pokemon-appear")
public class PokemonResource {
    @GrpcClient
    PokemonGrpcService pokemonGrpcService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{name}")
    public Uni<String> pokemonAppear(String name) {
        return pokemonGrpcService.pokemonGrpcAppear(
                PokemonGrpcRequestName.newBuilder()
                        .setName(name)
                        .build())
                .onItem().transform(AbstractMessage::toString
                );
    }
}
