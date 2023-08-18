
package resfulservices.crudrestfulservices;

import java.util.List;
import com.src.model.Student;
import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.src.service.*;
/** Example resource class hosted at the URI path "/myresource"
 */
@Path("/myresource")
public class MyResource {
    
    /** Method processing HTTP GET requests, producing "text/plain" MIME media
     * type.
     * @return String that will be send back as a response of type "text/plain".
     */
	
	private StudentServiceInterface ssi = new StudentService();
    @GET 
    @Produces("text/plain")
    @Path("/hi")
    public String getIt() {
        return "Hi there!";
    }
    
    @GET 
    @Produces("text/plain")
    @Path("/hello")
    public String getIt1() {
        return "Hello there!";
    }
    
    
    @GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("student")
	public List<Student> list() {
		return ssi.dispalyAllStudents();
	}
    
    @GET
	@Path("student/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") int id) {
		Student s = ssi.displayStudent(id);
		if (s != null) {
			return Response.ok(s, MediaType.APPLICATION_JSON).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
    
	@GET
	@Path("delete/{id}")
	public Response delete(@PathParam("id") int id) {
		if (ssi.deleteStudent(new Student(id))>0) {
			return Response.ok().build();					
		} else {
			return Response.notModified().build();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("update/{id}")
	public Response update(@PathParam("id") int id, Student s) {
		
		Student ss = new Student(s.getStdid(),s.getStdname(),s.getStdmobile(),s.getStdaddress(),s.getStdm1marks(),s.getStdm2marks(),s.getStdm3marks());

		
		if (ssi.editStudent(ss)>0) {
			return Response.ok().build();
		} else {
			return Response.notModified().build();
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("add")
	public Response add(Student s) throws URISyntaxException {
		Student ss = new Student(s.getStdid(),s.getStdname(),s.getStdmobile(),s.getStdaddress(),s.getStdm1marks(),s.getStdm2marks(),s.getStdm3marks());
		int newProductId = ssi.addStudent(ss);
		URI uri = new URI("/students/" + newProductId);
		return Response.created(uri).build();
	}
}
