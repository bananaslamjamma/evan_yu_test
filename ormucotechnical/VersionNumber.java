
package ormucotechnical;
import java.util.*;
/**
 * February 19th 2020
 * @author EVAN YU
 */
public class VersionNumber {

    public static void main(String[] args) {
        String version1 = "0.1.8";
        String version2 = "0.1.7";
        
          
        int result = compareVersion(version1, version2);
        if (result < 0) {
            System.out.println(version2 + " is greater");
        } else if (result > 0) {
            System.out.println(version1 + " is greater");
        } else {
            System.out.println("Both are equal");
        }
    }

    static int compareVersion(String str1, String str2) {
        //split the string using a delimiter
        String[] version1 = str1.split("\\.");
        String[] version2 = str2.split("\\.");
        int num1 = 0;
        int num2 = 0;
        //get the length of longest string
        int length = Math.max(version1.length, version2.length);
        for (int i = 0; i < length; i++) {
            //if one string is longer, don't parse Int
            if (i < version1.length) {
                num1 = Integer.parseInt(version1[i]);
            } else {
                //if length is shorter, set current val to zero
                num1 = 0;
            }
            //if one string is longer, don't parse Int
            if (i < version2.length) {
                num2 = Integer.parseInt(version2[i]);
            } else {
                //if length is shorter, set current val to zero
                num2 = 0;
            }
            int result = Integer.compare(num1, num2);
            //compare current index, return result if not equal
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }

}
