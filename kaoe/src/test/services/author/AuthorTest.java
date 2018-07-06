package test.services.author;

import main.java.AuthorName;
import main.services.author.Author;
import main.services.author.IAuthor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AuthorTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAuthorFirstAndLastName() {
        IAuthor service = new Author();

        AuthorName autName = service.getAuthorFirstAndLastName("John Doe");
        assertEquals("John", autName.getFirstNames());
        assertEquals("Doe", autName.getLastName());

        autName = service.getAuthorFirstAndLastName("Doe, John");
        assertEquals("John", autName.getFirstNames());
        assertEquals("Doe", autName.getLastName());

        autName = service.getAuthorFirstAndLastName("Hans-Christian Jensen");
        assertEquals("Hans-Christian", autName.getFirstNames());
        assertEquals("Jensen", autName.getLastName());

        autName = service.getAuthorFirstAndLastName("H-C Jensen");
        assertEquals("Hans-Christian", autName.getFirstNames());
        assertEquals("Jensen", autName.getLastName());

        autName = service.getAuthorFirstAndLastName("P. H. Kristensen");
        assertEquals("P. H.", autName.getFirstNames());
        assertEquals("Kristensen", autName.getLastName());

        autName = service.getAuthorFirstAndLastName("Kristensen, P. H.");
        assertEquals("P. H.", autName.getFirstNames());
        assertEquals("Kristensen", autName.getLastName());

        autName = service.getAuthorFirstAndLastName("Peter Hans Kristensen");
        assertEquals("Peter Hans", autName.getFirstNames());
        assertEquals("Kristensen", autName.getLastName());

        autName = service.getAuthorFirstAndLastName("Peter H. Kristensen");
        assertEquals("Peter H.", autName.getFirstNames());
        assertEquals("Kristensen", autName.getLastName());

        autName = service.getAuthorFirstAndLastName("Klaus Ørum");
        assertEquals("Unknown", autName.getFirstNames());
        assertEquals("Unknown", autName.getLastName());

        autName = service.getAuthorFirstAndLastName("Luisa");
        assertEquals("Unknown", autName.getFirstNames());
        assertEquals("Unknown", autName.getLastName());
    }

    @Test
    public void getAuthorFirstAndLastNameList() {
        IAuthor service = new Author();

        List<AuthorName> autNameList = service.getAuthorFirstAndLastNameList("Peter H. Kristensen;Doe, John;John Doe;Klaus Ørum;H-C Jensen");
        assertEquals("Peter H.", autNameList.get(0).getFirstNames());
        assertEquals("Kristensen", autNameList.get(0).getLastName());

        assertEquals("John", autNameList.get(1).getFirstNames());
        assertEquals("Doe", autNameList.get(1).getLastName());

        assertEquals("John", autNameList.get(2).getFirstNames());
        assertEquals("Doe", autNameList.get(2).getLastName());

        assertEquals("Unknown", autNameList.get(3).getFirstNames());
        assertEquals("Unknown", autNameList.get(3).getLastName());

        assertEquals("Hans-Christian", autNameList.get(4).getFirstNames());
        assertEquals("Jensen", autNameList.get(4).getLastName());


        autNameList = service.getAuthorFirstAndLastNameList("");
        assertEquals("Unknown", autNameList.get(0).getFirstNames());
        assertEquals("Unknown", autNameList.get(0).getLastName());

        autNameList = service.getAuthorFirstAndLastNameList("sss;ssss,,d,d,,dhgsjt;;glfsd,;;");
        assertEquals("Unknown", autNameList.get(0).getFirstNames());
        assertEquals("Unknown", autNameList.get(0).getLastName());
        assertEquals("Unknown", autNameList.get(1).getFirstNames());
        assertEquals("Unknown", autNameList.get(1).getLastName());
        assertEquals("Unknown", autNameList.get(2).getFirstNames());
        assertEquals("Unknown", autNameList.get(2).getLastName());
        assertEquals("Unknown", autNameList.get(3).getFirstNames());
        assertEquals("Unknown", autNameList.get(3).getLastName());


        //Test OK, but causes an exception.... not pretty !!
        //autNameList = service.getAuthorFirstAndLastNameList(null);
        //assertEquals("Exception", autNameList.get(0).getFirstNames());
        //assertNull(autNameList.get(0).getLastName());
        }
}