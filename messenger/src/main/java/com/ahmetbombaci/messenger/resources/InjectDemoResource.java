package com.ahmetbombaci.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectDemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

	/*
	@GET
	@Path("annotations")
	public String getParamsUsingAnnotations( @MatrixParam("param") String matrixParam 
										    ,@HeaderParam("custom-header-param") String customHeaderParam
											,@CookieParam("name") String cookie
											//,@FormParam("form-param") String formParam //when form posts
											) {
		return "Matrix param : " +matrixParam + "   Header param : " + customHeaderParam + "  cookie : " + cookie;
	}
	*/
	
	@GET
	@Path("context")
	public String getParamUsingContext(@Context UriInfo uriInfo
										,@Context HttpHeaders headers) {
		String queryParams =  uriInfo.getQueryParameters().values().toString();
		String absPath = uriInfo.getAbsolutePath().toString();
		String cookies = headers.getCookies().toString();
		return "Path:"+absPath+" query params:"+queryParams+" cookies:"+cookies;
	}
}