/*
 * Created on 2017-11-03 ( Time 15:03:35 )
 * Generated by Telosys Tools Generator ( version 3.0.0 )
 */
package org.demo.web.rest.jaxrs;

import java.util.LinkedList;
import java.util.List;

//--- Entities
import org.demo.data.record.EmployeeGroupRecord;
import org.demo.data.record.listitem.EmployeeGroupListItem;


//--- Services 
import org.demo.persistence.EmployeeGroupPersistence;
// import org.demo.business.service.impl.EmployeeGroupServiceImpl;
import org.demo.persistence.commons.PersistenceServiceProvider;
import org.demo.web.rest.commons.AbstractResourceController;



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
import javax.ws.rs.core.Response.Status;

/**
 * JAXRS Jersey controller for 'EmployeeGroup' management.
 */
@Path("/employeeGroup")
public class EmployeeGroupResource extends AbstractResourceController {

	private EmployeeGroupPersistence employeeGroupService = PersistenceServiceProvider.getService(EmployeeGroupPersistence.class);

	/**
	 * Constructor
	 */
	public EmployeeGroupResource() {
		super();
		logger.info("Constructor.");
	}

	/**
	 * Get all employeeGroup entities.
	 * @return list with all entities found
	 */
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<EmployeeGroupRecord> findAll() {
		logger.info("findAll()...");
		return employeeGroupService.findAll();
	}

	/**
	 * Retrieves a employeeGroup using the given id.
	 * @param employeeCode employeeCode
	 * @param groupId groupId
	 * @return 200 + body if found, 404 if not found 
	 */
	@GET
	@Path("{employeeCode}/{groupId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response findById(@PathParam("employeeCode") String employeeCode, @PathParam("groupId") Short groupId) {
		logger.info("findById("+employeeCode+groupId+")...");
		EmployeeGroupRecord record = employeeGroupService.findById(employeeCode, groupId);
		if ( record != null ) {
			return Response.ok(record).build();
		}
		else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	/**
	 * Creates a new employeeGroup.
	 * @param employeeGroup employeeGroup
	 * @return 201 with body if created, 409 conflict if duplicate key 
	 */	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response create(EmployeeGroupRecord employeeGroup) {
		logger.info("create()...");
		if ( employeeGroupService.exists(employeeGroup) ) {
			logger.info("create() : already exists -> conflict");
			return Response.status(Status.CONFLICT).build();
		}
		else {
			logger.info("create() : doesn't exist -> create");
			EmployeeGroupRecord record = employeeGroupService.create(employeeGroup);
			return Response.status(Status.CREATED).entity(record).build();
		}
	}

//------------------------------------------------------------
	/**
	 * Updates the employeeGroup identified by the given id
	 * @param employeeGroup employeeGroup entity
	 * @param employeeCode employeeCode 
	 * @param groupId groupId 
	 * @return 200 if found and updated, 404 if not found 
	 */	
	@PUT
	@Path("{employeeCode}/{groupId}")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	// public EmployeeGroupRecord update(EmployeeGroupRecord employeeGroup, @PathParam("employeeCode") String employeeCode, @PathParam("groupId") Short groupId) {
	public Response update(EmployeeGroupRecord employeeGroup, @PathParam("employeeCode") String employeeCode, @PathParam("groupId") Short groupId) {
		logger.info("update()...");
		// force the id (use the id provided by the URL)
		employeeGroup.setEmployeeCode( employeeCode );
		employeeGroup.setGroupId( groupId );
		boolean updated = employeeGroupService.update(employeeGroup);
		if ( updated ) {
			// Actually updated (found and updated) => 200 OK
			return Response.status(Status.OK).build();
		}
		else {
			// Not updated with no error => 404 not found
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	/**
	 * Save (create or update) the given employeeGroup.
	 * @param employeeGroup employeeGroup entity
	 * @return 200 if found and updated, 201 if not found and created
	 */	
	@PUT
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response save(EmployeeGroupRecord employeeGroup) {
		logger.info("save()...");
		Status status = Status.OK ; // 200 OK
		if ( ! employeeGroupService.exists(employeeGroup) ) {
			status = Status.CREATED ; // 201 CREATED
		}
		EmployeeGroupRecord record = employeeGroupService.save(employeeGroup);
		// Response ( code 200 or 201 )
		return Response.status(status).entity(record).build();
	}


//------------------------------------------------------------
	/**
	 * Delete a employeeGroup.
	 * @param employeeCode employeeCode
	 * @param groupId groupId
	 */
	@DELETE
	@Path("{employeeCode}/{groupId}")
	//@Consumes({MediaType.APPLICATION_JSON})
	// public void delete(@PathParam("employeeCode") String employeeCode, @PathParam("groupId") Short groupId) {
	public Response delete(@PathParam("employeeCode") String employeeCode, @PathParam("groupId") Short groupId) {
		logger.info("delete("+employeeCode+groupId+")...");
		// employeeGroupService.deleteById(employeeCode, groupId);
		boolean deleted = employeeGroupService.deleteById(employeeCode, groupId);
		if ( deleted ) {
			// Actually deleted (found and deleted) => 204 "No Content" because no body in the response 
			return Response.status(Status.NO_CONTENT).build();
		}
		else {
			// Not deleted with no error => 404 "Not found"
			return Response.status(Status.NOT_FOUND).build();
		}
}

	@GET
	@Path("/employeeGroups-list-items")
	@Produces({MediaType.APPLICATION_JSON})
	public List<EmployeeGroupListItem> listItems() {
		logger.info("listItems()...");
		List<EmployeeGroupRecord> list = employeeGroupService.findAll();
		List<EmployeeGroupListItem> items = new LinkedList<EmployeeGroupListItem>();
		for ( EmployeeGroupRecord employeeGroup : list ) {
			items.add(new EmployeeGroupListItem( employeeGroup ) );
		}
		return items;
	}

}
