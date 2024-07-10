package utils;

public class SafeReading {
    public static int readInt(String message) {
        int res = 0;
        boolean read = false;
        while (!read) {
            try {
                System.out.print(message);
                res = Integer.valueOf(ScannerHolder.getInstance().getScanner().nextLine());
                read = true;
            }
            catch (Exception err) {
                System.out.println("Valor inválido.");
            }
        }
        return res;
    }
}
