package kasper.rest1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import jsonmappers.Person;

/**
 * REST Web Service
 *
 * @author Kasper
 */
@Path("person")
public class PersonResource {

    @Context
    private UriInfo context;
    private static Person p = new Person(0, "Kasper", "Ravn", "17285123");
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public PersonResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return gson.toJson(p);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String putJson(String content) {
        p = gson.fromJson(content, Person.class);
        return gson.toJson(p);
    }
}
