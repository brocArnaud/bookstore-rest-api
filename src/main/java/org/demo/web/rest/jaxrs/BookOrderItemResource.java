/*
 * Created on 2017-11-03 ( Time 15:03:35 )
 * Generated by Telosys Tools Generator ( version 3.0.0 )
 */
package org.demo.web.rest.jaxrs;

import java.util.LinkedList;
import java.util.List;

//--- Entities
import org.demo.data.record.BookOrderItemRecord;
import org.demo.data.record.listitem.BookOrderItemListItem;


//--- Services 
import org.demo.persistence.BookOrderItemPersistence;
// import org.demo.business.service.impl.BookOrderItemServiceImpl;
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
 * JAXRS Jersey controller for 'BookOrderItem' management.
 */
@Path("/bookOrderItem")
public class BookOrderItemResource extends AbstractResourceController {

	private BookOrderItemPersistence bookOrderItemService = PersistenceServiceProvider.getService(BookOrderItemPersistence.class);

	/**
	 * Constructor
	 */
	public BookOrderItemResource() {
		super();
		logger.info("Constructor.");
	}

	/**
	 * Get all bookOrderItem entities.
	 * @return list with all entities found
	 */
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<BookOrderItemRecord> findAll() {
		logger.info("findAll()...");
		return bookOrderItemService.findAll();
	}

	/**
	 * Retrieves a bookOrderItem using the given id.
	 * @param bookOrderId bookOrderId
	 * @param bookId bookId
	 * @return 200 + body if found, 404 if not found 
	 */
	@GET
	@Path("{bookOrderId}/{bookId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response findById(@PathParam("bookOrderId") Integer bookOrderId, @PathParam("bookId") Integer bookId) {
		logger.info("findById("+bookOrderId+bookId+")...");
		BookOrderItemRecord record = bookOrderItemService.findById(bookOrderId, bookId);
		if ( record != null ) {
			return Response.ok(record).build();
		}
		else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	/**
	 * Creates a new bookOrderItem.
	 * @param bookOrderItem bookOrderItem
	 * @return 201 with body if created, 409 conflict if duplicate key 
	 */	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response create(BookOrderItemRecord bookOrderItem) {
		logger.info("create()...");
		if ( bookOrderItemService.exists(bookOrderItem) ) {
			logger.info("create() : already exists -> conflict");
			return Response.status(Status.CONFLICT).build();
		}
		else {
			logger.info("create() : doesn't exist -> create");
			BookOrderItemRecord record = bookOrderItemService.create(bookOrderItem);
			return Response.status(Status.CREATED).entity(record).build();
		}
	}

//------------------------------------------------------------
	/**
	 * Updates the bookOrderItem identified by the given id
	 * @param bookOrderItem bookOrderItem entity
	 * @param bookOrderId bookOrderId 
	 * @param bookId bookId 
	 * @return 200 if found and updated, 404 if not found 
	 */	
	@PUT
	@Path("{bookOrderId}/{bookId}")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	// public BookOrderItemRecord update(BookOrderItemRecord bookOrderItem, @PathParam("bookOrderId") Integer bookOrderId, @PathParam("bookId") Integer bookId) {
	public Response update(BookOrderItemRecord bookOrderItem, @PathParam("bookOrderId") Integer bookOrderId, @PathParam("bookId") Integer bookId) {
		logger.info("update()...");
		// force the id (use the id provided by the URL)
		bookOrderItem.setBookOrderId( bookOrderId );
		bookOrderItem.setBookId( bookId );
		boolean updated = bookOrderItemService.update(bookOrderItem);
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
	 * Save (create or update) the given bookOrderItem.
	 * @param bookOrderItem bookOrderItem entity
	 * @return 200 if found and updated, 201 if not found and created
	 */	
	@PUT
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response save(BookOrderItemRecord bookOrderItem) {
		logger.info("save()...");
		Status status = Status.OK ; // 200 OK
		if ( ! bookOrderItemService.exists(bookOrderItem) ) {
			status = Status.CREATED ; // 201 CREATED
		}
		BookOrderItemRecord record = bookOrderItemService.save(bookOrderItem);
		// Response ( code 200 or 201 )
		return Response.status(status).entity(record).build();
	}


//------------------------------------------------------------
	/**
	 * Delete a bookOrderItem.
	 * @param bookOrderId bookOrderId
	 * @param bookId bookId
	 */
	@DELETE
	@Path("{bookOrderId}/{bookId}")
	//@Consumes({MediaType.APPLICATION_JSON})
	// public void delete(@PathParam("bookOrderId") Integer bookOrderId, @PathParam("bookId") Integer bookId) {
	public Response delete(@PathParam("bookOrderId") Integer bookOrderId, @PathParam("bookId") Integer bookId) {
		logger.info("delete("+bookOrderId+bookId+")...");
		// bookOrderItemService.deleteById(bookOrderId, bookId);
		boolean deleted = bookOrderItemService.deleteById(bookOrderId, bookId);
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
	@Path("/bookOrderItems-list-items")
	@Produces({MediaType.APPLICATION_JSON})
	public List<BookOrderItemListItem> listItems() {
		logger.info("listItems()...");
		List<BookOrderItemRecord> list = bookOrderItemService.findAll();
		List<BookOrderItemListItem> items = new LinkedList<BookOrderItemListItem>();
		for ( BookOrderItemRecord bookOrderItem : list ) {
			items.add(new BookOrderItemListItem( bookOrderItem ) );
		}
		return items;
	}

}
