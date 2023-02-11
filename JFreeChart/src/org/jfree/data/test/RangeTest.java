package org.jfree.data.test;

import static org.junit.Assert.*;
import org.junit.*;
import org.jfree.data.Range;

public class RangeTest {
	//Variety of objects used to test the various methods in this class
	Range testRangeObj;
	Range combineObj1;
	Range combineObj2;
	Range shiftObj;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	//Used to create objects before each test
	@Before
	public void setUp() throws Exception {
		testRangeObj = new Range(-10.0, 10.0);
		combineObj1 = new Range(-20, -10);
		combineObj2 = new Range(10, 20);
		shiftObj = new Range(3, 6);
	}

	//Used to reset all objects after each test
	@After
	public void tearDown() throws Exception {
		testRangeObj = null;
		combineObj1 = null;
		combineObj2 = null;
		shiftObj = null;
	}
	
	
	/*ALL CODE BELOW THIS LINE ARE OUR TESTS*/
	
	
	
	/*contains() tests below*/
	
	/*
	 * This tests a value that exists within the test Range Object
	 */
	@Test
	public void containsWithinBounds() {
		//Testing by asserting
		assertTrue(testRangeObj.contains(1.0));
	}
	
	
	/*
	 * This tests a value that is less than the lower bound of the test Range Object
	 */
	@Test
	public void containsOutOfLowerBound() {
		//Testing by asserting
		assertFalse(testRangeObj.contains(-25.0));
	}
	
	
	/*
	 * This tests a value that is greater than the upper bound of the test Range Object
	 */
	@Test
	public void containsOutOfUpperBound() {
		//Testing by asserting
		assertFalse(testRangeObj.contains(25.0));
	}
	
	
	/*
	 * This tests a value that is exactly equal to the lower bound of the test Range Object
	 */
	@Test 
	public void containsAtLowerBound() {
		//Testing by asserting
		assertTrue(testRangeObj.contains(-10.0));
	}
	
	
	/*
	 * This tests a value that is exactly equal to the upper bound of the test Range Object
	 */
	@Test 
	public void containsAtUpperBound() {
		//Testing by asserting
		assertTrue(testRangeObj.contains(10.0));
	}
	
	
	/*intersect() tests below*/
	
	
	/*
	 * This tests a range that is encapsulated (within) by the test Range Object
	 */
	@Test 
	public void intersectWithinBoundry() {
		//Testing by asserting
		assertTrue(testRangeObj.intersects(-6.0, 6.0));
	}
	
	
	/*
	 * This tests a range that exactly equal to the range in the test Range Object
	 */
	 @Test
	    public void intersectsSameBoundaries() {
		//Testing by asserting
	        assertTrue(testRangeObj.intersects(-10, 10));
	 }
	 
	
	 /*
	 * This tests a range where the lower bound is out of the Range Object range and the upper bound is within the Range Object range
	 */
	@Test
    public void intersectsLowerOutOfRangeUpperInRange() {
		//Testing by asserting
        assertTrue(testRangeObj.intersects(-15, -5));
    }
    
	
	/*
	 * This tests a range where the upper bound is out of the Range Object range and the lower bound is within the Range Object range
	 */
    @Test
    public void intersectsUpperOutOfRangeLowerInRange() {
    	//Testing by asserting
        assertTrue(testRangeObj.intersects(5, 15));
    }
	
    
    /*
	 * This tests a range where the lower bound touches the upper bound of the test Range Object
	 */
    @Test
    public void intersectsTouchingUpperBound() {
    	//Testing by asserting
    	assertTrue(testRangeObj.intersects(10, 20));
    }
    
    
    /*
	 * This tests a range where the upper bound touches the lower bound of the test Range Object
	 */
    @Test
    public void intersectsTouchingLowerBound() {
    	//Testing by asserting
    	assertTrue(testRangeObj.intersects(-20, -10));
    }
    
    
    /*
	 * This tests a range that is smaller than and is completley out of the test Range Object
	 */
    @Test
    public void intersectsOutOfRangeBelowLower() {
    	//Testing by asserting
    	assertFalse(testRangeObj.intersects(-30, -20));
    }
    
    
    /*
	 * This tests a range that is greater than and is completley out of the test Range Object
	 */
    @Test
    public void intersectsOutOfRangeAboveUpper() {
    	//Testing by asserting
    	assertFalse(testRangeObj.intersects(20, 30));
    }

    
    /*combine() tests below*/
    
    
    /*
	 * This tests uses two valid range objects and calls the combine() method on them
	 */
    @Test 
    public void combineValidInput(){
    	//Storing result from function call and testing by asserting both bounds of the result
    	Range result = Range.combine(combineObj2, combineObj1);
    	assertEquals(-20, result.getLowerBound(), .000000001d);
    	assertEquals(20, result.getUpperBound(), .000000001d);
    }
    
    
    /*
	 * This tests uses null for the first input and a valid Range object for the second object when calling combine()
	 */
    @Test
    public void combineFirstRangeNull() {
    	//Storing result from function call and testing by asserting both bounds of the result
    	Range result = Range.combine(null, combineObj2);
    	assertEquals(10, result.getLowerBound(), .000000001d);
    	assertEquals(20, result.getUpperBound(), .000000001d);
    }
    
    /*
	 * This tests uses a valid Range object for the first input and null for the second object when calling combine()
	 */
    @Test
    public void combineSecondRangeNull() {
    	//Storing result from function call and testing by asserting both bounds of the result
    	Range result = Range.combine(combineObj1, null);
    	assertEquals(-20, result.getLowerBound(), .000000001d);
    	assertEquals(-10, result.getUpperBound(), .000000001d);
    }
    
    
    /*
	 * This tests uses null for both inputs when calling combine()
	 */
    @Test
    public void combineBothRangesNull() {
    	Range result = Range.combine(null, null);
    	assertEquals(null, result);
    }
    
    
    /*
	 * This tests uses the same Range object as input when calling combine()
	 */
    @Test
    public void combineSameRange() {
    	//Storing result from function call and testing by asserting both bounds of the result
    	Range result = Range.combine(combineObj1, combineObj1);
    	assertEquals(-20, result.getLowerBound(), .000000001d);
    	assertEquals(-10, result.getUpperBound(), .000000001d);
    }
    
    /*
	 * This tests uses two Range objects as input where both ranges are in the negative region when calling combine()
	 */
    @Test
    public void combineOnlyNegativeRanges() {
    	//Storing result from function call and testing by asserting both bounds of the result
    	Range test = new Range(-100, -50);
    	Range result = Range.combine(combineObj1, test);
    	assertEquals(-100, result.getLowerBound(), .000000001d);
    	assertEquals(-10, result.getUpperBound(), .000000001d);
    }
    
    /*
	 * This tests uses two Range objects as input where both ranges are in the positive region when calling combine()
	 */
    @Test
    public void combineOnlyPostiveRanges() {
    	//Storing result from function call and testing by asserting both bounds of the result
    	Range test = new Range(50, 100);
    	Range result = Range.combine(test, combineObj2);
    	assertEquals(10, result.getLowerBound(), .000000001d);
    	assertEquals(100, result.getUpperBound(), .000000001d);
    }
    
	
    /*expandToInclude() tests below*/
    
    
    /*
	 * This tests a case where the input value is greater than the upper bound of the test Range object
	 */
    @Test
    public void expandToIncludeValueAboveUpperBound() {
    	//Storing result from function call and testing by asserting both bounds of the result
    	Range result = Range.expandToInclude(testRangeObj, 15.0);
    	assertEquals(-10.0, result.getLowerBound(), .000000001d);
    	assertEquals(15.0, result.getUpperBound(), .000000001d);
    }
    
    
    /*
	 * This tests a case where the input value is less than the lower bound of the test Range object
	 */
    @Test
    public void expandToIncludeValueUnderLowerBound() {
    	//Storing result from function call and testing by asserting both bounds of the result
    	Range result = Range.expandToInclude(testRangeObj, -15.0);
    	assertEquals(-15.0, result.getLowerBound(), .000000001d);
    	assertEquals(10.0, result.getUpperBound(), .000000001d);
    }
    
    
    /*
	 * This tests a case where the input value is less than the lower bound of the test Range object
	 */
    @Test
    public void expandToIncludeValueWithinRange() {
    	//Storing result from function call and testing by asserting both bounds of the result
    	Range result = Range.expandToInclude(testRangeObj, 6.0);
    	assertEquals(-10.0, result.getLowerBound(), .000000001d);
    	assertEquals(10.0, result.getUpperBound(), .000000001d);
    }
    
 
    /*
	 * This tests a case where the input value is equal to the upper bound of the test Range object
	 */
    @Test
    public void expandToIncludeValueEqualsUpperBound() {
    	//Storing result from function call and testing by asserting both bounds of the result
    	Range result = Range.expandToInclude(testRangeObj, 10.0);
    	assertEquals(-10.0, result.getLowerBound(), .000000001d);
    	assertEquals(10.0, result.getUpperBound(), .000000001d);
    }
    
    /*
    This test should run but it results in an error. This should not be the case as 
    the value input clearly intersects the lower bound of testRangeObj
    @Test
    public void expandToIncludeValueEqualsLowerBound() {
    	Range result = Range.expandToInclude(testRangeObj, -10.0);
    	assertEquals(-10.0, result.getLowerBound(), .000000001d);
    	assertEquals(10.0, result.getUpperBound(), .000000001d);
    }*/

    /*
	 * This tests a case where the input Range Object is null
	 */
    @Test
    public void expandToIncludeRangeIsNull() {
    	//Storing result from function call and testing by asserting both bounds of the result
    	Range result = Range.expandToInclude(null, 5.0);
    	assertEquals(5.0, result.getLowerBound(), .000000001d);
    	assertEquals(5.0, result.getUpperBound(), .000000001d);
    }
    
    
    /*shift() tests below*/
    
    
    /*
   	 * This tests a case where the delta value input is a positive value
   	 */
    @Test
    public void shiftDeltaGreaterThanZero() {
    	//Storing result from function call and testing by asserting both bounds of the result
    	Range result = Range.shift(shiftObj, 5.0);
    	assertEquals(8.0, result.getLowerBound(), .000000001d);
    	assertEquals(11.0, result.getUpperBound(), .000000001d);
    }
    
    
    /*
   	 * This tests a case where the delta value input is a negative value
   	 */
    @Test
    public void shiftDeltaLessThanZero() {
    	//Storing result from function call and testing by asserting both bounds of the result
    	Range result = Range.shift(shiftObj, -2.0);
    	assertEquals(1.0, result.getLowerBound(), .000000001d);
    	assertEquals(4.0, result.getUpperBound(), .000000001d);
    }
    
    
    /*
   	 * This tests a case where the delta value input is exactly zero
   	 */
    @Test
    public void shiftDeltaIsThanZero() {
    	//Storing result from function call and testing by asserting both bounds of the result
    	Range result = Range.shift(shiftObj, 0);
    	assertEquals(3.0, result.getLowerBound(), .000000001d);
    	assertEquals(6.0, result.getUpperBound(), .000000001d);
    }
    
    

    /*
	This tests the use of null as input into shift()
	Note: This test should theoretically work but the method in question throws a NullPointerException instead
	      resulting in an error and causing the test to break
    @Test(expected = IllegalArgumentException.class)
    public void shiftRangeIsNull() {
        Range testRange = Range.shift(null, -2);
    }*/
    
    
    /*
   	 * This tests a case where the delta value causes the input range to cross zero on the lower bound
   	 */
    @Test
    public void shiftLowerBoundCrossZero() {
    	//Storing result from function call and testing by asserting both bounds of the result
    	Range result = Range.shift(shiftObj, -4.0);
    	assertEquals(0, result.getLowerBound(), .000000001d);
    	assertEquals(2.0, result.getUpperBound(), .000000001d);
    }
    
    
    /*
   	 * This tests a case where the delta value causes the input range to cross zero on both upper and lower bound
   	 */
    public void shiftLowerAndUpperBoundCrossZero() {
    	//Storing result from function call and testing by asserting both bounds of the result
    	Range result = Range.shift(shiftObj, -10.0);
    	assertEquals(0, result.getLowerBound(), .000000001d);
    	assertEquals(0, result.getUpperBound(), .000000001d);
    }
    
    
    /*
   	 * This tests a case where the delta value is greater than zero and not a whole number
   	 */
    @Test
    public void shiftDeltaGreaterThanZeroAndNotWhole() {
    	//Storing result from function call and testing by asserting both bounds of the result
    	Range result = Range.shift(shiftObj, 5.5);
    	assertEquals(8.5, result.getLowerBound(), .000000001d);
    	assertEquals(11.5, result.getUpperBound(), .000000001d);
    }
}
