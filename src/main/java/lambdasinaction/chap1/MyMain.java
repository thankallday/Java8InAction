package lambdasinaction.chap1;

import java.io.File;

public class MyMain //page 47
{
    //create a main method to list all the hidden files in the current directory
    public static void main(String[] args) {
        // print current directory
        System.out.println("Current directory: " + System.getProperty("user.dir"));
        // List all files in the current directory
        java.io.File dir = new java.io.File(".");
        String[] files = dir.list((d, name) -> name.startsWith("."));
        if (files != null) {
            for (String file : files) {
                System.out.println("Way 1 Copilot --> " + file);
            }
        } else {
            System.out.println("No hidden files found.");
        }
        // way 2
        File[] hiddenFiles = new File(".").listFiles((d, name)-> name.startsWith("."));
        if (hiddenFiles != null) {
            for (File file : hiddenFiles) {
                System.out.println("Way2 --> " + file.getName() + " is hidden: " + file.isHidden());
            }
        } else {
            System.out.println("No hidden files found.");
        }
        // way 3 page 47
        File[] hiddenFiles2 = new File(".").listFiles(File::isHidden);
        if (hiddenFiles2 != null) {
            for (File file : hiddenFiles2) {
                System.out.println("Way3 --> " + file.getName() + " is hidden: " + file.isHidden());
            }
        } else {
            System.out.println("No hidden files found.");
        }

    }
}
