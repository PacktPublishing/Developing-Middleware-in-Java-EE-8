package com.example;

import static java.util.Arrays.asList;

import java.util.HashSet;
import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;

@ApplicationScoped
public class MyIdentityStore implements IdentityStore {
    public CredentialValidationResult validate(UsernamePasswordCredential userCredential) {
        if (userCredential.compareTo("Tom", "tomtom")) {
            return new CredentialValidationResult("admin",
                    new HashSet<String>(asList("user")));
        }
        return CredentialValidationResult.INVALID_RESULT;
    }
}
