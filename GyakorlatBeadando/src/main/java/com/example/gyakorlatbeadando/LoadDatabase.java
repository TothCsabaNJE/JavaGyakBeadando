package com.example.gyakorlatbeadando;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.util.Scanner;

@Configuration
public class LoadDatabase {
    private static final Logger log= LoggerFactory.getLogger(LoadDatabase.class);
    @Bean
    CommandLineRunner initSuti(SutiRepository repository) {
        return args -> {
            if(repository.count() == 0) {
                File sutiData=new File("src/main/resources/static/suti.txt");
                Scanner scanner=new Scanner(sutiData);
                scanner.nextLine();
                while(scanner.hasNextLine()) {
                    String[] line= scanner.nextLine().split("\t");
                    if(line[3].equals("-1")) line[3]="true"; else line[3]="false";
                    repository.save(new Suti(Long.parseLong(line[0]), line[1], line[2], Boolean.parseBoolean(line[3])));
                }
                scanner.close();
            }
        };
    }

    @Bean
    CommandLineRunner initAr(ArRepository repository) {
        return args -> {
            if(repository.count() == 0) {
                File arData=new File("src/main/resources/static/ar.txt");
                Scanner scanner=new Scanner(arData);
                scanner.nextLine();
                while(scanner.hasNextLine()) {
                    String[] line= scanner.nextLine().split("\t");
                    repository.save(new Ar(Long.parseLong(line[0]), Long.parseLong(line[1]), Integer.parseInt(line[2]), line[3] ));
                }
                scanner.close();
            }
        };
    }

    @Bean
    CommandLineRunner initTartalom(TartalomRepository repository) {
        return args -> {
            if(repository.count() == 0) {
                File tartalomData=new File("src/main/resources/static/tartalom.txt");
                Scanner scanner=new Scanner(tartalomData);
                scanner.nextLine();
                while(scanner.hasNextLine()) {
                    String[] line= scanner.nextLine().split("\t");
                    repository.save(new Tartalom(Long.parseLong(line[0]), Long.parseLong(line[1]), line[2] ));
                }
                scanner.close();
            }
        };
    }

}
