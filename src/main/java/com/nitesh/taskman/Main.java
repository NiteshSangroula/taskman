package com.nitesh.taskman;

import com.nitesh.taskman.repl.REPL;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to taskman");
        System.out.println("type help for more informations");
        REPL repl = new REPL();
        repl.run();
    }

    
}
