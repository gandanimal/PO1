package core;

import core.exception.BadEntrySpecificationException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Parser {

    private Library _library;

    Parser(Library lib) {
        _library = lib;
    }

    void parseFile(String filename) throws IOException, BadEntrySpecificationException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = reader.readLine()) != null)
                parseLine(line);
        }
    }

    private void parseLine(String line) throws BadEntrySpecificationException {
        String[] components = line.split(":");

        switch(components[0]) {
            case "DVD":
                parseDVD(components, line);
                break;

            case "BOOK":
                parseBook(components, line);
                break;
            case "USER":
                parseUser(components, line);
                break;

            default:
                throw new BadEntrySpecificationException("Invalid type " + components[0] +
                        " in line " + line);
        }
    }

    private void parseDVD(String[] components, String line) throws BadEntrySpecificationException {
        if (components.length != 7)
            throw new  BadEntrySpecificationException("Wrong number of fields (6) in " + line);
        Dvd dvd = new Dvd(components[1], components[2], Integer.parseInt(components[3]),
                Category.valueOf(components[4]), Integer.parseInt(components[5]),
                Integer.parseInt(components[6]));
        _library.newWork(dvd);

        // add dvd to _library
    }

    private void parseBook(String[] components, String line) throws BadEntrySpecificationException {
        if (components.length != 7)
            throw new  BadEntrySpecificationException("Wrong number of fields (6) in " + line);

        Book book = new Book(components[1], components[2], Integer.parseInt(components[3]),
                Category.valueOf(components[4]), Integer.parseInt(components[5]),
                Integer.parseInt(components[6]));
        _library.newWork(book);

        // add book to _library
    }

    private void parseUser(String[] components, String line) throws BadEntrySpecificationException {
        if (components.length != 3)
            throw new  BadEntrySpecificationException("Wrong number of fields (2) in " + line);
        try {
            User user = new User(components[1], components[2]);
            _library.newUser(user);
        }catch(Exception e){
            System.out.println("Failed to Register User\n");
            e.printStackTrace();
        }

    }

}