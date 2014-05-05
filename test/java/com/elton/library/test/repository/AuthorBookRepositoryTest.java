/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package java.com.elton.library.test.repository;

import com.elton.library.app.conf.ConnectionConfig;
import com.elton.library.domain.Author;
import com.elton.library.domain.AuthorBook;
import com.elton.library.domain.Book;
import com.elton.library.repository.AuthorBookRepository;
import com.elton.library.domain.Name;
import com.elton.library.repository.AuthorRepository;
import com.elton.library.repository.BookRepository;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AuthorBookRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private Long authorId;
    private Author author;
    private Long bookId;
    private Book book;
    private AuthorBookRepository repo;
    private AuthorRepository repoAuthor;
    private BookRepository repoBook;
    
    
    public AuthorBookRepositoryTest() {
    }
    
    @Test
     public void createAuthorBook() {
         repoAuthor = ctx.getBean(AuthorRepository.class);
         author = new Author.Builder(new Name("Doe","John"))
                 .age(22)
                 .gender("Male")
                 .build();
         repoAuthor.save(author);
         long authorId = author.getId();
         
         repoBook = ctx.getBean(BookRepository.class);
         book = new Book.Builder("Stringetjie Blou Krale")
                 .isbn(new Long(1052158))
                 .available(true)
                 .build();
         repoBook.save(book);
         bookId = book.getId();
         
         repo = ctx.getBean(AuthorBookRepository.class);
         AuthorBook authorbook = new AuthorBook.Builder(book)
                 .author(author)
                 .build();
         repo.save(authorbook);
         id = authorbook.getId();
         Assert.assertNotNull(authorbook);
     }
     
     @Test(dependsOnMethods = "createAuthorBook")
     public void readAuthorBook(){
         repo = ctx.getBean(AuthorBookRepository.class);
         AuthorBook authorbook = repo.findOne(id);
         Book readAuthorBook = authorbook.getBook();
         Assert.assertEquals(readAuthorBook.getTitle(), "Stringetjie Blou Krale");
     }
     
    @Test(dependsOnMethods = "readAuthorBook")
     private void updateAuthorBookn(){
         repoAuthor = ctx.getBean(AuthorRepository.class);
         author = new Author.Builder(new Name("Doe","John"))
                 .age(43)
                 .gender("Male")
                 .build();
         repoAuthor.save(author);
        
         repo = ctx.getBean(AuthorBookRepository.class);
         AuthorBook authorbook = repo.findOne(id);
         AuthorBook updatedAuthorBook = new AuthorBook.Builder(book)
                 .author(author)
                 .build();
         repo.save(updatedAuthorBook);
         
         AuthorBook newAuthorBook = repo.findOne(id);
         Author updatedAuthor = newAuthorBook.getAuthor();
         Assert.assertEquals(updatedAuthor.getAge(), 43);
     }
     
     @Test(dependsOnMethods = "updateAuthorBookn")
     private void deleteAuthorBook(){
         repo = ctx.getBean(AuthorBookRepository.class);
         AuthorBook authorbook = repo.findOne(id);
         repo.delete(authorbook);
         
         AuthorBook deletedAuthorBook = repo.findOne(id);
         
         Assert.assertNull(deletedAuthorBook);     
     }
    
    @BeforeClass
    public static void setUpClass() {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
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