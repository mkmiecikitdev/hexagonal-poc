package consoleinmemory;

import consoleinmemory.config.ConsoleAppModule;
import consoleinmemory.presentation.ConsoleApp;

public class Main {
    public static void main(String[] args) {
        new ConsoleApp(new ConsoleAppModule()).start();
    }
}

