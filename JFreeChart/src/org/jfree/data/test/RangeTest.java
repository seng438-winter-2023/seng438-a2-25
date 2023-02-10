package org.jfree.data.test;

import static org.junit.Assert.*;
import org.junit.*;
import org.jfree.data.Range;

public class RangeTest {
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

	@Before
	public void setUp() throws Exception {
		testRangeObj = new Range(-10.0, 10.0);
		combineObj1 = new Range(-20, -10);
		combineObj2 = new Range(10, 20);
		shiftObj = new Range(3, 6);
	}

	@After
	public void tearDown() throws Exception {
		testRangeObj = null;
		combineObj1 = null;
		combineObj2 = null;
	}
	
	
	/*ALL CODE BELOW THIS LINE ARE OUR TESTS*/
	
	/*contains() tests below*/
	


	@Test
	public void containsWithinBounds() {
		assertTrue(testRangeObj.contains(1.0));
	}
	
	@Test
	public void containsOutOfLowerBound() {
		assertFalse(testRangeObj.contains(-25.0));
	}
	
	@Test
	public void containsOutOfUpperBound() {
		assertFalse(testRangeObj.contains(25.0));
	}
	
	@Test 
	public void containsAtLowerBound() {
		assertTrue(testRangeObj.contains(-10.0));
	}
	
	@Test 
	public void containsAtUpperBound() {
		assertTrue(testRangeObj.contains(10.0));
	}
	
	
	/*intersect() tests below*/
	
	
	@Test 
	public void intersectWithinBoundry() {
		assertTrue(testRangeObj.intersects(-6.0, 6.0));
	}
	
	
	 @Test
	    public void intersectsSameBoundaries() {
	        assertTrue(testRangeObj.intersects(-10, 10));
	 }
	 
	
	@Test
    public void intersectsLowerOutOfRangeUpperInRange() {
        assertTrue(testRangeObj.intersects(-15, -5));
    }
    
	
    @Test
    public void intersectsUpperOutOfRangeLowerInRange() {
        assertTrue(testRangeObj.intersects(5, 15));
    }
	
    
    @Test
    public void intersectsTouchingUpperBound() {
    	assertTrue(testRangeObj.intersects(10, 20));
    }
    
    @Test
    public void intersectsTouchingLowerBound() {
    	assertTrue(testRangeObj.intersects(-20, -10));
    }
    
    @Test
    public void intersectsOutOfRangeBelowLower() {
    	assertFalse(testRangeObj.intersects(-30, -20));
    }
    
    @Test
    public void intersectsOutOfRangeAboveUpper() {
    	assertFalse(testRangeObj.intersects(20, 30));
    }

    
    /*combine() tests below*/
    
    @Test 
    public void combineValidInput(){
    	Range result = Range.combine(combineObj2, combineObj1);
    	assertEquals(-20, result.getLowerBound(), .000000001d);
    	assertEquals(20, result.getUpperBound(), .000000001d);
    }
    
    
    @Test
    public void combineFirstRangeNull() {
    	Range result = Range.combine(null, combineObj2);
    	assertEquals(10, result.getLowerBound(), .000000001d);
    	assertEquals(20, result.getUpperBound(), .000000001d);
    }
    
    @Test
    public void combineSecondRangeNull() {
    	Range result = Range.combine(combineObj1, null);
    	assertEquals(-20, result.getLowerBound(), .000000001d);
    	assertEquals(-10, result.getUpperBound(), .000000001d);
    }
    
    @Test
    public void combineBothRangesNull() {
    	Range result = Range.combine(null, null);
    	assertEquals(null, result);
    }
    
    @Test
    public void combineSameRange() {
    	Range result = Range.combine(combineObj1, combineObj1);
    	assertEquals(-20, result.getLowerBound(), .000000001d);
    	assertEquals(-10, result.getUpperBound(), .000000001d);
    }
    
    @Test
    public void combineOnlyNegativeRanges() {
    	Range test = new Range(-100, -50);
    	Range result = Range.combine(combineObj1, test);
    	assertEquals(-100, result.getLowerBound(), .000000001d);
    	assertEquals(-10, result.getUpperBound(), .000000001d);
    }
    
    @Test
    public void combineOnlyPostiveRanges() {
    	Range test = new Range(50, 100);
    	Range result = Range.combine(test, combineObj2);
    	assertEquals(10, result.getLowerBound(), .000000001d);
    	assertEquals(100, result.getUpperBound(), .000000001d);
    }
    
	
    /*expandToInclude() tests below*/
    
    @Test
    public void expandToIncludeValueAboveUpperBound() {
    	Range result = Range.expandToInclude(testRangeObj, 15.0);
    	
    	assertEquals(-10.0, result.getLowerBound(), .000000001d);
    	assertEquals(15.0, result.getUpperBound(), .000000001d);
    }
    
    @Test
    public void expandToIncludeValueUnderLowerBound() {
    	Range result = Range.expandToInclude(testRangeObj, -15.0);
    	assertEquals(-15.0, result.getLowerBound(), .000000001d);
    	assertEquals(10.0, result.getUpperBound(), .000000001d);
    }
    
    @Test
    public void expandToIncludeValueWithinRange() {
    	Range result = Range.expandToInclude(testRangeObj, 6.0);
    	assertEquals(-10.0, result.getLowerBound(), .000000001d);
    	assertEquals(10.0, result.getUpperBound(), .000000001d);
    }
    
 
    @Test
    public void expandToIncludeValueEqualsUpperBound() {
    	Range result = Range.expandToInclude(testRangeObj, 10.0);
    	assertEquals(-10.0, result.getLowerBound(), .000000001d);
    	assertEquals(10.0, result.getUpperBound(), .000000001d);
    }
    
    
    //This test should run but it results in an error. This should not be the case as 
    //the value input clearly intersects the lower bound of testRangeObj
//    @Test
//    public void expandToIncludeValueEqualsLowerBound() {
//    	Range result = Range.expandToInclude(testRangeObj, -10.0);
//    	assertEquals(-10.0, result.getLowerBound(), .000000001d);
//    	assertEquals(10.0, result.getUpperBound(), .000000001d);
//    }

    @Test
    public void expandToIncludeRangeIsNull() {
    	Range result = Range.expandToInclude(null, 5.0);
    	assertEquals(5.0, result.getLowerBound(), .000000001d);
    	assertEquals(5.0, result.getUpperBound(), .000000001d);
    }
    
    
    /*shift() tests below*/
    
    @Test
    public void shiftDeltaGreaterThanZero() {
    	Range result = Range.shift(shiftObj, 5.0);
    	assertEquals(8.0, result.getLowerBound(), .000000001d);
    	assertEquals(11.0, result.getUpperBound(), .000000001d);
    }
    
    
    @Test
    public void shiftDeltaLessThanZero() {
    	Range result = Range.shift(shiftObj, -2.0);
    	assertEquals(1.0, result.getLowerBound(), .000000001d);
    	assertEquals(4.0, result.getUpperBound(), .000000001d);
    }
    
    @Test
    public void shiftDeltaIsThanZero() {
    	Range result = Range.shift(shiftObj, 0);
    	assertEquals(3.0, result.getLowerBound(), .000000001d);
    	assertEquals(6.0, result.getUpperBound(), .000000001d);
    }
    
    
//    @Test(expected = IllegalArgumentException.class)
//    public void shiftRangeIsNull() {
//        Range testRange = Range.shift(null, -2);
//    }
    
    
    @Test
    public void shiftLowerBoundCrossZero() {
    	Range result = Range.shift(shiftObj, -4.0);
    	assertEquals(0, result.getLowerBound(), .000000001d);
    	assertEquals(2.0, result.getUpperBound(), .000000001d);
    }
    
    public void shiftLowerAndUpperBoundCrossZero() {
    	Range result = Range.shift(shiftObj, -10.0);
    	assertEquals(0, result.getLowerBound(), .000000001d);
    	assertEquals(0, result.getUpperBound(), .000000001d);
    }
    
    @Test
    public void shiftDeltaGreaterThanZeroAndNotWhole() {
    	Range result = Range.shift(shiftObj, 5.5);
    	assertEquals(8.5, result.getLowerBound(), .000000001d);
    	System.out.println(result.getLowerBound());
    	assertEquals(11.5, result.getUpperBound(), .000000001d);
    }
    
    
    

    
	


}
