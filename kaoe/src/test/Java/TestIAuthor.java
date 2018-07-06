package test.Java;

import main.java.AuthorName;
import main.services.author.IAuthor;
import main.services.author.Author;

import java.util.List;

public class TestIAuthor {

    public static void main(String[] args) {

        IAuthor service = new Author();

        System.out.println("Test of getAuthorFirstAndLastNameList");
        AuthorName autName = service.getAuthorFirstAndLastName("John Doe");
        System.out.println(autName.getFirstNames() + " " + autName.getLastName());
        autName = service.getAuthorFirstAndLastName("Doe, John");
        System.out.println(autName.getFirstNames() + " " + autName.getLastName());
        autName = service.getAuthorFirstAndLastName("Hans-Christian Jensen");
        System.out.println(autName.getFirstNames() + " " + autName.getLastName());
        autName = service.getAuthorFirstAndLastName("H-C Jensen");
        System.out.println(autName.getFirstNames() + " " + autName.getLastName());
        autName = service.getAuthorFirstAndLastName("P. H. Kristensen");
        System.out.println(autName.getFirstNames() + " " + autName.getLastName());
        autName = service.getAuthorFirstAndLastName("Kristensen, P. H.");
        System.out.println(autName.getFirstNames() + " " + autName.getLastName());
        autName = service.getAuthorFirstAndLastName("Peter Hans Kristensen");
        System.out.println(autName.getFirstNames() + " " + autName.getLastName());
        autName = service.getAuthorFirstAndLastName("Peter H. Kristensen");
        System.out.println(autName.getFirstNames() + " " + autName.getLastName());
        autName = service.getAuthorFirstAndLastName("Ørum");
        System.out.println(autName.getFirstNames() + " " + autName.getLastName());


        System.out.println("\n\nTest of getAuthorFirstAndLastNameList 001");
        List<AuthorName> autNameList001 = service.getAuthorFirstAndLastNameList("Peter H. Kristensen;Doe, John;John Doe;Klaus Ørum;Luisa;Peter Hans Kristensen;H-C Jensen");
        for (AuthorName name: autNameList001 ) {
            System.out.println(name.getFirstNames() + " " + name.getLastName());
        }

        System.out.println("\n\nTest of getAuthorFirstAndLastNameList 002");
        List<AuthorName> autNameList002 = service.getAuthorFirstAndLastNameList(null);
        for (AuthorName name: autNameList002 ) {
            System.out.println(name.getFirstNames() + " " + name.getLastName());
        }

        System.out.println("\n\nTest of getAuthorFirstAndLastNameList 003");
        List<AuthorName> autNameList003 = service.getAuthorFirstAndLastNameList("");
        for (AuthorName name: autNameList003 ) {
            System.out.println(name.getFirstNames() + " " + name.getLastName());
        }

        System.out.println("\n\nTest of getAuthorFirstAndLastNameList 004");
        List<AuthorName> autNameList004 = service.getAuthorFirstAndLastNameList("sss;ssss,,d,d,,dhgsjt;;glfsd,;;");
        for (AuthorName name: autNameList004 ) {
            System.out.println(name.getFirstNames() + " " + name.getLastName());
        }
    }
}
