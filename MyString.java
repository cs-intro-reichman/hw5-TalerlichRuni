import java.util.Random;

/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        String hello = "hello";
        System.out.println(countChar(hello, 'h'));
        System.out.println(countChar(hello, 'l'));
        System.out.println(countChar(hello, 'z'));
        System.out.println(spacedString(hello));
        //// Put your other tests here.
    }

    /**
     * Returns the number of times the given character appears in the given string.
     * Example: countChar("Center",'e') returns 2 and countChar("Center",'c') returns 0. 
     * 
     * @param str - a string
     * @param c - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char c) {
        int counter=0;
        if (str!=null)
        {
            for (int i=0;i<str.length();i++)
            if (str.charAt(i)==c) counter++;
        }
        return counter;
    
    }

    /** Returns true if str1 is a subset string str2, false otherwise
     *  Examples:
     *  subsetOf("sap","space") returns true
     *  subsetOf("spa","space") returns true
     *  subsetOf("pass","space") returns false
     *  subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2)
    {
    int counter=0;
    if(str1.length()>str2.length())return false;
    if (str2!=null)
    {
        for (int j = 0; j < str1.length(); j++)
        {
        if (countChar(str2, str1.charAt(j))>0)
        {
        counter++;
        String remove1=str1.charAt(j)+""; 
        str2=remove(str2, remove1);       
        }
        } 
        }
        if (counter<str1.length()) return false;
        return true;
    }   

    /** Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character. 
     * Example: spacedString("silent") returns "s i l e n t"
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        if (str != null) {
            String result = "";
            for (int i = 0; i < str.length(); i++) {
                result += str.charAt(i);
                if (i < str.length() - 1) {
                    result += ' ';
                }
            }
            return result;
        }
        return str;
    }
    
  
    /**
     * Returns a string of n lowercase letters, selected randomly from 
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * Example: randomStringOfLetters(3) can return "zoo"
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
    String random = "";
    Random rand = new Random();
    for (int i = 0; i < n; i++) {
        int location = 97 + rand.nextInt(26);
        random += (char) location;
    }
    return random;
}

    /**
     * Returns a string consisting of the string str1, minus all the characters in the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: remove("meet","committee") returns "comit" 
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String str1, String str2) {
        String updatestr1 = "";
        String updatestr2 = "";
        for (int i=0;i<str1.length();i++)
        {
        if (countChar(str2, str1.charAt(i))>0) 
        {
        str2=removeChar(str2, str1.charAt(i));
        str1=removeCharAt(str1,i);
        i--;
        }
        }
        return str1;
    }

    public static String removeCharAt(String str, int location) {
        if (str == null || location < 0 || location >= str.length()) {
            return str;
        }
        return str.substring(0, location) + str.substring(location + 1);
    }

    public static String removeChar(String str, char letter) {
        if (str == null || letter == 0) {
            return str;
        }
        for (int i=0;i<str.length();i++)
        {
            if(str.charAt(i)==letter)
            {
            str = str.substring(0, i) + str.substring(i + 1);
            break;
            }
        }
        return str;
    }
    
    /**
     * Returns a string consisting of the given string, with the given 
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s","cat") can return "scat", or "csat", or "cast", or "cats".  
     * @param ch - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) {
         // Generate a random index between 0 and str.length()
         int randomIndex = (int) (Math.random() * (str.length() + 1));
         // Insert the character at the random index
         String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);
         return result;
    }    

    public static String lowerCase(String str) {
        int length =str.length();
        char[] copy = str.toCharArray();
        for(int i=0;i<length;i++)
        {
        if (str.charAt(i)>='A' && str.charAt(i)<='Z')
        {
            copy[i] = (char)(copy[i] + 32);
        }
        }
        return new String(copy);
        }
}
