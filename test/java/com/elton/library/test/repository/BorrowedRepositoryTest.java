/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package java.com.elton.library.test.repository;

import com.elton.library.domain.Book;
import com.elton.library.domain.Borrowed;
import com.elton.library.domain.Member;
import com.elton.library.repository.BorrowedRepository;
import com.elton.library.domain.Name;
import com.elton.library.repository.BookRepository;
import com.elton.library.repository.MemberRepository;
import static java.com.elton.library.test.repository.BorrowedRepositoryTest.ctx;
import static java.com.elton.library.test.repository.MemberRepositoryTest.ctx;
import java.sql.Date;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BorrowedRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private BorrowedRepository repo;
    private Long bookId;
    private Book book;
    private Long memberId;
    private Member member; 
    private BookRepository repoBook;
    private MemberRepository repoMember; 
    
    public BorrowedRepositoryTest() {
    }
    
    @Test
     public void createBorrowed() {
         repoBook = ctx.getBean(BookRepository.class);
         book = new Book.Builder("Stringetjie Blou Krale")
                 .isbn(new Long(1052158))
                 .available(true)
                 .build();
         repoBook.save(book);
         bookId = book.getId();
         
         repoMember = ctx.getBean(MemberRepository.class);
         member = new Member.Builder(new Name("Doe","Joe"))
                 .address("4 Hopestreet, Cape Town")
                 .startDate(new Date(2009-05-21))
                 .age(15)
                 .gender("Male")
                 .build();
         repo.save(member);
         id = member.getId();
        
         repo = ctx.getBean(BorrowedRepository.class);
         Borrowed borrowed = new Borrowed.Builder(book)
                 .date(new Date(2014-05-1))
                 .dueDate(new Date(2014-05-14))
                 .member(member)
                 .build();
         repo.save(borrowed);
         id = borrowed.getId();
         Assert.assertNotNull(borrowed);
     }
     
     @Test(dependsOnMethods = "createBorrowed")
     public void readBorrowed(){
         repo = ctx.getBean(BorrowedRepository.class);
         Borrowed borrowed = repo.findOne(id);
         Name readBorrowed = borrowed.getName();
         Assert.assertEquals(readBorrowed.getLastName(), "Doe");
     }
     
    @Test(dependsOnMethods = "readBorrowed")
     private void updateBorrowed(){
         repo = ctx.getBean(BorrowedRepository.class);
         Borrowed borrowed = repo.findOne(id);
         Borrowed updatedBorrowed = new Borrowed.Builder(new Name("Doe","John"))
                 .borrowed(borrowed)
                 .dueDate(new Date(2014-05-15))
                 .build();
        
         repo.save(updatedBorrowed);
         
         Borrowed newBorrowed = repo.findOne(id);
         Assert.assertEquals(newBorrowed.getDueDate(), 15);
     }
     
     @Test(dependsOnMethods = "updateBorrowed")
     private void deleteBorrowed(){
         repo = ctx.getBean(BorrowedRepository.class);
         Borrowed borrowed = repo.findOne(id);
         repo.delete(borrowed);
         
         Borrowed deletedBorrowed = repo.findOne(id);
         
         Assert.assertNull(deletedBorrowed);     
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