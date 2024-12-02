package it.unibo.mvc;

public final class Main {
    private Main() { }

    public static void main(String[] args) { 
        new SimpleGUI(new Controller()).start();
    }
}
