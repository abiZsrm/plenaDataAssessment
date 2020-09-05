package PlenaData;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PlenaDataTest 
{
	@Test
	public void testUnique()
	{
		String inputString = "Bubble"; 
		PlenaData pdObj = new PlenaData(inputString); 
		Character expectedChar = 'u'; 
		
		// Verify unique character. 
		assertEquals(expectedChar, pdObj.findFirstUniqueCharacter());
		
		String inputString2 = "Dribble"; 
		PlenaData pdObjT2 = new PlenaData(inputString2); 
		Character expectedChar2 = 'D'; 
		
		// Verify unique character. 
		assertEquals(expectedChar2, pdObjT2.findFirstUniqueCharacter()); 
	}
	
	@Test
	public void testRewrittenString()
	{
		String inputString = "Bubble";
		PlenaData pdObj = new PlenaData(inputString); 
		String expectedRewrittenStr = "uleBbb"; 

		// Verify expected rewritten string. 
		assertEquals(expectedRewrittenStr, pdObj.reWriteString()); 
		
		String inputString2 = "Dribble"; 
		PlenaData pdObj2 = new PlenaData(inputString2);
		String expectedRewrittenStr2 = "Drilebb"; 
		
		// Verify expected rewritten string. 
		assertEquals(expectedRewrittenStr2, pdObj2.reWriteString()); 
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInputNull()
	{
		String inputString = null; 
		PlenaData pdObj = new PlenaData(inputString); 
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInputEmptyString()
	{
		String inputString2 = ""; 
		PlenaData pdObj2 = new PlenaData(inputString2); 
	}
}
