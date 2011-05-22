// 05/21/11 23:50 Initial creation. Wrote constructors
// 05/22/11 00:47 Corrected error in memorize function
//		  Removed debugging print statements
// 05/22/11 01:10 Added basic utter method (no weighting)

import java.lang.*;
import java.util.*;

public class reverseIdx {
//Data structure
// Each word is kept in a central Map
// Each map entry references a second Map with all of the words and follow percentages
// Memory: O(n^2) (can we reduce this by only keeping non zero maps?)

	//Internal Data
	//Central 'memory' structure
	private HashMap<String,HashMap<String,Integer>> centralMap;

	//Default Constructor
	public reverseIdx() {
		//Initialize the central memory array
		centralMap = new HashMap<String,HashMap<String,Integer>>();
	}

	//Constructor with first string Init
	public reverseIdx(String firstWords) {
		//Initialize central memory array
		centralMap = new HashMap<String,HashMap<String,Integer>>();

		this.memorize(firstWords);
	}

	//Learning new words
	public int memorize(String memStr) {

		//Tokenize input string (we don't care about nonword characters)
		String [] tokens = memStr.toLowerCase().split("\\W+");

		//Cycle them all
		// No last/first word probability implementation yet
		for(int i = 0; i<tokens.length-1;i++) {

			//We only care about the next word

			//Check for existence of current key
			if(centralMap.containsKey(tokens[i])) {

				//Check for existence of reference to next token key
				if(centralMap.get(tokens[i]).containsKey(tokens[i+1])) {
					Integer temp = 1;
					temp += centralMap.get(tokens[i]).get(tokens[i+1]);
					centralMap.get(tokens[i]).remove(tokens[i+1]);
					centralMap.get(tokens[i]).put(tokens[i+1],temp);
				}
				else {
					centralMap.get(tokens[i]).put(tokens[i+1],new Integer(1));
				}
			}
			else {
				HashMap<String,Integer> temp = new HashMap<String,Integer>();
				temp.put(tokens[i+1],new Integer(1));
				centralMap.put(tokens[i],temp);
			}
		}

		// Success!
		return 0;
	}

	// Now for the fun part
	// Novel utterance generation
	public String utter(int phraseLen) {

		// Get relevant values
		int totalWords = centralMap.size();
		Random r = new Random();
		Object [] keys = centralMap.keySet().toArray();
		String sayOut = (String)(keys[r.nextInt(totalWords)]);
		String currWord = sayOut;

		// Loop until a phrase of a proper length is generated.
		// Stopping early if needed (currently the only termination check)
		for(int i = 1; i< phraseLen; i++) {
			Object[] nextKeys = centralMap.get(currWord).keySet().toArray();
			int temp = r.nextInt(nextKeys.length);
			currWord = (String)(nextKeys[temp]);
			sayOut += " "+currWord;
			if(!centralMap.containsKey(currWord)) {
				return sayOut;
			}
		}

		return sayOut;
	}

	//Debugging purposes only
	public void testPrint() {
		System.out.println(centralMap.toString());
	}

}
