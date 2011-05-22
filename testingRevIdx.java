import java.lang.*;
import java.util.*;

public class testingRevIdx {

	public static void main(String [] args) {

		String firstInput = "this is the first test string originally it had bad grammar to facilitate a smaller test, but the grammar has now been corrected to allow for more accurate generation";

		reverseIdx test = new reverseIdx(firstInput);

		test.testPrint();

		String secondInput = "this is the second test string. we will be testing addition of a new string and the increment of the value currently in the memory";

		System.out.println("\n\n\n\n\n");
		test.memorize(secondInput);

		test.testPrint();
		System.out.println("\n\n\n\n\nTESTING GENERATION:");
		System.out.println(test.utter(3));
		System.out.println(test.utter(5));
		System.out.println(test.utter(7));
		System.out.println(test.utter(9));
		System.out.println(test.utter(11));

		System.out.println("\n\n Adding a LOT more words");

		String thirdInput = "In this paper, we will be exploring the various hypotheses on how people acquire a second or even more, languages. Specifically, we will be looking at the models presented by various scholars that cover both the more nativist approach to language, as well as the more social-linguistic aspects. The main question that we will be addressing is, how do people acquire their non-native languages, and what factors have what kind of influence on this process? We will answer these questions through looking at evidence presented by Schumann, Singleton, and other researchers that have done experiments and conducted research into factor that affect language acquisition, such as age, cultural immersion, and other known languages. We will present data acquired from various studies and attempt to determine how much influence the various factors have, as well as try to determine an order as to the ‘importance’ of each of the variables that has been investigated. As anyone would imagine, there are many factors that play a part in the acquisition of a second or third language, including age and immersion among other things. The question then becomes, how much does each factor play a role in acquisition? And is there a factor that plays more of a part than others? We will be looking at the acculturation model presented by Schumann in 1986, the more sociocognitive approach with alignment presented by Atkinson et al in 2007, as well as the more traditional age based analysis provided by Singleton and Lengyel in their 1995 book.";
		test.memorize(thirdInput);
		System.out.println("\n\n\n\n\nTESTING GENERATION:");
		System.out.println(test.utter(3));
		System.out.println(test.utter(5));
		System.out.println(test.utter(7));
		System.out.println(test.utter(9));
		System.out.println(test.utter(11));
		System.out.println(test.utter(13));
		System.out.println(test.utter(15));
		System.out.println(test.utter(17));
		System.out.println(test.utter(19));
		System.out.println(test.utter(21));
		System.out.println("\n\nCurrent Memory");
		test.testPrint();
	}
}
