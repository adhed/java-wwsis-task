import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import org.junit.rules.ExpectedException;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import junit.framework.Assert;

public class AlgorithmsProviderTester {
	
	int[] numbers;
	AlgorithmsProvider provider;
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void init() {
		provider = new AlgorithmsProvider();
		numbers = new int[5];
		numbers[0] = 100;
		numbers[1] = 5;
		numbers[2] = 2;
		numbers[3] = 200;
		numbers[4] = 3;
		
	}
	

	@Test
	public void shouldMoveMaximumNumberToTheEndWhenAscending() {
		int[] sortedNumbers = provider.sortAscending(numbers);
		int lastNumber = sortedNumbers[sortedNumbers.length - 1];
		
		assertEquals(lastNumber, 200);
	}
	
	@Test
	public void shouldMoveTheLowestNumberToTheBegginingWhenAscending() {
		int[] sortedNumbers = provider.sortAscending(numbers);
		int firstNumber = sortedNumbers[0];
		
		assertEquals(firstNumber, 2);
	}
	
	@Test
	public void shouldMoveMaximumNumberToTheBeginningWhenDescending() {
		int[] sortedNumbers = provider.sortDescending(numbers);
		int firstNumber = sortedNumbers[0];
		
		assertEquals(firstNumber, 200);
	}
	
	@Test
	public void shouldMoveMinimumNumberToTheEndWhenDescending() {
		int[] sortedNumbers = provider.sortDescending(numbers);
		int lastNumber = sortedNumbers[sortedNumbers.length - 1];
		
		assertEquals(lastNumber, 2);
	}
	
	@Test
	public void shouldSortArrayAscending() {
		int[] sortedNumbers = provider.sortAscending(numbers);
		int[] expectedArray = {2, 3, 5, 100, 200};
		
		assertTrue(Arrays.equals(expectedArray, sortedNumbers));
	}
	
	@Test
	public void shouldSortArraysDescending() {
		int[] sortedNumbers = provider.sortDescending(numbers);
		int[] expectedArray = {200, 100, 5, 3, 2};
		
		assertTrue(Arrays.equals(expectedArray, sortedNumbers));
	}
	
	@Test
	public void shouldThrowAnExceptionWhenProvidingValueDifferentThanNumber() {
		String someInvalidNumber = "not a number";
		
		try {
			int number = provider.parseNumber(someInvalidNumber);
			fail("expected exception was not occured.");
		} catch(MyException exc) {
			assertEquals(true, true);
		}
		
	}
	
	@Test 
	public void shouldParseStringNumberIntoNumber() {
		String number = "5";
		int num = 10000;

		try {
			num = provider.parseNumber(number);
		} catch(MyException exc) {
			fail("expected exception was not occured.");
		}
		
		
		assertEquals(num, 5);
	}
}
