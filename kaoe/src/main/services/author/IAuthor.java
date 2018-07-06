package main.services.author;

import main.java.AuthorName;

import java.util.List;

public interface IAuthor {

    AuthorName getAuthorFirstAndLastName(String inputNames);

    List<AuthorName> getAuthorFirstAndLastNameList(String inputNames);
}
