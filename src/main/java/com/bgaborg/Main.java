package com.bgaborg;

import com.bgaborg.liveness.LivenessPart;
import com.bgaborg.synchronization.SynchronizationPart;
import com.bgaborg.threadobjects.ThreadObjectsPart;

import java.io.BufferedInputStream;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by bg
 */
public class Main {

    static LinkedList<AppPart> examples = new LinkedList<>();

    public static void main(String[] args) {
        examples.add(new ThreadObjectsPart());
        examples.add(new SynchronizationPart());
        examples.add(new LivenessPart());

        try {
            String input = "";
            while (!input.equals("q")) {
                System.out.println("Java Concurrency Examples AIO" +
                        "\n\nChoose from:");

                for (int i = 0; i < examples.size(); i++) {
                    System.out.printf("%d.: %s\n", i, examples.get(i).getName());
                }

                Scanner scanner = new Scanner(System.in);
                input = scanner.nextLine();
                try {
                    int inx = Integer.parseInt(input);
                    examples.get(inx).startExample();
                } catch (NumberFormatException e) {
                    System.out.println("Input not an integer: " + input);
                    System.out.println("Quit with 'q'\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.exit(0);
    }
}
