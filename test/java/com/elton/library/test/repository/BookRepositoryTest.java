/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package java.com.elton.library.test.repository;

import com.elton.library.domain.Book;
import com.elton.library.repository.BookRepository;
import static java.com.elton.library.test.repository.BookRepositoryTest.ctx;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private BookRepository repo;
    
    
    public BookRepositoryTest() {
    }
    
    @Test
     public void createBook() {
         repo = ctx.getBean(BookRepository.class);
         Book book = new Book.Builder("Stringetjie Blou Krale")
                 .isbn(new Long(1052158))
                 .available(true)
                 .build();
         repo.save(book);
         id = book.getId();
         Assert.assertNotNull(book);
     }
     
     @Test(dependsOnMethods = "createBook")
     public void readBook(){
         repo = ctx.getBean(BookRepository.class);
         Book book = repo.findOne(id);
         Assert.assertEquals(book.getIsbn(), "1052158");
     }
     
    @Test(dependsOnMethods = "readBook")
     private void updateBook(){
         repo = ctx.getBean(BookRepository.class);
         Book book = repo.findOne(id);
         Book updatedBook = new Book.Builder("Stringetjie Blou Krale")
                 .book(book)
                 .isbn(new Long(105645))
                 .build();
        
         repo.save(updatedBook);
         Long newISbn = new Long(105645);
         Book newBook = repo.findOne(id);
         Assert.assertEquals(newBook.getIsbn(), newISbn);
     }
     
     @Test(dependsOnMethods = "updateBook")
     private void deleteBook(){
         repo = ctx.getBean(BookRepository.class);
         Book book = repo.findOne(id);
         repo.delete(book);
         
         Book deletedBook = repo.findOne(id);
         
         Assert.assertNull(deletedBook);     
     }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @BeforeMethod
    public void setUp() {
    }
    
    @AfterMethod
    public void tearDown() {
    }
}