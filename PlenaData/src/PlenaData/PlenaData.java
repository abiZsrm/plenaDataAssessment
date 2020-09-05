package PlenaData;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

import javax.swing.JOptionPane;

/**
 * @author Abhishek Madhusudhan. 
 * 
 * Instructions to test. 
 * - Run the PlenaDataTest class. 
 * (OR)
 * - Run the main PlenaData class to get the results for the given sample data.
 */
public class PlenaData 
{
	private HashMap<Character, Integer> m_inputStringCount;
	private HashMap<Character, Integer> m_inputStringIdxMap;
	private String m_inputStr;
	
	public PlenaData(String inputStr)
	{
		if(inputStr == null || inputStr.length() == 0)
		{
			throw new IllegalArgumentException("Invalid String: Please enter a valid string."); 
		}
		
		m_inputStr = inputStr; 
		m_inputStringCount = createMapOfCharacterAndCount(inputStr); 
		m_inputStringIdxMap = createMapOfCharacterAndIndex(); 
	}

	public String reWriteString()
	{
		PlenaDataCompartor comparator = this::compare; 
		Character[] charArray = new Character[m_inputStr.length()]; 
		StringBuilder rewrittenString = new StringBuilder(); 
		
		for(int i = 0; i < charArray.length; i++)
		{
			charArray[i] = m_inputStr.charAt(i); 
		}
		
		Arrays.sort(charArray, comparator);
		
		for(Character c : charArray)
		{
			rewrittenString.append(c); 
		}
		
		return rewrittenString.toString(); 
	}
	
	public static void main(String[] args) 
	{
		String inputString = ""; 
		
		do
		{
			inputString = JOptionPane.showInputDialog("Please enter an input string."); 
		}while(inputString.equals("")); 
		
		
		PlenaData pd = new PlenaData(inputString); 
		String output = "First Unique Character: " + pd.findFirstUniqueCharacter() + "\n"
					   + "Re Written String: " + pd.reWriteString() + "\n";
		
		JOptionPane.showMessageDialog(null, output);
	}
	
	public HashMap<Character, Integer> createMapOfCharacterAndCount(String inputString) 
	{
		String inputStringLowerCase = inputString.toLowerCase();
		HashMap<Character, Integer> inputStringCount = new HashMap<Character, Integer>();

		// Create a Map of the character and the number of character occurrence.
		for (int i = 0; i < inputStringLowerCase.length(); i++) 
		{
			if (inputStringCount.containsKey(inputStringLowerCase.charAt(i))) 
			{
				inputStringCount.put(inputStringLowerCase.charAt(i),
			    inputStringCount.get(inputStringLowerCase.charAt(i)) + 1);
			} 
			else 
			{
				inputStringCount.put(inputStringLowerCase.charAt(i), 1);
			}
		}
		
		return inputStringCount; 
	}
	
	public HashMap<Character, Integer> createMapOfCharacterAndIndex()
	{
		// Create an index map.
		HashMap<Character, Integer> inputStringIdxMap = new HashMap<Character, Integer>();
		for (int i = 0; i < m_inputStr.length(); i++) 
		{
			inputStringIdxMap.put(m_inputStr.charAt(i), i);
		}
		
		return inputStringIdxMap; 
	}
	
	public int compare(char c1, char c2) 
	{
	  if (m_inputStringCount.get(Character.toLowerCase(c1)) > m_inputStringCount.get(Character.toLowerCase(c2))) 
	  {
	     return 1;
   	  } 
	  else if (m_inputStringCount.get(Character.toLowerCase(c1)) == m_inputStringCount.get(Character.toLowerCase(c2))) 
	  {
		 // Both characters cannot possibly have the same index.
		 if (m_inputStringIdxMap.get(c1) > m_inputStringIdxMap.get(c2)) 
		 {
			return 1;
		 } 
	     else 
		 {
		  	return -1;
		 }
	  } 
	  else 
	  {
	 	return -1;
	  }
	}
	
	public Character findFirstUniqueCharacter()
	{
		char firstUnique = ' '; 
		for (int i = 0; i < m_inputStr.length(); i++) 
		{
			if (m_inputStringCount.get(Character.toLowerCase(m_inputStr.charAt(i))) == 1) 
			{
				firstUnique = m_inputStr.charAt(i);
				break;
			}
		}
		
		return firstUnique; 
	}
}

interface PlenaDataCompartor extends Comparator<Character> 
{
	public int compare(Character c1, Character c2);
}
