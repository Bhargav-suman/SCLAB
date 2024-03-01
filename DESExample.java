import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class DESExample {
    public static void main(String[] args) throws Exception {
        String plainText = "Hello, DES!";
        String keyString = "SecretKey"; // 8-byte DES key
        byte[] keyData = keyString.getBytes();

        DESKeySpec keySpec = new DESKeySpec(keyData);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey key = keyFactory.generateSecret(keySpec);

        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());

        System.out.println("Encrypted: " + new String(encryptedBytes));

        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        System.out.println("Decrypted: " + new String(decryptedBytes));
    }
}

