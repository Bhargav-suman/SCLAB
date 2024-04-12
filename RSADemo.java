import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.*;

public class RSADemo{
    public final static BigInteger one = new BigInteger("1");
    public final static SecureRandom random = new SecureRandom();
    
    private BigInteger privatekey;
    private BigInteger publickey;
    private BigInteger modulus;
    
    RSADemo(int N){
        BigInteger p = BigInteger.probablePrime(N/2,random);
        BigInteger q = BigInteger.probablePrime(N/2,random);
        BigInteger phi = (p.subtract(one)).multiply(q.subtract(one));
        System.out.println("prime p="+p);
        System.out.println("prime q="+q);
        System.out.println("phi="+phi);
        
        modulus = p.multiply(q);
        publickey = new BigInteger("65537");
        privatekey = publickey.modInverse(phi);
    }
    
    BigInteger encrypt(BigInteger msg){
        return msg.modPow(publickey , modulus);
    }
    
    BigInteger decrypt(BigInteger encrypt){
        return encrypt.modPow(privatekey , modulus);
    }
    
    public String toString(){
        String s = "";
        s += "public = "+ publickey +"\n";
        s += "private = "+ privatekey +"\n";
        s += "modulus = "+ modulus +"\n";
        return s;
    }
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter key length:");
        int N = sc.nextInt();
        RSADemo key = new RSADemo(N);
        System.out.println("key="+key);
        BigInteger msg = new BigInteger("8");
        BigInteger enc = key.encrypt(msg);
        BigInteger dec = key.decrypt(enc);
        System.out.println("msg:"+msg);
        System.out.println("encrypted:"+enc);
        System.out.println("decrypted:"+dec);
    }
}
