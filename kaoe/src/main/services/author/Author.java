package main.services.author;

import main.java.AuthorName;
import main.services.masterdata.IValidateName;
import main.services.masterdata.ValidateName;

import java.util.ArrayList;
import java.util.List;


public class Author implements IAuthor {

    /**
     * @param name Different variants of one fullname of author.
     * @return AuthorName, first names(String) and last name(String)
     * If Author cannot be found, firstnames = "unknown" and lastname = "Unknown"
     * If internal error occurs, firstnames = "Exception" and lastname = "exception message"
     */
    public AuthorName getAuthorFirstAndLastName(String name){
        IValidateName validateService = new ValidateName();

        AuthorName autName = validateService.validate(prepareFullName(name));

        return autName;
    }

    /**
     *
     * @param namesString Different variants of 1 or more fullnames of author. fullnames separated by ";"
     * @return  A list of AuthorName.
     * If one Author cannot be found, first names = "unknown" and last name = "Unknown"
     * If internal error occurs the first and only record in list, AuthorName, will hold information:
     * firstnames = "Exception" and last name = "exception message"
     */
    public List<AuthorName> getAuthorFirstAndLastNameList(String namesString){

        List<AuthorName> nameList = new ArrayList<AuthorName>();

        IValidateName validateService = new ValidateName();

        try {
            String[] names = namesString.split(";");
            for (String name : names) {
                AuthorName autName = validateService.validate(prepareFullName(name));
                nameList.add(autName);
            }
        }catch( Exception e){
            nameList.add(new AuthorName("Exception", e.getMessage()));
            e.printStackTrace();
        }
        return nameList;
    }

    /**
     * If one and only one "," exist in fullName, first and last names has to be swapped.
     * @param fullName Different variants of one fullname of author.
     * @return Returns fullname = firstnames + space + lastname.
     * If internal error occurs fullname returned unprocessed
     *
     */
    private String prepareFullName(String fullName){
        String preparedFullName = fullName;

        try {
            String[] names = fullName.split(",");
            if (names.length == 2) {
                preparedFullName = names[1].trim() + " " + names[0].trim();
            }
        } catch( Exception e){
            preparedFullName = fullName;
            e.printStackTrace();
        }
        return preparedFullName;
    }
}

