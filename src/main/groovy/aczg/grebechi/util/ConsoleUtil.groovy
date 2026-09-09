package aczg.grebechi.util

class ConsoleUtil {
    static final String RESET = "\u001B[0m"
    static final String RED = "\u001B[31m"
    static final String GREEN = "\u001B[32m"
    static final String YELLOW = "\u001B[33m"
    static final String BLUE = "\u001B[34m"
    static final String CYAN = "\u001B[36m"

    static void limparTela() {
        try {
            String os = System.getProperty("os.name")
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor()
            } else {
                print("\033[H\033[2J")
                System.out.flush()
            }
        } catch (Exception e) {
            println "\n" * 50
        }
    }

    static void printErro(String msg) {
        println RED + msg + RESET
    }

    static void printSucesso(String msg) {
        println GREEN + msg + RESET
    }

    static void printAviso(String msg) {
        println YELLOW + msg + RESET
    }

    static void printTitulo(String msg) {
        println CYAN + msg + RESET
    }

    static void pausar(Scanner scanner) {
        printAviso("\nPressione [ENTER] para continuar...")
        scanner.nextLine()
    }
}
