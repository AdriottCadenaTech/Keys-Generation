package party_a;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.security.MessageDigest;

public class Hashing 

{
    public static void main(String[] args)throws Exception
    {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        @SuppressWarnings("resource")
		FileInputStream fis = new FileInputStream("D:/ad/En/KeyPair/text.txt");

        byte[] dataBytes = new byte[1024];

        int nread = 0;
        
        while ((nread = fis.read(dataBytes)) != -1) {        
        md.update(dataBytes, 0, nread);
        };
        byte[] mdbytes = md.digest();


        StringBuffer hexString = new StringBuffer();
    	for (int i=0;i<mdbytes.length;i++) {
    	  hexString.append(Integer.toHexString(0xFF & mdbytes[i]));
    	}

    	System.out.println("Hex format : " + hexString.toString());
    	
    	
    	  BufferedWriter bwr = new BufferedWriter(new FileWriter(new File("D:/ds/ProcessFlow/output.txt")));
    	   
        bwr.write(hexString.toString());
       
        
        bwr.flush();
       
        
        bwr.close();
   
    }
}