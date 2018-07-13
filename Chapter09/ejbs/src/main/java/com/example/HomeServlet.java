package com.example;

import java.io.IOException;
import javax.annotation.security.DeclareRoles;
import javax.inject.Inject;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.PasswordHash;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
@ServletSecurity(@HttpConstraint(rolesAllowed = "user"))
//@DatabaseIdentityStoreDefinition(
//        dataSourceLookup = "jdbc/secDS",
//        callerQuery = "select password from users where username = ?",
//        groupsQuery = "select ugroup from users where username = ?",
//        hashAlgorithm = javax.security.enterprise.identitystore. PasswordHash.class,
//        priority = 10
//)
//@DeclareRoles({ "user" })
public class HomeServlet extends HttpServlet {

    @Inject
    private SecurityContext securityContext;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        if (securityContext.hasAccessToWebResource("/anotherServlet", "GET")) {
            req.getRequestDispatcher("/anotherServlet").forward(req, res);
        } else {
            req.getRequestDispatcher("/logout").forward(req, res);
        }
//        resp.getOutputStream().println("Welcome to your home!");
    }
}
