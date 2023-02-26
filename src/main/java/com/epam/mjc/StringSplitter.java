package com.epam.mjc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source     source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        List<String> results = new ArrayList<>(List.of(source));
        for (String delimiter : delimiters) {
            List<String> tempResults = new ArrayList<>();
            for (String result : results) {
                tempResults.addAll(List.of(result.split(delimiter)));
            }
            results = tempResults.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
        }
        return results;
    }
}