package com.pgp.encrypt;

import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.PGPSecretKey;
import org.bouncycastle.openpgp.PGPSecretKeyRingCollection;

public class PGPEmailEncryption {
    public static void main(String[] args) {
        // Replace these with actual values
        String senderPrivateKeyPath = "path/to/sender/private-key.asc";
        String senderPassphrase = "sender_passphrase";
        String recipientPublicKeyPath = "path/to/recipient/public-key.asc";
        String emailPlainText = "Hello, this is an encrypted email!";

        try {
            // Load sender's private key
            PGPSecretKeyRingCollection senderSecretKeys = PGPKeyUtil.loadSecretKeyRingCollection(senderPrivateKeyPath);
            PGPSecretKey senderPrivateKey = PGPKeyUtil.extractPrivateKey(senderSecretKeys, senderPassphrase);

            // Load recipient's public key
            PGPPublicKeyRingCollection recipientPublicKeys = PGPKeyUtil.loadPublicKeyRingCollection(recipientPublicKeyPath);
            PGPPublicKey recipientPublicKey = PGPKeyUtil.extractPublicKey(recipientPublicKeys);

            // Encrypt the email
            String encryptedEmail = PGPKeyUtil.encryptMessage(emailPlainText, recipientPublicKey, senderPrivateKey);

            // Print or send the encrypted email
            System.out.println("Encrypted Email:\n" + encryptedEmail);

            // Decrypt the email (recipient's side)
            String decryptedEmail = PGPKeyUtil.decryptMessage(encryptedEmail, senderSecretKeys, senderPassphrase);

            // Print or process the decrypted email
            System.out.println("Decrypted Email:\n" + decryptedEmail);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
