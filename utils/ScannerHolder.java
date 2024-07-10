package utils;

import java.util.Scanner;

public class ScannerHolder {
    private static ScannerHolder instance;
    private Scanner scanner;

    public ScannerHolder() {
        this.scanner = new Scanner(System.in);
    }

    public static ScannerHolder getInstance() {
        if (instance == null) {
            instance = new ScannerHolder();
        }

        return instance;
    }

    public Scanner getScanner() {
        return this.scanner;
    }
}
