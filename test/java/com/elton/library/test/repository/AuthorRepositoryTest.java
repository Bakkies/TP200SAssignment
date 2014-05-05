/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package java.com.elton.library.test.repository;

import com.elton.library.domain.Author;
import com.elton.library.repository.AuthorRepository;
import com.elton.library.domain.Name;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author 101Lenboxs
 */
public class AuthorRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private AuthorRepository repo;
    
    
    public AuthorRepositoryTest() {
    }
    
    @Test
     public void createAuthor() {
         repo = ctx.getBean(AuthorRepository.class);
         Author author = new Author.Builder(new Name("Doe","John"))
                 .age(22)
                 .gender("Male")
                 .build();
         repo.save(author);
         id = author.getId();
         Assert.assertNotNull(author);
     }
     
     @Test(dependsOnMethods = "createAuthor")
     public void readAuthor(){
         repo = ctx.getBean(AuthorRepository.class);
         Author author = repo.findOne(id);
         Name readAuthor = author.getName();
         Assert.assertEquals(readAuthor.getLastName(), "Doe");
     }
     
    @Test(dependsOnMethods = "readAuthor")
     private void updateAuthor(){
         repo = ctx.getBean(AuthorRepository.class);
         Author author = repo.findOne(id);
         Author updatedAuthor = new Author.Builder(new Name("Doe","John"))
                 .author(author)
                 .age(43)
                 .build();
        
         repo.save(updatedAuthor);
         
         Author newAuthor = repo.findOne(id);
         Assert.assertEquals(newAuthor.getAge(), 43);
     }
     
     @Test(dependsOnMethods = "updateAuthor")
     private void deleteAuthor(){
         repo = ctx.getBean(AuthorRepository.class);
         Author author = repo.findOne(id);
         repo.delete(author);
         
         Author deletedAuthor = repo.findOne(id);
         
         Assert.assertNull(deletedAuthor);     
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