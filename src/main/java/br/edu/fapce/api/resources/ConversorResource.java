package br.edu.fapce.api.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/conversor")
@Produces(MediaType.APPLICATION_JSON)
public class ConversorResource {

    @GET
    @Path("/celsius/{valor}/fahrenheit")
    public Response converteCelsiusForFahrenheit(@PathParam("valor") Double valor) {
        String conversao = "Conversão Celsius para Fahrenheit" + (valor * 1.8) + 32;
        return Response.status(200).entity(conversao).build();
    }

    @GET
    @Path("/fahrenheit/{valor}/celsius")
    public Response converteFahrenheitForCelsius(@PathParam("valor") Double valor) {
        String conversao = "Conversão Fahrenheit para Celsius -> " + (valor - 32) / 1.8;
        return Response.status(200).entity(conversao).build();
    }
} 