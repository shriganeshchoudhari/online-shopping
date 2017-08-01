package net.km.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.km.shoppingbackend.dao.CategoryDAO;
import net.km.shoppingbackend.dto.Category;

public class CategoryTestCase {
	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.km.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	// @Test
	// public void testAddCategory() {
	//
	// category = new Category();
	//
	// category.setName("mobile");
	// category.setDescription("desctiption2");
	// category.setImageURL("Cat2_png");
	//
	// assertEquals("something wrong added a category inside the table!", true,
	// categoryDAO.add(category));
	//
	// }

	// @Test
	// public void testGetCategory() {
	// category=categoryDAO.get(2);
	//
	// assertEquals("something wrong fetched a single category from the table!",
	// "Television", category.getName());
	// }

	/*
	 * @Test public void testUpdateCategory() { category = categoryDAO.get(2);
	 * category.setName("TV");
	 * 
	 * assertEquals("something wrong updated a single category in the table!", true,
	 * categoryDAO.update(category)); }
	 */
	/*
	 * @Test public void testDeleteCategory() {
	 * 
	 * category = categoryDAO.get(4);
	 * assertEquals("something wrong deleted a single category in the table!", true,
	 * categoryDAO.delete(category));
	 * 
	 * }
	 */

	/*@Test
	public void testListCategory() {

		assertEquals("something wrong fetched the list of categories from the table!", 3, categoryDAO.list().size());

	}
*/
	@Test
	public void testCRUDCategory() {
		
		// add operation
		category = new Category();
		
		category.setName("Laptop");
		category.setDescription("This is some description for laptop!");
		category.setImageURL("CAT_1.png");
		
		assertEquals("something wrong added a category inside the table!",true,categoryDAO.add(category));
		
		
		category = new Category();
		
		category.setName("Television");
		category.setDescription("This is some description for television!");
		category.setImageURL("CAT_2.png");
		
		assertEquals("something wrong added a category inside the table!",true,categoryDAO.add(category));

		
		// fetching and updating the category
		category = categoryDAO.get(2);
		
		category.setName("TV");
		
		assertEquals("something wrong updated a single category in the table!",true,categoryDAO.update(category));
		
		
		// delete the category
		assertEquals("something wrong deleted a single category in the table!",true,categoryDAO.delete(category));
		
		
		//fetching the list
		assertEquals("something wrong fetched the list of categories from the table!",1,categoryDAO.list().size());		
				
		
	}
	
}
