package br.edu.fapce.api.resources;

import br.edu.fapce.api.exception.AppException;
import br.edu.fapce.api.model.Academico;
import br.edu.fapce.api.services.AcademicoService;
import br.edu.fapce.api.async.Assincrono;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;

@Path("/academico")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ConversorTemperaturaResource {

    AcademicoService service = new AcademicoService();

    @GET
    @RolesAllowed("ADMIN")
    @Path("/geral/matriculas")
    public void getMatriculasGeral(@Suspended final AsyncResponse async) throws AppException {
        Assincrono.timeout(async);

        new Thread(new Runnable() {
            @Override
            public void run() {
                async.resume(service.getMatriculasGeral());
            }
        }).start();
    }

    @GET
    @RolesAllowed("ADMIN")
    @Path("/curso/{codigo}/matriculas")
    public void getMatriculasCurso(@PathParam("codigo") final String codigo, @Suspended final AsyncResponse async) throws AppException {
        Assincrono.timeout(async);

        new Thread(new Runnable() {
            @Override
            public void run() {
                async.resume(service.getMatriculasPorCurso(codigo));
            }
        }).start();
    }

    @GET
    @RolesAllowed("ADMIN")
    @Path("/disciplina/{codigo}/matriculas")
    public void getMatriculasDisciplina(@PathParam("codigo") final String codigo, @Suspended final AsyncResponse async) throws AppException {
        Assincrono.timeout(async);

        new Thread(new Runnable() {
            @Override
            public void run() {
                async.resume(service.getMatriculasPorDisciplinas(codigo));
            }
        }).start();
    }

    @GET
    @RolesAllowed("ADMIN")
    @Path("/turma/{codigo}/matriculas")
    public void getMatriculasTurma(@PathParam("codigo") final String codigo, @Suspended final AsyncResponse async) throws AppException {
        Assincrono.timeout(async);

        new Thread(new Runnable() {
            @Override
            public void run() {
                async.resume(service.getMatriculasPorTurma(codigo));
            }
        }).start();
    }

    @GET
    @RolesAllowed("ADMIN")
    @Path("/turno/{codigo}/matriculas")
    public void getMatriculasTurno(@PathParam("codigo") final String codigo, @Suspended final AsyncResponse async) throws AppException {
        Assincrono.timeout(async);

        new Thread(new Runnable() {
            @Override
            public void run() {
                async.resume(service.getMatriculasPorTurno(codigo));
            }
        }).start();
    }

}
