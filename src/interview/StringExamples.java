package interview;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Answers to possible interview questions as suggested in a number of 
 * different resources on the web 
 * 
 * @author carolsusieo
 *
 * 
 */

public class StringExamples {
	
	/** Most popular:
	 *   Reverse words in a string (words are separated by one or more spaces). 
	 *   Now do it in-place. 
	 *   @param args not used.
	 */

	public static void main(String[] args) {
		String str = "hello reverse words hello";
		System.out.println(str);
		System.out.println(reverseWords(str));
		System.out.println("Reverse Recursively");
		System.out.println(reverseRecursively(str));
		StringBuffer str2 = new StringBuffer("Reverse words in-place");	
		System.out.println(str2);
		System.out.println(reverseWordsInPlace(str2));
		StringBuffer str3 = new StringBuffer("remove whitespace\t\t\tin place");
		System.out.println(str3);
		System.out.println(removeWhitespaceInplace(str3));
		StringBuffer str4 = new StringBuffer("AAA BBB CC D EE A");
		System.out.println("remove duplicate characters" + str4);
		System.out.print(removeDuplicateChars(str4));
		
        Character c=firstNonRepeatedCharacter(str);
        System.out.println("\nThe first non repeated character in '" + str + "' is :  " + c);
	}
	
	
	static private String reverseWords(String s) {
			if (s == null || s.length() == 0) {
				return "";
			}	 
			// split to words by space
			String[] arr = s.split(" ");
			StringBuilder sb = new StringBuilder();
			for (int i = arr.length - 1; i >= 0; --i) {
				if (!arr[i].equals("")) {
					sb.append(arr[i]).append(" ");
				}
			}
			return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
		}
	
    // reverse all words in place by first reversing entire string, then word by word
	static private StringBuffer reverseWordsInPlace(StringBuffer bufin)
	{
	 	    int lindex = 0;
	 	    
	    int rindex = bufin.length() - 1;
	    if (rindex > 1)
	    {
	        //reverse complete phrase
	        bufin = bufin.reverse();
		
	        //reverse each word in resultant reversed phrase
	        for (rindex = 0; rindex <= bufin.length(); rindex++)
	        {
	            if (rindex == bufin.length() || bufin.charAt(rindex) == ' ')
	            {
	                bufin = iterativeReverse(bufin, lindex, rindex - 1);
	                lindex = rindex + 1;
	            }
	        }
	    }
	    return bufin;
	}
	
	static private StringBuffer iterativeReverse(StringBuffer intext, int lindex, int rindex)
	{
	    char tempc;
	    while (lindex < rindex)
	    {
	        tempc = intext.charAt(lindex);
	        intext.setCharAt(lindex++,intext.charAt(rindex));
	        intext.setCharAt(rindex--,tempc);
	    }
	    return intext;
	}

	static private String reverseRecursively(String str) {
        //base case to handle one char string and empty string
        if (str.length() < 2) {
            return str;
        }

        return reverseRecursively(str.substring(1)) + str.charAt(0);
    }

	
	static private StringBuffer removeWhitespaceInplace(StringBuffer intext)
	{
		int sindex= 0;
		int orgindex = 0;
	    while (orgindex < intext.length())
	    {
	    	if(!(Character.isWhitespace(intext.charAt(orgindex)))){
	        	intext.setCharAt(sindex++,intext.charAt(orgindex));
	    	
	        }
	    	orgindex++;
	    }
	    intext.setLength(sindex);
	    return intext;
	}
	//("AAA BBB" -> "A B")
	static private StringBuffer removeDuplicateChars(StringBuffer intext)
	{
		int sindex= 0;
		char temp = intext.charAt(sindex++);
		int orgindex = sindex + 1;
	    while (orgindex < intext.length())
	    {
	    	if(temp != intext.charAt(orgindex)){
	    		temp = intext.charAt(orgindex);
	        	intext.setCharAt(sindex++,temp);
	        }
	    	orgindex++;
	    }
	    intext.setLength(sindex);
	    return intext;
		
	}
	
	static private Character firstNonRepeatedCharacter(String str)
	{
        HashMap<Character,Integer>  characterhashtable= 
                     new HashMap<Character ,Integer>();
        int i,length ;
        Character c ;
        length= str.length();  // Scan string and build hash table
	    for (i=0;i < length;i++)
	    {
	        c=str.charAt(i);
	        if(characterhashtable.containsKey(c))
	        {
	            // increment count corresponding to c
	            characterhashtable.put(  c ,  characterhashtable.get(c) +1 );
	        }
	        else
	        {
	            characterhashtable.put( c , 1 ) ;
	        }
	    }
	    // Search characterhashtable in in order of string str
	    
	    for (i =0 ; i < length ; i++ )
	    {
	        c= str.charAt(i);
	        if( characterhashtable.get(c)  == 1 )
	        return c;
	    }
	    return null ;
	}
	
}

/** possible future work*/

/*
public class MatcherExample {

    public static void main(String[] args) {

        String text    =
            "This is the text to be searched " +
            "for occurrences of the http:// pattern.";

        String patternString = ".*http://.*";

        Pattern pattern = Pattern.compile(patternString);

        Matcher matcher = pattern.matcher(text);
        boolean matches = matcher.matches();
    }
}

*/




/*
//example 2 using List and Collections
public static String reverseWords (String s)
{
    String delimiter = " ";
    List<String> words = Arrays.asList(s.split(delimiter));
    Collections.reverse(words);
    return String.join(delimiter, words);
}

public static void main(String[] args)
{
    System.out.println(reverseWords("He is the one"));
}


// the following reverses words - keeping them in place...  "hello brave" becomes "olleh evarb"
tStr.reverseWordByWord(str)

public String reverseWordByWord(String str){
        int strLeng = str.length()-1;
        String reverse = "", temp = "";

        // for entire length of string
        for(int i = 0; i <= strLeng; i++){
            // look at each character - for space (or end) - adding it to the end of the temp word being created
            temp += str.charAt(i);
            if((str.charAt(i) == ' ') || (i == strLeng)){
                for(int j = temp.length()-1; j >= 0; j--){
                    reverse += temp.charAt(j);
                    if((j == 0) && (i != strLeng))
                        reverse += " ";
                }
                temp = "";
            }
        }
        return reverse;
    }
*/



//More Advanced Topics (Strings):
//You may be asked about using Unicode strings. What the interviewer is usually looking for is:
//each character will be two bytes (so, for example, char lookup table you may have allocated needs to be expanded from 256 to 256 * 256 = 65536 elements)
//that you would need to use wide char types (wchar_t instead of char)
//that you would need to use wide string functions (like wprintf instead of printf)
//Guarding against being passed invalid string pointers or non nul-terminated strings (using walking through a string and catching memory exceptions

