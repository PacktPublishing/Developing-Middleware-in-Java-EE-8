package com.example;

import static javax.security.enterprise.identitystore.CredentialValidationResult.Status.VALID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import javax.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStoreHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@ApplicationScoped
public class MyAuthMechanism  implements HttpAuthenticationMechanism {
    @Inject
    private IdentityStoreHandler idStoreHandler;

    public AuthenticationStatus validateRequest(HttpServletRequest req,
                                                HttpServletResponse res,
                                                HttpMessageContext context) {
        CredentialValidationResult result = idStoreHandler.validate(
                new UsernamePasswordCredential(
                        req.getParameter("name"), req.getParameter("password")));
        if (result.getStatus() == VALID) {
            return context.notifyContainerAboutLogin(result);
        } else {
            return context.responseUnauthorized();
        }
    }
}