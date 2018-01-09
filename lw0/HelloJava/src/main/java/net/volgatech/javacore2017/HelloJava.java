package net.volgatech.javacore2017;

import java.io.File;

public class HelloJava {
    public static void main(String[] args) {
        String osName = System.getProperty("os.name");
        String osVersion = System.getProperty("os.version");
        String javaVersion = System.getProperty("java.version");
        String jrePath = System.getProperty("java.home");
        File file = new File(jrePath);
        File[] javaPathChildren = file.getParentFile().listFiles();
        String jdkPath = "";

        for(File child : javaPathChildren)
        {
            if (child.getName().contains("jdk"))
            {
                jdkPath = child.getAbsolutePath();
                break;
            }
        }
        System.out.print("Hello, Java from");
        for(String arg : args)
        {
            System.out.print(" " + arg);
        }
        System.out.println();
        System.out.println(osName + " " + osVersion + " " + javaVersion + " " + jdkPath);
    }
}