package com.pgp.decrypt;

import org.bouncycastle.openpgp.*;
import java.io.*;
import java.security.Security;

public class PGPEmailDecryption {
    public static void main(String[] args) {
        // Replace these with actual values
        String recipientPrivateKeyPath = "path/to/recipient/private-key.asc";
        String recipientPassphrase = "recipient_passphrase";
        String senderPublicKeyPath = "path/to/sender/public-key.asc";
        String encryptedEmail = "-----BEGIN PGP MESSAGE-----\n" +
                "Version: BCPG v1.67\n" +
                "\n" +
                "hQIMA9C+6PmoHvUaAQ/7BSxjq6hD0bTLjZT4OaKBd/CJKH97NTKFyFArQF8l+CQ8\n" +
                "yOIFC9fCq4//E6+eFH+fFMV4PB01QgZkIBvDl1f89E+DS2llh2ftoX1+L+MLoFDn\n" +
                "xX7rBlwIHckyjFZlmfbl5hS1JytOgsCjQunQAdVcKbZMe7gmM7sV4sVURZkOnraH\n" +
                "CIVJ8WjL3dH9sdYWGkA4qrGQtnNQw1Jv2oEKrJJCH0nCxNPPo5ZaQl+WrymGy5+D\n" +
                "iv7+K/nVhAAbVO48fNwv//Hl9jQwghbfYg0INo8Z+v3biMBgt7AanGYhW9iPDJ2P\n" +
                "8Q+x8L/y3dsySCA+zxpx6Z7bhlOL/6Wyr+RHFXy1aMkIzX3kyhEpwujV5d+6ugcR\n" +
                "cKEeExvAKveu2UbH2cnyw2RJMXkukF+ZWtS9I+oJ6WwZAAmrUVoqCIdfnvFGYAnb\n" +
                "WfSKN5Zntd9pjJ9CDMuks/l8rgGf48o5b02ycYeHm7mgls3yihQTWz9wZUgsmq/r\n" +
                "KrEwbRZv4sC7kpDulreS2Bc6y+1QL3kT5N5eEXQpcM94+oZw+2SMDJznyQfLRHDE\n" +
                "eb2qW4lM2aNvlmM28OeVJSsfy0C9mSyfi6DbLHX83MGThlEFs2ZUZRM4Rg5xv0zg\n" +
                "5s2psjCk1oMNLNXyygmR8BZCnlfC4GqYVSRf6SHzY8XZgk/klwU9XURoRLTgG1RJ\n" +
                "CwHjPLvISp36qXk/hwovvQeDZZG03UNgIomt7Xg+K0iJ+tfMKG8SRN3XlmKZpMBy\n" +
                "OXTTMHZSvqM3VM2vnbUwZZU9ySCi+Ki1yLdnw21YQnLRkFkyT37LoCcWKa8qMAhE\n" +
                "sPqSxQFK/J1JQ4qkV+Fl/C+NyZBWWuvFamJMKlJXqQWHVtDNzA==\n" +
                "=/fuJ\n" +
                "-----END PGP MESSAGE-----";

        try {
            // Load recipient's private key
            PGPSecretKeyRingCollection recipientSecretKeys = PGPKeyUtil.loadSecretKeyRingCollection(recipientPrivateKeyPath);
            PGPSecretKey recipientPrivateKey = PGPKeyUtil.extractPrivateKey(recipientSecretKeys, recipientPassphrase);

            // Load sender's public key
            PGPPublicKeyRingCollection senderPublicKeys = PGPKeyUtil.loadPublicKeyRingCollection(senderPublicKeyPath);
            PGPPublicKey senderPublicKey = PGPKeyUtil.extractPublicKey(senderPublicKeys);

            // Decrypt the email
            String decryptedEmail = PGPKeyUtil.decryptMessage(encryptedEmail, recipientSecretKeys, recipientPassphrase);

            // Print or process the decrypted email
            System.out.println("Decrypted Email:\n" + decryptedEmail);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
