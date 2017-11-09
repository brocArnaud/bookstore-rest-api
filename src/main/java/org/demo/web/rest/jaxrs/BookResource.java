/*
 * Created on 2017-11-09 ( Time 10:27:49 )
 * Generated by Telosys Tools Generator ( version 3.0.0 )
 */
package org.demo.web.rest.jaxrs;

import java.util.LinkedList;
import java.util.List;

//--- Entities
import org.demo.data.record.BookRecord;
import org.demo.data.record.listitem.BookListItem;


//--- Services 
import org.demo.persistence.BookPersistence;
// import org.demo.business.service.impl.BookServiceImpl;
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
 * JAXRS Jersey controller for 'Book' management.
 */
@Path("/book")
public class BookResource extends AbstractResourceController {

	private BookPersistence bookService = PersistenceServiceProvider.getService(BookPersistence.class);

	/**
	 * Constructor
	 */
	public BookResource() {
		super();
		logger.info("Constructor.");
	}

	/**
	 * Get all book entities.
	 * @return list with all entities found
	 */
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<BookRecord> findAll() {
		logger.info("findAll()...");
		return bookService.findAll();
	}

	/**
	 * Retrieves a book using the given id.
	 * @param id id
	 * @return 200 + body if found, 404 if not found 
	 */
	@GET
	@Path("{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response findById(@PathParam("id") Integer id) {
		logger.info("findById("+id+")...");
		BookRecord record = bookService.findById(id);
		if ( record != null ) {
			return Response.ok(record).build();
		}
		else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	/**
	 * Creates a new book.
	 * @param book book
	 * @return 201 with body if created, 409 conflict if duplicate key 
	 */	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response create(BookRecord book) {
		logger.info("create()...");
		if ( bookService.exists(book) ) {
			logger.info("create() : already exists -> conflict");
			return Response.status(Status.CONFLICT).build();
		}
		else {
			logger.info("create() : doesn't exist -> create");
			BookRecord record = bookService.create(book);
			return Response.status(Status.CREATED).entity(record).build();
		}
	}

//------------------------------------------------------------
	/**
	 * Updates the book identified by the given id
	 * @param book book entity
	 * @param id id 
	 * @return 200 if found and updated, 404 if not found 
	 */	
	@PUT
	@Path("{id}")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	// public BookRecord update(BookRecord book, @PathParam("id") Integer id) {
	public Response update(BookRecord book, @PathParam("id") Integer id) {
		logger.info("update()...");
		// force the id (use the id provided by the URL)
		book.setId( id );
		boolean updated = bookService.update(book);
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
	 * Save (create or update) the given book.
	 * @param book book entity
	 * @return 200 if found and updated, 201 if not found and created
	 */	
	@PUT
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response save(BookRecord book) {
		logger.info("save()...");
		Status status = Status.OK ; // 200 OK
		if ( ! bookService.exists(book) ) {
			status = Status.CREATED ; // 201 CREATED
		}
		BookRecord record = bookService.save(book);
		// Response ( code 200 or 201 )
		return Response.status(status).entity(record).build();
	}


//------------------------------------------------------------
	/**
	 * Delete a book.
	 * @param id id
	 */
	@DELETE
	@Path("{id}")
	//@Consumes({MediaType.APPLICATION_JSON})
	// public void delete(@PathParam("id") Integer id) {
	public Response delete(@PathParam("id") Integer id) {
		logger.info("delete("+id+")...");
		// bookService.deleteById(id);
		boolean deleted = bookService.deleteById(id);
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
	@Path("/books-list-items")
	@Produces({MediaType.APPLICATION_JSON})
	public List<BookListItem> listItems() {
		logger.info("listItems()...");
		List<BookRecord> list = bookService.findAll();
		List<BookListItem> items = new LinkedList<BookListItem>();
		for ( BookRecord book : list ) {
			items.add(new BookListItem( book ) );
		}
		return items;
	}

}
