package telran.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static telran.util.ArraysOperations.*;

class ArraysOperationsTests {

	private static final String INSERTED_STRING = "World and ";
	private static final int INSERTED_NUMBER = 100;

	@Test
	void testInsert() {
		String arStr[] = {"hello", "Java"}; 
		String expectedStr[] = {"hello", INSERTED_STRING, "Java"}; 
		String actualStr[] = new String[arStr.length + 1];
		int indexInsert = 1;
		assertEquals(OK,insert(arStr, INSERTED_STRING, indexInsert, actualStr));
		assertArrayEquals(expectedStr, actualStr);
		assertEquals(WRONG_INDEX,insert(arStr, INSERTED_STRING, 3, actualStr));
		assertEquals(WRONG_INDEX,insert(arStr, INSERTED_STRING, -1, actualStr));
		actualStr = new String[1];
		assertEquals(WRONG_RESULT_LENGTH,insert(arStr, INSERTED_STRING, indexInsert, actualStr));
		Integer numbers[] = {1, 2, 3};
		indexInsert = 0;
		Integer actualNumbers[] = new Integer[numbers.length + 1];
		Integer expectedFirst[] = {INSERTED_NUMBER, 1, 2, 3};
		insert(numbers,INSERTED_NUMBER, indexInsert, actualNumbers );
		assertArrayEquals(expectedFirst, actualNumbers);
		indexInsert = numbers.length;
		Integer expectedLast[] = { 1, 2, 3, INSERTED_NUMBER};
		insert(numbers,INSERTED_NUMBER, indexInsert, actualNumbers );
		assertArrayEquals(expectedLast, actualNumbers);
		
		
		
		
	}

	@Test
	void testRemove() {
		Integer ar[] = {10, -20, 5, 80};
		Integer actual[] = new Integer[ar.length - 1];
		int indRem1 = 0;
		Integer expected1[] = {-20, 5, 80};
		int indRem2 = 1;
		Integer expected2[] = {10, 5, 80};
		int indRem3 = 3;
		Integer expected3[] = {10, -20, 5};
		assertEquals(OK, remove(ar, indRem1, actual));
		assertArrayEquals(expected1, actual );
		assertEquals(OK, remove(ar, indRem2, actual));
		assertArrayEquals(expected2, actual );
		assertEquals(OK, remove(ar, indRem3, actual));
		assertArrayEquals(expected3, actual );
		int indRemWrong = 4;
		assertEquals(WRONG_INDEX, remove(ar, indRemWrong, actual));
		indRemWrong = -1;
		assertEquals(WRONG_INDEX, remove(ar, indRemWrong, actual));
		actual = new Integer[2];
		assertEquals(WRONG_RESULT_LENGTH, remove(ar, indRem1, actual));
		actual = new Integer[4];
		assertEquals(WRONG_RESULT_LENGTH, remove(ar, indRem1, actual));
		//Tests with strings are for testing method parameterization <T>
		String names[] = {"name1", "name2"};
		assertEquals(WRONG_RESULT_LENGTH, remove(names, 0, names));
		
	}

	@Test
	void testInsertSorted() {
		int inserted1 = 5;
		int inserted2 = 20;
		int inserted3 = 25;
		int inserted4 = 45;
		Integer ar[] = {10, 20, 30, 40};
		Integer actual[] = new Integer[ar.length + 1];
		Integer expected1[] = {inserted1, 10, 20, 30, 40};
		Integer expected2[] = {10, inserted2, 20, 30, 40};
		Integer expected3[] = {10, 20, inserted3, 30, 40};
		Integer expected4[] = {10, 20, 30, 40, inserted4};
		assertEquals(OK, insertSorted(ar, inserted1, actual));
		assertArrayEquals(expected1, actual);
		assertEquals(OK, insertSorted(ar, inserted2, actual));
		assertArrayEquals(expected2, actual);
		assertEquals(OK, insertSorted(ar, inserted3, actual));
		assertArrayEquals(expected3, actual);
		assertEquals(OK, insertSorted(ar, inserted4, actual));
		assertArrayEquals(expected4, actual);
		//Tests with strings are for testing method parameterization <T>
		String names[] = {"name1", "name2"};
		assertEquals(WRONG_RESULT_LENGTH, insertSorted(names, "name3", names));
		
	}

	@Test
	void testAddLast() {
		int insertedNumber = 4;
		Integer ar[] = {1,2,3};
		Integer expected[] = {1, 2, 3, insertedNumber};
		Integer actual[] = new Integer[ar.length + 1];
		assertEquals(OK, addLast(ar, insertedNumber, actual));
		assertArrayEquals(expected, actual);
		//Tests with strings are for testing method parameterization <T>
		String names[] = {"name1", "name2"};
		assertEquals(WRONG_RESULT_LENGTH, addLast(names, "name3", names));

	}

	@Test
	void testAddFirst() {
		int insertedNumber = 4;
		Integer ar[] = {1,2,3};
		Integer expected[] = {insertedNumber, 1, 2, 3 };
		Integer actual[] = new Integer[ar.length + 1];
		assertEquals(OK, addFirst(ar, insertedNumber, actual));
		assertArrayEquals(expected, actual);
		//Tests with strings are for testing method parameterization <T>
		String names[] = {"name1", "name2"};
		assertEquals(WRONG_RESULT_LENGTH, addFirst(names, "name3", names));
	}
	
	
	

}
