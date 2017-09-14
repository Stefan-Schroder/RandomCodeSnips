import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class CSC1016STest {
        CSC1016S student1 = new CSC1016S();
        
        @Before 
        public void TestASetup(){
                student1.setName("Marry");
        }
        
        @Test 
        public void TestA() {
                Assert.assertEquals( "Marry", student1.getName());
                Assert.assertEquals( 0.0f , student1.getFinal(),0.001);
        }
        
        @Test 
        public void TestB(){
                student1.setName("Elle");
                student1.setMark("pracs",100);
                student1.setMark("practests",100);
                student1.setMark("tests",100);
                student1.setMark("exam",100);
                assertEquals(100.0f, student1.getFinal(),0.001);
                assertNotEquals("Marry",student1.getName());
        }
        
        @Test 
        public void TestC(){
                student1.setName("John");
                student1.setMark("pracs",100);
                student1.setMark("practests",0);
                student1.setMark("tests",50);
                student1.setMark("exam",50);
                assertEquals(50.0f,student1.getFinal(),0.001);
        }
}
