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
	
	@Test
	public void createNumberArrayPositiveDouble() {
		Number[] expected = {1.0, 2.0, 3.0, 4.0};
		double[] actualInput = {1.0, 2.0, 3.0, 4.0};
		
		assertArrayEquals(expected, DataUtilities.createNumberArray(actualInput));
	}
	
	@Test
	public void createNumberArrayNegativeDouble() {
		Number[] expected = {-1.0, -2.0, -3.0, -4.0};
		double[] actualInput = {-1.0, -2.0, -3.0, -4.0};
		
		assertArrayEquals(expected, DataUtilities.createNumberArray(actualInput));
	}
	
//	@Test (expected = IllegalArgumentException.class)
//	public void createNumberArrayNull() throws IllegalArgumentException{
//		double[] actualInput = null;
//		DataUtilities.createNumberArray(actualInput);
//	}
	
	
	/*CreateNumberArray2D Tests*/
	
	@Test
	public void createNumberArray2DPositiveDouble() {
		Number[][] expected = {{1.0, 2.0, 3.0, 4.0}, {5.0, 6.0, 7.0, 8.0}};
		double[][] actualInput = {{1.0, 2.0, 3.0, 4.0}, {5.0, 6.0, 7.0, 8.0}};
		
		assertArrayEquals(expected, DataUtilities.createNumberArray2D(actualInput));
	}
	
	@Test
	public void createNumberArray2DNegativeDouble() {
		Number[][] expected = {{-1.0, -2.0, -3.0, -4.0}, {-5.0, -6.0, -7.0, -8.0}};
		double[][] actualInput = {{-1.0, -2.0, -3.0, -4.0}, {-5.0, -6.0, -7.0, -8.0}};
		
		assertArrayEquals(expected, DataUtilities.createNumberArray2D(actualInput));
	}
	
	@Test
	public void createNumberArray2DSquareArray() {
		Number[][] expected = {{1.0, 2.0}, {5.0, 6.0}};
		double[][] actualInput = {{1.0, 2.0}, {5.0, 6.0}};
		
		assertArrayEquals(expected, DataUtilities.createNumberArray2D(actualInput));
	}
	
	
	/*calculateColumnTotal Tests*/
	
	 @Test
	 public void calculateColumnTotalForPositiveNumbers() {
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getRowCount();
	             will(returnValue(2));
	             one(values).getValue(0, 0);
	             will(returnValue(7.5));
	             one(values).getValue(1, 0);
	             will(returnValue(2.5));
	         }
	     });
	     double result = DataUtilities.calculateColumnTotal(values, 0);
	     assertEquals(10.0, result, .000000001d);
	 }
	 
	 
	 @Test
	 public void calculateColumnTotalForNegativeNumbers() {
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getRowCount();
	             will(returnValue(2));
	             one(values).getValue(0, 0);
	             will(returnValue(-5.3));
	             one(values).getValue(1, 0);
	             will(returnValue(-2.7));
	         }
	     });
	     double result = DataUtilities.calculateColumnTotal(values, 0);
	     assertEquals(-8.0, result, .000000001d);
	 }
	 
	 
	 @Test
	 public void calculateColumnTotalForNegativeAndPositiveNumbers() {
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getRowCount();
	             will(returnValue(2));
	             one(values).getValue(0, 0);
	             will(returnValue(-7.8));
	             one(values).getValue(1, 0);
	             will(returnValue(3.5));
	         }
	     });
	     double result = DataUtilities.calculateColumnTotal(values, 0);
	     assertEquals(-4.3, result,.000000001d);
	 }
	 
	 
	 @Test
	 public void calculateColumnTotalForFourRows() {
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
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
	     double result = DataUtilities.calculateColumnTotal(values, 0);
	     assertEquals(23.0, result, .000000001d);
	 } 
	 
		@Test
		public void calculateColumnTotalEmptyArray() {
			Mockery mockingContext = new Mockery();
			final Values2D values = mockingContext.mock(Values2D.class);
			mockingContext.checking(new Expectations() {
				{
					one(values).getRowCount();
					will(returnValue(0));
				}
			});
			double result = DataUtilities.calculateColumnTotal(values, 0);
			assertEquals(0, result, .000000001d);
		}
		
		
		//This test does not work because the specified column does not exist in the MOCK table.
		//This results in an error being thrown and the test is not run.
//		 @Test
//		 public void calculateColumnTotalForOutOfBoundsColumnIndex() {
//		     Mockery mockingContext = new Mockery();
//		     final Values2D values = mockingContext.mock(Values2D.class);
//		     mockingContext.checking(new Expectations() {
//		         {
//		             one(values).getRowCount();
//		             will(returnValue(2));
//		             one(values).getColumnCount();
//		             will(returnValue(2));
//		             one(values).getValue(0, 0);
//		             will(returnValue(-5.3));
//		             one(values).getValue(1, 0);
//		             will(returnValue(-2.7));
//		         }
//		     });
//		     double result = DataUtilities.calculateColumnTotal(values, 4);
//		     assertEquals(-8.0, result .000000001d);
//		 }
		 
		
//		@Test(expected = IllegalArgumentException.class)
//		public void calculateColumnTotalNull() {
//			DataUtilities.calculateColumnTotal(null, 0);
//		}
		
		
		 @Test
		 public void calculateRowTotalForPositiveNumbers() {
		     Mockery mockingContext = new Mockery();
		     final Values2D values = mockingContext.mock(Values2D.class);
		     mockingContext.checking(new Expectations() {
		         {
		             one(values).getColumnCount();
		             will(returnValue(2));
		             one(values).getValue(0, 0);
		             will(returnValue(7.5));
		             one(values).getValue(0, 1);
		             will(returnValue(2.5));
		         }
		     });
		     double result = DataUtilities.calculateRowTotal(values, 0);
		     assertEquals(10.0, result, .000000001d);
		 }
		 
		 
		 @Test
		 public void calculateRowTotalForNegativeNumbers() {
		     Mockery mockingContext = new Mockery();
		     final Values2D values = mockingContext.mock(Values2D.class);
		     mockingContext.checking(new Expectations() {
		         {
		             one(values).getColumnCount();
		             will(returnValue(2));
		             one(values).getValue(0, 0);
		             will(returnValue(-5.3));
		             one(values).getValue(0, 1);
		             will(returnValue(-2.7));
		         }
		     });
		     double result = DataUtilities.calculateRowTotal(values, 0);
		     assertEquals(-8.0, result, .000000001d);
		 }
		 
		 
		 @Test
		 public void calculateRowTotalForNegativeAndPositiveNumbers() {
		     Mockery mockingContext = new Mockery();
		     final Values2D values = mockingContext.mock(Values2D.class);
		     mockingContext.checking(new Expectations() {
		         {
		             one(values).getColumnCount();
		             will(returnValue(2));
		             one(values).getValue(0, 0);
		             will(returnValue(-7.8));
		             one(values).getValue(0, 1);
		             will(returnValue(3.5));
		         }
		     });
		     double result = DataUtilities.calculateRowTotal(values, 0);
		     assertEquals(-4.3, result, .000000001d);
		 }
		 
		 
		 @Test
		 public void calculateRowTotalForFourColumns() {
		     Mockery mockingContext = new Mockery();
		     final Values2D values = mockingContext.mock(Values2D.class);
		     mockingContext.checking(new Expectations() {
		         {
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
		     double result = DataUtilities.calculateRowTotal(values, 0);
		     assertEquals(23.0, result, .000000001d);
		 } 
		 
		 
		@Test
		public void calculateRowTotalEmptyArray() {
			Mockery mockingContext = new Mockery();
			final Values2D values = mockingContext.mock(Values2D.class);
			mockingContext.checking(new Expectations() {
				{
					one(values).getColumnCount();
					will(returnValue(0));
				}
			});
			double result = DataUtilities.calculateRowTotal(values, 0);
			assertEquals(0, result, .000000001d);
		}
		
		
		/*getCumulativePercentages*/
		
		@Test
	    public void getCumulativePercentagesValidInput() {
	        Mockery mockingContextKey = new Mockery();
	        KeyedValues mockKeyedValues = mockingContextKey.mock(KeyedValues.class);
	        mockingContextKey.checking(new Expectations() {{
	            List<Integer> keys = new ArrayList<>(Arrays.asList(1, 2, 3));
	            List<Double> values = new ArrayList<>(Arrays.asList(5.0, 9.0 , 2.0));

	            for(int i= 0; i < keys.size(); i++) {
	                allowing(mockKeyedValues).getValue(i);
	                will (returnValue(values.get(i)));
	                allowing(mockKeyedValues).getKey(i);
	                will(returnValue(keys.get(i)));
	            }
	            
	            allowing(mockKeyedValues).getItemCount();
	            will(returnValue(3));
	            allowing(mockKeyedValues).getKeys();
	            will(returnEnumeration(keys));
	        }
	        });

	        List<Number> expectedValues = new ArrayList<>(Arrays.asList(0.3125, 0.875, 1.0));   
	        KeyedValues result = DataUtilities.getCumulativePercentages(mockKeyedValues);
	        for(int i = 0; i < mockKeyedValues.getItemCount(); i++) {
	        	assertEquals(expectedValues.get(i), result.getValue(i));
	        }
	    }
		
		
//	    @Test (expected = IllegalArgumentException.class)
//        public void getCumulativePercentagesInvalidInput() throws IllegalArgumentException{
//        KeyedValues result = DataUtilities.getCumulativePercentages(null);
//	    }

	
}
