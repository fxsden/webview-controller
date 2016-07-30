package foxesden.webviewcontroller.rest;

import android.content.res.AssetManager;
import android.test.InstrumentationTestCase;
import android.util.Base64;

import junit.framework.TestCase;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * Created by henrique on 30/07/2016.
 */
public class ResponseTest extends InstrumentationTestCase {

    public void testGetDataAsBase64() throws Exception {
        // Url: file:///android_asset/test-page.html
        Response response = new Response();
        String test = "Isto é um teste de base 64 ... Isto é um teste de base 64 ... Isto é um teste de base 64 ... " +
                "Isto é um teste de base 64 ... Isto é um teste de base 64 ... Isto é um teste de base 64 ... " +
                "Isto é um teste de base 64 ... Isto é um teste de base 64 ... Isto é um teste de base 64 ... " +
                "Isto é um teste de base 64 ... Isto é um teste de base 64 ... Isto é um teste de base 64 ... " +
                "Isto é um teste de base 64 ... Isto é um teste de base 64 ... Isto é um teste de base 64 ... " +
                "Isto é um teste de base 64 ... Isto é um teste de base 64 ... Isto é um teste de base 64 ... " +
                "Isto é um teste de base 64 ... Isto é um teste de base 64 ... Isto é um teste de base 64 ... " +
                "Isto é um teste de base 64 ... Isto é um teste de base 64 ... Isto é um teste de base 64 ... " +
                "Isto é um teste de base 64 ... Isto é um teste de base 64 ... Isto é um teste de base 64 ... " +
                "Isto é um teste de base 64 ... Isto é um teste de base 64 ... Isto é um teste de base 64 ... " +
                "Isto é um teste de base 64 ... Isto é um teste de base 64 ... Isto é um teste de base 64 ... fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff";
        test = "SEM ACENTO";
        InputStream stream = new ByteArrayInputStream((test).getBytes());
        response.setData(stream);
        String b64Decode = new String(Base64.decode(response.getDataAsBase64(), Base64.DEFAULT));
        if (!b64Decode.trim().equals(test)) {
            throw  new Exception("Base 64 decodificado não corresponde ao teste. |" + test + "|" + b64Decode + "|");
        }



    }
}