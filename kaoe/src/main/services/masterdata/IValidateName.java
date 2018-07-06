package main.services.masterdata;

import main.java.AuthorName;

public interface IValidateName {

    AuthorName validate(String fullName);
}
