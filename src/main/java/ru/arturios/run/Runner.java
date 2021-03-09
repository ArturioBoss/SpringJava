package ru.arturios.run;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.arturios.Commands;

import java.util.Scanner;

@Component
public class Runner implements CommandLineRunner {

    private final Commands commands;

    public Runner(Commands commands) {
        this.commands = commands;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("***********************");
        System.out.println("** ПРИВЕТ введи INFO **");
        System.out.println("***********************");
        while (true) {
            commands.doAuth(scanner.nextLine());


        }


//        String credentials = in.readUTF();

    }
}
