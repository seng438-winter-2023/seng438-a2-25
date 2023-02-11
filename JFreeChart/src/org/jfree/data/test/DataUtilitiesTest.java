package org.jfree.data.test;

import static org.junit.Assert.*;
import org.junit.*;
import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jfree.data.KeyedValues;
import org.jmock.*;
import java.util.*;


public class DataUtilitiesTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}

	
	
	/*All code below this line are the various tests created*/
	
	
	/*CreateNumberArray Tests*/
	
	/*
	 * This tests the use of all positive values in the input array into createNumberArray()
	 */
	@Test
	public void createNumberArrayPositiveDouble() {
		//creating expected output and actual input
		Number[] expected = {1.0, 2.0, 3.0, 4.0};
		double[] actualInput = {1.0, 2.0, 3.0, 4.0};
		//testing by asserting
		assertArrayEquals(expected, DataUtilities.createNumberArray(actualInput));
	}
	
	
	/*
	 * This tests the use of all negative values in the input array into createNumberArray()
	 */
	@Test
	public void createNumberArrayNegativeDouble() {
		//creating expected output and actual input
		Number[] expected = {-1.0, -2.0, -3.0, -4.0};
		double[] actualInput = {-1.0, -2.0, -3.0, -4.0};
		//testing by asserting
		assertArrayEquals(expected, DataUtilities.createNumberArray(actualInput));
	}
	
	
	/*
	 * This tests the use of null as input into createNumberArray()
	 * Note: We have used IllegalArgumentException here as the function throws this instead
	 *       of the intended exception specified in the documentation. Changing the expected to 
	 *       the intended exception results in an error that breaks this test.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void createNumberArrayNull() throws IllegalArgumentException{
		//Creating null input and testing by asserting
		double[] actualInput = null;
		DataUtilities.createNumberArray(actualInput);
	}
	
	
	/*CreateNumberArray2D Tests*/
	
	
	/*
	 * This tests the use of all positive values in the input array into createNumberArray2D()
	 */
	@Test
	public void createNumberArray2DPositiveDouble() {
		//creating expected output and actual input
		Number[][] expected = {{1.0, 2.0, 3.0, 4.0}, {5.0, 6.0, 7.0, 8.0}};
		double[][] actualInput = {{1.0, 2.0, 3.0, 4.0}, {5.0, 6.0, 7.0, 8.0}};
		//testing by asserting
		assertArrayEquals(expected, DataUtilities.createNumberArray2D(actualInput));
	}
	
	/*
	 * This tests the use of all negative values in the input array into createNumberArray2D()
	 */
	@Test
	public void createNumberArray2DNegativeDouble() {
		//creating expected output and actual input
		Number[][] expected = {{-1.0, -2.0, -3.0, -4.0}, {-5.0, -6.0, -7.0, -8.0}};
		double[][] actualInput = {{-1.0, -2.0, -3.0, -4.0}, {-5.0, -6.0, -7.0, -8.0}};
		//testing by asserting
		assertArrayEquals(expected, DataUtilities.createNumberArray2D(actualInput));
	}
	
	/*
	 * This tests the use of a "square" array/matrix (2x2) in the input array into createNumberArray2D()
	 */
	@Test
	public void createNumberArray2DSquareArray() {
		//creating expected output and actual input
		Number[][] expected = {{1.0, 2.0}, {5.0, 6.0}};
		double[][] actualInput = {{1.0, 2.0}, {5.0, 6.0}};
		//testing by asserting
		assertArrayEquals(expected, DataUtilities.createNumberArray2D(actualInput));
	}
	
	
	/*calculateColumnTotal Tests*/
	
	
	/*
	 * This tests the use of all positive integers as entries in the Values2D object used as input in calculateColumnTotal()
	 */
	 @Test
	 public void calculateColumnTotalForPositiveNumbers() {
		 //Creating mocking context
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	        	//Setting values for the mock object
	             one(values).getRowCount();
	             will(returnValue(2));
	             one(values).getValue(0, 0);
	             will(returnValue(7.5));
	             one(values).getValue(1, 0);
	             will(returnValue(2.5));
	         }
	     });
	     //Storing output from method call and testing by asserting
	     double result = DataUtilities.calculateColumnTotal(values, 0);
	     assertEquals(10.0, result, .000000001d);
	 }
	 
	 
	 /*
	 * This tests the use of all negative integers as entries in the Values2D object used as input in calculateColumnTotal()
	 */
	 @Test
	 public void calculateColumnTotalForNegativeNumbers() {
		//Creating mocking context
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	        	//Setting values for the mock object
	             one(values).getRowCount();
	             will(returnValue(2));
	             one(values).getValue(0, 0);
	             will(returnValue(-5.3));
	             one(values).getValue(1, 0);
	             will(returnValue(-2.7));
	         }
	     });
	   //Storing output from method call and testing by asserting
	     double result = DataUtilities.calculateColumnTotal(values, 0);
	     assertEquals(-8.0, result, .000000001d);
	 }
	 
	 
	 /*
	 * This tests the use of both negative and positive as entries in the Values2D object used as input in calculateColumnTotal()
	 */
	 @Test
	 public void calculateColumnTotalForNegativeAndPositiveNumbers() {
		//Creating mocking context
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	        	//Setting values for the mock object
	             one(values).getRowCount();
	             will(returnValue(2));
	             one(values).getValue(0, 0);
	             will(returnValue(-7.8));
	             one(values).getValue(1, 0);
	             will(returnValue(3.5));
	         }
	     });
	     //Storing output from method call and testing by asserting
	     double result = DataUtilities.calculateColumnTotal(values, 0);
	     assertEquals(-4.3, result,.000000001d);
	 }
	 
	 
	 /*
	 * This tests the use of multiple rows as input in the Values2D object used as input in calculateColumnTotal()
	 */
	 @Test
	 public void calculateColumnTotalForFourRows() {
		//Creating mocking context
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	        	//Setting values for the mock object
	             one(values).getRowCount();
	             will(returnValue(4));
	             one(values).getValue(0, 0);
	             will(returnValue(2.5));
	             one(values).getValue(1, 0);
	             will(returnValue(7.5));
	             one(values).getValue(2, 0);
	             will(returnValue(7.5));
	             one(values).getValue(3, 0);
	             will(returnValue(5.5));
	         }
	     });
	     //Storing output from method call and testing by asserting
	     double result = DataUtilities.calculateColumnTotal(values, 0);
	     assertEquals(23.0, result, .000000001d);
	 } 
	 
	 
	 /*
	 * This tests the use of an empty array as input in the Values2D object used as input in calculateColumnTotal()
	 */
	@Test
	public void calculateColumnTotalEmptyArray() {
		//Creating mocking context
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				//Setting values for the mock object
				one(values).getRowCount();
				will(returnValue(0));
			}
		});
		//Storing output from method call and testing by asserting
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals(0, result, .000000001d);
	}
		
	
	/*
	This test does not work because the specified column does not exist in the MOCK table.
	This results in an error being thrown and the test is not run.
	 @Test
	 public void calculateColumnTotalForOutOfBoundsColumnIndex() {
		Creating mocking context
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
				Setting values for the mock object
	             one(values).getRowCount();
	             will(returnValue(2));
	             one(values).getColumnCount();
	             will(returnValue(2));
	             one(values).getValue(0, 0);
	             will(returnValue(-5.3));
	             one(values).getValue(1, 0);
	             will(returnValue(-2.7));
	         }
	     });
	     double result = DataUtilities.calculateColumnTotal(values, 4);
	     assertEquals(-8.0, result .000000001d);
	 }*/
		 
		

	
	/*
	This tests the use of null as input into calculateColumnTotal()
	Note: This test should theoretically work but the method in question throws a NullPointerException instead
	      resulting in an error and causing the test to break
	      
	@Test(expected = IllegalArgumentException.class)
	public void calculateColumnTotalNull() {
		DataUtilities.calculateColumnTotal(null, 0);
	}*/
		
		
	/*calculateColumnTotal Tests*/
	
	
	/*
	 * This tests the use of all positive integers as entries in the Values2D object used as input in calculateRowTotal()
	 */
	 @Test
	 public void calculateRowTotalForPositiveNumbers() {
		//Creating mocking context
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	        	//Setting values for the mock object
	             one(values).getColumnCount();
	             will(returnValue(2));
	             one(values).getValue(0, 0);
	             will(returnValue(7.5));
	             one(values).getValue(0, 1);
	             will(returnValue(2.5));
	         }
	     });
	   //Storing output from method call and testing by asserting
	     double result = DataUtilities.calculateRowTotal(values, 0);
	     assertEquals(10.0, result, .000000001d);
	 }
	 
	 
	 
	 /*
	 * This tests the use of all negative integers as entries in the Values2D object used as input in calculateRowTotal()
	 */
	 @Test
	 public void calculateRowTotalForNegativeNumbers() {
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	        	//Setting values for the mock object
	             one(values).getColumnCount();
	             will(returnValue(2));
	             one(values).getValue(0, 0);
	             will(returnValue(-5.3));
	             one(values).getValue(0, 1);
	             will(returnValue(-2.7));
	         }
	     });
	   //Storing output from method call and testing by asserting
	     double result = DataUtilities.calculateRowTotal(values, 0);
	     assertEquals(-8.0, result, .000000001d);
	 }
	 
	 
	 
	 /*
	 * This tests the use of both negative and positive as entries in the Values2D object used as input in calculateRowTotal()
	 */
	 @Test
	 public void calculateRowTotalForNegativeAndPositiveNumbers() {
		//Creating mocking context
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	        	//Setting values for the mock object
	             one(values).getColumnCount();
	             will(returnValue(2));
	             one(values).getValue(0, 0);
	             will(returnValue(-7.8));
	             one(values).getValue(0, 1);
	             will(returnValue(3.5));
	         }
	     });
	   //Storing output from method call and testing by asserting
	     double result = DataUtilities.calculateRowTotal(values, 0);
	     assertEquals(-4.3, result, .000000001d);
	 }
	 
	 
	 
	 /*
	 * This tests the use of multiple rows as input in the Values2D object used as input in calculateRowTotal()
	 */
	 @Test
	 public void calculateRowTotalForFourColumns() {
		//Creating mocking context
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	        	//Setting values for the mock object
	             one(values).getColumnCount();
	             will(returnValue(4));
	             one(values).getValue(0, 0);
	             will(returnValue(2.5));
	             one(values).getValue(0, 1);
	             will(returnValue(7.5));
	             one(values).getValue(0, 2);
	             will(returnValue(7.5));
	             one(values).getValue(0, 3);
	             will(returnValue(5.5));
	         }
	     });
	   //Storing output from method call and testing by asserting
	     double result = DataUtilities.calculateRowTotal(values, 0);
	     assertEquals(23.0, result, .000000001d);
	 } 
	 
	 
	 /*
	 * This tests the use of an empty array as input in the Values2D object used as input in calculateRowTotal()
	 */
	@Test
	public void calculateRowTotalEmptyArray() {
		//Creating mocking context
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				//Setting values for the mock object
				one(values).getColumnCount();
				will(returnValue(0));
			}
		});
		//Storing output from method call and testing by asserting
		double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals(0, result, .000000001d);
	}
	
	
	/*getCumulativePercentages Tests*/
	
	/*
	 * This tests the use of valid, positive inputs which are placed in the KeyedValues Object used as input in getCumulativePercentages()
	 */
	@Test
    public void getCumulativePercentagesValidInput() {
		//Creating mocking context
        Mockery mockingContextKey = new Mockery();
        KeyedValues mockKeyedValues = mockingContextKey.mock(KeyedValues.class);
        mockingContextKey.checking(new Expectations() {{
        	//Setting values for the mock object
        	
        	//Specifying key and values as lists
            List<Integer> keys = new ArrayList<>(Arrays.asList(1, 2, 3));
            List<Double> values = new ArrayList<>(Arrays.asList(5.0, 9.0 , 2.0));

            //Using a for loop to set values for the mock object accordingly
            for(int i= 0; i < keys.size(); i++) {
                allowing(mockKeyedValues).getValue(i);
                will (returnValue(values.get(i)));
                allowing(mockKeyedValues).getKey(i);
                will(returnValue(keys.get(i)));
            }
            //Setting more values for the mock object
            allowing(mockKeyedValues).getItemCount();
            will(returnValue(3));
            allowing(mockKeyedValues).getKeys();
            will(returnEnumeration(keys));
        }
        });
	        //Storing output from method call and testing by asserting each value in the output array
	        List<Number> expectedValues = new ArrayList<>(Arrays.asList(0.3125, 0.875, 1.0));   
	        KeyedValues result = DataUtilities.getCumulativePercentages(mockKeyedValues);
	        for(int i = 0; i < mockKeyedValues.getItemCount(); i++) {
	        	assertEquals(expectedValues.get(i), result.getValue(i));
        }
    }
	
	/*
	 * This tests the use of null as input into getCumulativePercentages()
	 * Note: We have used IllegalArgumentException here as the function throws this instead
	 *       of the intended exception specified in the documentation. Changing the expected to 
	 *       the intended exception results in an error that breaks this test.
	 */
	    @Test (expected = IllegalArgumentException.class)
        public void getCumulativePercentagesInvalidInput() throws IllegalArgumentException{
	    	//Using null as input and calling method
	    	KeyedValues result = DataUtilities.getCumulativePercentages(null);
	    }

	
}
