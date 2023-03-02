import java.util.*;

public class Example {
    public static void main(String[] args) {
        // create an ArrayList of strings
        ArrayList<String> list = new ArrayList<>();
        list.add("foo|123|bar|baz|qux");
        list.add("baz|456|qux|foo|bar");
        list.add("bar|789|foo|qux|baz");

        // define a custom comparator
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // extract the substring between the 2nd and 3rd "|" delimiter
                String sub1 = s1.split("\\|")[2];
                String sub2 = s2.split("\\|")[2];

                // compare the extracted substrings
                return sub1.compareTo(sub2);
            }
        };

        // sort the ArrayList using the custom comparator
        Collections.sort(list, comparator);

        // print the sorted list
        for (String s : list) {
            System.out.println(s);
        }
    }
}
