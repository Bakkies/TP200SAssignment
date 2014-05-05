/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.com.elton.library.test.services;


import com.elton.library.app.conf.ConnectionConfig;
import com.elton.library.domain.Member;
import com.elton.library.domain.Name;
import com.elton.library.repository.MemberRepository;
import com.elton.library.services.MemberAgeService;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MemberAgeServiceTest {

    private static ApplicationContext ctx;
    private MemberAgeService memberAgeService;
    private MemberRepository memberRepository;

    public MemberAgeServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void getAgeofPeple() {
        memberRepository = ctx.getBean(MemberRepository.class);
        memberAgeService = ctx.getBean(MemberAgeService.class);
        
        Member m1 = new Member.Builder(new Name("Mills","Lana"))
                .age(5).build();
        Member m2 = new Member.Builder(new Name("Dube","Ben"))
                .age(12).build();
        Member m3 = new Member.Builder(new Name("Doe","John"))
                .age(16).build();

        memberRepository.save(m1);
        memberRepository.save(m2);
        memberRepository.save(m3);

        List<Member> members = memberAgeService.getMemberAbove(4);

        Assert.assertEquals(members.size(), 3);

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
       memberRepository = ctx.getBean(MemberRepository.class);
       memberRepository.deleteAll();
    }
}
