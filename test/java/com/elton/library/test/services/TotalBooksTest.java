/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package java.com.elton.library.test.services;


import com.elton.library.app.conf.ConnectionConfig;
import com.elton.library.domain.Book;
import com.elton.library.services.TotalBooksService;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TotalBooksTest {
        public static ApplicationContext ctx;
    

    private TotalBooksService service;
    
    public TotalBooksTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void total() {
         service = ctx.getBean(TotalBooksService.class);
         List<Book> books = service.getTotalBooks();
         
         Assert.assertEquals(0, books.size(), " No Books");
     }

    @BeforeClass
    public static void setUpClass() throws Exception {
         ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
