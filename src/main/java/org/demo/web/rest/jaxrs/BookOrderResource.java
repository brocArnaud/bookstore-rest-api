/*
 * Created on 2017-11-03 ( Time 15:03:35 )
 * Generated by Telosys Tools Generator ( version 3.0.0 )
 */
package org.demo.web.rest.jaxrs;

import java.util.LinkedList;
import java.util.List;

//--- Entities
import org.demo.data.record.BookOrderRecord;
import org.demo.data.record.listitem.BookOrderListItem;


//--- Services 
import org.demo.persistence.BookOrderPersistence;
// import org.demo.business.service.impl.BookOrderServiceImpl;
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
 * JAXRS Jersey controller for 'BookOrder' management.
 */
@Path("/bookOrder")
public class BookOrderResource extends AbstractResourceController {

	private BookOrderPersistence bookOrderService = PersistenceServiceProvider.getService(BookOrderPersistence.class);

	/**
	 * Constructor
	 */
	public BookOrderResource() {
		super();
		logger.info("Constructor.");
	}

	/**
	 * Get all bookOrder entities.
	 * @return list with all entities found
	 */
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<BookOrderRecord> findAll() {
		logger.info("findAll()...");
		return bookOrderService.findAll();
	}

	/**
	 * Retrieves a bookOrder using the given id.
	 * @param id id
	 * @return 200 + body if found, 404 if not found 
	 */
	@GET
	@Path("{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response findById(@PathParam("id") Integer id) {
		logger.info("findById("+id+")...");
		BookOrderRecord record = bookOrderService.findById(id);
		if ( record != null ) {
			return Response.ok(record).build();
		}
		else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	/**
	 * Creates a new bookOrder.
	 * @param bookOrder bookOrder
	 * @return 201 with body if created, 409 conflict if duplicate key 
	 */	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response create(BookOrderRecord bookOrder) {
		logger.info("create()...");
		if ( bookOrderService.exists(bookOrder) ) {
			logger.info("create() : already exists -> conflict");
			return Response.status(Status.CONFLICT).build();
		}
		else {
			logger.info("create() : doesn't exist -> create");
			BookOrderRecord record = bookOrderService.create(bookOrder);
			return Response.status(Status.CREATED).entity(record).build();
		}
	}

//------------------------------------------------------------
	/**
	 * Updates the bookOrder identified by the given id
	 * @param bookOrder bookOrder entity
	 * @param id id 
	 * @return 200 if found and updated, 404 if not found 
	 */	
	@PUT
	@Path("{id}")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	// public BookOrderRecord update(BookOrderRecord bookOrder, @PathParam("id") Integer id) {
	public Response update(BookOrderRecord bookOrder, @PathParam("id") Integer id) {
		logger.info("update()...");
		// force the id (use the id provided by the URL)
		bookOrder.setId( id );
		boolean updated = bookOrderService.update(bookOrder);
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
	 * Save (create or update) the given bookOrder.
	 * @param bookOrder bookOrder entity
	 * @return 200 if found and updated, 201 if not found and created
	 */	
	@PUT
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response save(BookOrderRecord bookOrder) {
		logger.info("save()...");
		Status status = Status.OK ; // 200 OK
		if ( ! bookOrderService.exists(bookOrder) ) {
			status = Status.CREATED ; // 201 CREATED
		}
		BookOrderRecord record = bookOrderService.save(bookOrder);
		// Response ( code 200 or 201 )
		return Response.status(status).entity(record).build();
	}


//------------------------------------------------------------
	/**
	 * Delete a bookOrder.
	 * @param id id
	 */
	@DELETE
	@Path("{id}")
	//@Consumes({MediaType.APPLICATION_JSON})
	// public void delete(@PathParam("id") Integer id) {
	public Response delete(@PathParam("id") Integer id) {
		logger.info("delete("+id+")...");
		// bookOrderService.deleteById(id);
		boolean deleted = bookOrderService.deleteById(id);
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
	@Path("/bookOrders-list-items")
	@Produces({MediaType.APPLICATION_JSON})
	public List<BookOrderListItem> listItems() {
		logger.info("listItems()...");
		List<BookOrderRecord> list = bookOrderService.findAll();
		List<BookOrderListItem> items = new LinkedList<BookOrderListItem>();
		for ( BookOrderRecord bookOrder : list ) {
			items.add(new BookOrderListItem( bookOrder ) );
		}
		return items;
	}

}