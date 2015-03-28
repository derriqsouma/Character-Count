package characterCount;

import org.apache.commons.lang.ArrayUtils;

import java.util.*;

/**
 * Created by derrick on 3/27/15.
 */
public class CharacterCount {
    static Character getMostFrequentCharacter(String inputString)
    {
        Character mostFrequent = null;
        HashMap<Character,Integer> characterCountMap = new HashMap<Character, Integer>();

        char[] puntuation = {',','.',';',':','-','_','\'','"'};//array of punctuation marks

        inputString = inputString.toLowerCase().replaceAll("\\s+", "");//change the input string to lower case

        char[] c=inputString.toCharArray();//create an array of characters from the input string

        /**
         *  loop through the array of characters to remove any present punctuation mark
         */
        for (int i=0; i<= c.length; i++){
            for (int j=0;j<puntuation.length;j++){
                c = ArrayUtils.removeElement(c, puntuation[j]);
            }
        }

        int loopcount=0;
        int count=0;

        /**
         *  loop through the array of characters to count the number of each character present
         */
        for(int i=0;i<c.length;i++)
        {
            boolean flag=true;
            for(int k=0;k<i;k++){
                if(c[i]==(inputString.charAt(k)))
                    flag = false;
            }
            if(flag){
                for(int j=0;j<inputString.length();j++)
                {
                    if (!Character.isDigit(inputString.charAt(j))) {
                        if (c[i] == inputString.charAt(j))
                            count = count + 1;
                    }
                }

                characterCountMap.put(c[i],count);
//                System.out.println(c[i]+"\t"+(count));
                count=0;
                loopcount++;
            }
        }

        int maxValueInMap=(Collections.max(characterCountMap.values()));  // This returns maximum value in the Hashmap

        Set<Map.Entry<Character, Integer>> hashSet=characterCountMap.entrySet();
        for(Map.Entry entry:hashSet ) {
            if (entry.getValue().toString().equalsIgnoreCase(String.valueOf(maxValueInMap))){
                mostFrequent = (Character) entry.getKey();
            }
        }

        return mostFrequent;
    }

    public static void main(String[] args)
    {
        String inputString;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string :");
        inputString = in.nextLine();

        Character mostFrequent = getMostFrequentCharacter(inputString);
        System.out.println("\n\nThe most frequent character is : "+ mostFrequent);
    }
}
