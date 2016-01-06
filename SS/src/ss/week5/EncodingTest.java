package ss.week5;

import java.util.Arrays;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

/**
 * A simple class that experiments with the Hex encoding
 * of the Apache Commons Codec library.
 *
 */
public class EncodingTest {
    public static void main(String[] args) throws DecoderException {
        String input = "Hello Big World";

        System.out.println(Hex.encodeHexString(input.getBytes()));
        String input2 = new String();
        /* input2 = Een String die gecodeerd is volgens het "HEX Principe"
         * Deze "HEX String" wordt omgezet naar een Array van characters (toCharArray)
         * Deze Char[] wordt omgezet naar Byte[] terwijl het wordt gedocodeerd(Hex.decodeHex)
         * En de classe String kan van bytes de originele zin maken.
         */
        String verassing = "010203040506";
        input2 = "4d6f64756c652032";
        System.out.println(new String(Base64.encodeBase64(Hex.decodeHex(verassing.toCharArray()))));
        
        // Bae64  
        String base64input = "Hello World";
        
        // Hello world wordt omgezet naar Base64 string genaamd next.

        System.out.println(new String(Base64.encodeBase64(verassing.getBytes())));
        
        String echteverassing = "U29mdHdhcmUgU31zdGVtcw==";
        System.out.println(new String(Base64.decodeBase64(echteverassing.getBytes())));
    }
}
