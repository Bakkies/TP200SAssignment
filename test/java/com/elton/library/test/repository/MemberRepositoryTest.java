/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package java.com.elton.library.test.repository;

import com.elton.library.domain.Member;
import com.elton.library.repository.MemberRepository;
import com.elton.library.domain.Name;
import static java.com.elton.library.test.repository.MemberRepositoryTest.ctx;
import java.sql.Date;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MemberRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private MemberRepository repo;
    
    public MemberRepositoryTest() {
    }
    
    @Test
     public void createMember() {
         repo = ctx.getBean(MemberRepository.class);
         Member member = new Member.Builder(new Name("Doe","Joe"))
                 .address("4 Hopestreet, Cape Town")
                 .startDate(new Date(2009-05-21))
                 .age(15)
                 .gender("Male")
                 .build();
         repo.save(member);
         id = member.getId();
         Assert.assertNotNull(member);
     }
     
     @Test(dependsOnMethods = "createMember")
     public void readMember(){
         repo = ctx.getBean(MemberRepository.class);
         Member member = repo.findOne(id);
         Name readMember = member.getName();
         Assert.assertEquals(readMember.getLastName(), "Doe");
     }
     
    @Test(dependsOnMethods = "readMember")
     private void updateMember(){
         repo = ctx.getBean(MemberRepository.class);
         Member member = repo.findOne(id);
         Member updatedMember = new Member.Builder(new Name("Doe","Joe"))
                 .member(member)
                 .age(43)
                 .build();
        
         repo.save(updatedMember);
         
         Member newMember = repo.findOne(id);
         Assert.assertEquals(newMember.getAge(), 43);
     }
     
     @Test(dependsOnMethods = "updateMember")
     private void deleteMember(){
         repo = ctx.getBean(MemberRepository.class);
         Member member = repo.findOne(id);
         repo.delete(member);
         
         Member deletedMember = repo.findOne(id);
         
         Assert.assertNull(deletedMember);     
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