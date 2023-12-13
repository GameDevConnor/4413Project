package restService;

import java.util.HashMap;
import java.util.List;

//import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
 

import model.*;

 

//this class is a simple implementation of a REST service
 

@Path("/Univ")
public class UnivServiceFront {

	 
	UniversityDB univDao;


	public UnivServiceFront() {
		this.univDao = new UniversityDB();
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
//	@Path("/rest/Univ")
	/* GET all the universities */
	// by  GET   /rest/Univ
	// return the collection of universities as JSON
	public List<University>  getAllUniversities() {
		return univDao.getAll();
	}
	
	

	/* GET all the provinces */
	// by  GET   /rest/Univ/provinces
	// return the collection of provinces, as JSON
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/provinces")
	public List<String> getProvinceNames() {
		
		return univDao.getAllProvince();
		 
	}
	

	// search university by code
	// by GET    /rest/Univ/searchByCode/searchCode
	// return the university, as JSON
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/searchByCode/{code}")
  	 public University getUnivByCode(@PathParam("code") String code) { 
		   return univDao.searchByCode(code);
  	 }
  	  
  	// search university by provinces
	// by GET  /rest/Univ/searchByProvince/provinceName
  	// return the list of universities, as JSON  
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/searchByProvince/{province}")
  	 public List<University> getUnivByProvince(@PathParam("province") String province) { 
		   return univDao.searchByProvince(province);

	 }
  	 
  	
  	// add a university by url parameter
	// by POST   /rest/Univ?code=XX&name=yy&province=pp&city=cc
	
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public void createUniv(@QueryParam("code") String code, @QueryParam("name") String name, 
			@QueryParam("province") String province, @QueryParam("city") String city) {
		
		univDao.addUniversity(code, name, province, city);
		 
	}
  	
	// delete a university by code
	// by DEETE   /rest/Univ/code
	 @DELETE
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{code}")
	public void deleteUniv(@PathParam("code") String code) {
		 univDao.removeUniversity(code);
	}


}
