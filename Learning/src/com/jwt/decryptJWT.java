/*
 * This class uses the external libraries for jwt to decode jwt token
 */

package com.jwt;

import com.nimbusds.jose.Header;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTParser;
import com.nimbusds.jwt.JWTClaimsSet;

import java.util.Scanner;

public class decryptJWT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*
        * JWT Token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMjM0IiwiYXVkIjpbImFkbWluIl0sImlzcyI6Im1hc29uLm1ldGFtdWcubmV0IiwiZXhwIjoxNTc0NTEyNzY1LCJpYXQiOjE1NjY3MzY3NjUsImp0aSI6ImY3YmZlMzNmLTdiZjctNGViNC04ZTU5LTk5MTc5OWI1ZWI4YSJ9.EVcCaSqrSNVs3cWdLt-qkoqUk7rPHEOsDHS8yejwxMw
        */

        System.out.print("Enter the JWT token: ");
        String jwtToken = sc.next();

        try {
            /*
             * Parse the JWT token
             */
            JWT jwt = JWTParser.parse(jwtToken);

            /*
             * Retrieve the JWT claims set
             */
            JWTClaimsSet payload = jwt.getJWTClaimsSet();
            Header header = jwt.getHeader();

            /*
             * Print the decoded claims
             */
            System.out.println("The header :" + header);
            System.out.println("The payload :" + payload);
            /*
             * System.out.println("Issuer: " + claimsSet.getIssuer());
             * System.out.println("Subject: " + claimsSet.getSubject());
             * System.out.println("Expiration Time: " + claimsSet.getExpirationTime());
             */

        } catch (Exception e) {
            /*
             * Handle parsing exceptions
             */
            System.out.println("Exception is " + e);
        }
    }
}
