class JUnits{
	/*
	testing the smallest usable parts.
	
	advantages:
	-fast
	-more reliable/preciese
	-requires less human reasources
	
	JUnit:
	is an automated unit testing framework for java
	promotes 'first test then code' principles
	
	test case is characterised by:
	- known input:
		precondition
	- expected output
		post-condition
	there must be one positive and negitive test case.

	how to set up:
		download JUnit and hamcrest jar files... figure it out cuz they are using jgrasp
	
	Why use JUnit:
	-it is open source
	-provides annotations to identifu test methods
	-provides assertions for testing expected results
	-provides test runners
	-provides immediate feedback and progress during testing, can flag pass or fail.
	
	annotations:
	-@Test - the public void method can be run as a test case
	-@Before - the method must be run before each test method
	-@BeforeClass - the static method must be run once before any of the test methods in the class
	-@After -  the method must be run after each test case
	-@AfterClass - after all the test cases have been run
	
	assertEquals([message],expected value, actual value)
	assertTrue([message], boolean condition)
	assertFaslse([message], boolean false)
	assertNotNull([message], makes sure its not null)
	assertNull([message], object)
	assertSame([message], object,object)
	assertNotEquals([message])
	
	-setUp()-runs before every test invocation
	-tearDown()-runs after every test
	
	*/
	
	/*
	imports:
	import org.junit.Assert;
	import static org.junit.Assert.*;
	import org.junit.Beefore;
	import org.junit.Test;
	Examples:
	@Before public void setUp(){
		//test the class declerations
	}
	@Test pubic void testGreeting(){
		Tutor t = new Tutor("John",22);
		assertEquals(t.toString(),"holla");
	}
	
	
	
	*/
}