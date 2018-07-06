package main.services.masterdata;

import main.java.AuthorName;

import java.util.HashMap;
import java.util.Map;

public class ValidateName implements IValidateName{

    /**
     * Static Hastable containing prepared fullnames mapped to valid fullnames.
     * Could be considered as a database containing valid mappings.
     */
    private static final Map<String,String> validName =
            new HashMap<>();
    static{
        validName.put("John Doe", "John;Doe");
        validName.put("Hans-Christian Jensen", "Hans-Christian;Jensen");
        validName.put("H-C Jensen", "Hans-Christian;Jensen");
        validName.put("P. H. Kristensen", "P. H.;Kristensen");
        validName.put("Peter Hans Kristensen", "Peter Hans;Kristensen");
        validName.put("Peter H. Kristensen", "Peter H.;Kristensen");
    }

    /**
     *
     * @param fullName  Prepared fullname
     * @return If prepared fullname exist in "database" AuthorName (firstnames, lastname) is returned.
     * If prepared fullname does not exist in "database" AuthorName (Unknown, Unknown) is returned.
     * If an internal error occurs firstnames = "Exception" and lastName = exception message
     */
    @Override
    public AuthorName validate(String fullName) {

        AuthorName autName = new AuthorName("Unknown","Unknown");

        if (validName.containsKey(fullName)){
            try {
                String[] names = validName.get(fullName).split(";");
                autName.setFirstNames(names[0]);
                autName.setLastName(names[1]);
            }catch( Exception e){
                autName.setFirstNames("Exception");
                autName.setLastName(e.getMessage());
            }
        }
        return autName;
    }
}
