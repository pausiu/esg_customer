package com.esg.util;
import java.util.*;
import java.util.regex.*;

public class StringCalculator {

	public int Add(String numbers){
        String delimiter = ",|\n", negativeStr = "", splitNo[];
        ArrayList<Integer> negativeNumbers = new ArrayList<>();

        numbers = numbers.replaceAll(" ", "");

        if (numbers == "") return 0;

        int startIndex = numbers.indexOf("//");
        int endIndex = numbers.indexOf("\\n");

        if (startIndex != -1) {
            delimiter = numbers.substring(startIndex + 2, endIndex);
            numbers = numbers.substring(endIndex + 2);

            if (delimiter.endsWith("]") && delimiter.indexOf("[") == 0) {
                Pattern pattern = Pattern.compile("\\[(.*?)\\]");
                Matcher matcher = pattern.matcher(delimiter);

                int groupCount = matcher.groupCount();
                while (matcher.find()) {
                    for (int i = 0; i <= groupCount; i++) {
                        String m = matcher.group(i);
                        numbers = numbers.replaceAll(Pattern.quote(m), ",");
                    }
                }
                delimiter = ",";
            }

            splitNo = numbers.split(Pattern.quote(delimiter));
        }
        else
            splitNo = numbers.split(delimiter);

        int total = 0;
        for (String n : splitNo) {
			if (!n.isBlank()) {
	            Integer current = Integer.parseInt(n);
	            if (current < 0) {
	                negativeNumbers.add(current);
	                negativeStr += (String.valueOf(current) + " ");
	            }
	            if(current < 1001) total += current;
			}
        }

        CheckNegativeValues.throwExceptionIfNegativeExist(negativeStr);
        
        return total;
    }
}