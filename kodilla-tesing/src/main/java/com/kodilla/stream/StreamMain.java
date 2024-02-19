package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;

public class StreamMain {
    public static void main(String[] args) {
        PoemBeautifier beautifier = new PoemBeautifier();


        beautifier.beautify("Hello", text -> "ABC" + text + "ABC");


        beautifier.beautify("Hello", String::toUpperCase);


        beautifier.beautify("Hello", text -> {
            StringBuilder sb = new StringBuilder();
            for (char c : text.toCharArray()) {
                sb.append(c).append(c);
            }
            return sb.toString();
        });


        beautifier.beautify("Hello", text -> {
            StringBuilder sb = new StringBuilder(text);
            return sb.reverse().toString();
        });
    }
}
