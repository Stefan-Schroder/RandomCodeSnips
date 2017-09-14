/**
* @author Stefan Schroder
* @version 2016-09-19
*
* Testing SimpleLinkedList
*/

import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class SimpleLinkedListTest {
        /**
		* makes sure that the items added in from a list in the perameter are added in correctly,
		* in the right order and made sure not to contain any more items than it should
		*/
		@Test
        public void TestA(){
                String [] TestList = {"Hello","This","is","a","Test"};
                SimpleLinkedList<String> listOne = new SimpleLinkedList<String>(TestList);
                
                Iterator listIt = listOne.iterator();
                for (String s: TestList){
                        assertEquals("Test variable",s,listIt.next());
                }
                
                boolean hasError = false;
                try{
                        listIt.next();
                }catch(Exception e){
                        hasError = true;
                }
                
                assertTrue(hasError);
        }//
		
		/**
		* Tests to make sure that the items in the list added, are in the order that they are added in.
		* also makes sure that it returns -1 if item cannot be found
		*/
        @Test
        public void TestB(){
                SimpleLinkedList<String> listTwo = new SimpleLinkedList<String>();
                listTwo.add("Stefan");
                listTwo.add("John");
                listTwo.add("Elle");
                
                assertEquals(listTwo.indexOf("Jack"),-1);
                assertEquals(listTwo.indexOf("Stefan"),0);
                assertEquals(listTwo.indexOf("John"),1);
                assertEquals(listTwo.indexOf("Elle"),2);
        }//
        
		/**
		* Testing the remove function against a normal list.
		* also checks the insert and makes sure that the list it still in the order that it should be.
		*/
        @Test
        public void TestC(){
                String [] testArray = {"This","isnt","not","a","Test"};
                SimpleLinkedList<String> listThree = new SimpleLinkedList<String>(testArray);
                
                Iterator listIt = listThree.iterator();
                String [] testOneArray = {"This","isnt","a","Test"};
                listThree.removeAt(listThree.indexOf("not"));
                for(String s:testOneArray){
                        assertEquals(s,listIt.next());
                }
                
                String [] testTwoArray = {"This","is","a","Test"};
                listThree.remove("isnt");
                listThree.insert(1,"is");
                Iterator listIt2 = listThree.iterator();
                for(String s: testTwoArray){
                        assertEquals(s,listIt2.next());
                }
        }//
        
		/**
		* Testing the trim function with a normal list,
		* makes sure that all the items that are left int the list are saposed to be there.
		*/
        @Test
        public void TestD(){
                String [] testArray = {"This","is","a","test","but","this","will","be","the","last","one"};
                SimpleLinkedList<String> listFour = new SimpleLinkedList<String>(testArray);
                
                int sizeBefore = listFour.size();
                listFour.trimToSize(listFour.indexOf("but"));
                assertNotEquals(sizeBefore,listFour.size());
                
                String [] trimedList = new String[4];
                Iterator listIt = listFour.iterator();
                
                int listCounter = 0;
                while(listIt.hasNext()){
                        trimedList[listCounter] = listFour.get(listCounter);
                        //System.out.println(listIt.next());
                        listCounter++;
                }
                
                assertEquals(listCounter,4);
                
        }//
}
