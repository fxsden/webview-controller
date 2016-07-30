package foxesden.webviewcontroller.rest;

import android.net.Uri;

import junit.framework.TestCase;

import java.lang.reflect.Field;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

import foxesden.collection.FieldManager;

/**
 * Created by henrique-vianna on 29/07/2016.
 */
public class RequestTest extends TestCase {

    public void testGetFields() throws Exception {
        //file:///test?field%5Bname%5D=&field%5Bage%5D=
        String uri ="file:///test?field%5Bname%5D=Teste&field%5Bage%5D=10&teste_1=teste&campo[a][b][c][d][e][f][g][h][i][j][k]=lmnopqrstuvxyz";
        Request request = new Request(uri);
        if (request.getFields().getField("field").getClass() != FieldManager.class) {
            throw new Exception("Retorno não é uma classe FieldManager em field");
        }

        if (request.getFields().getField("field").getField("name").getClass() != FieldManager.class) {
            throw new Exception("Retorno não é uma classe FieldManager em name");
        }

        if (!request.getFields().getField("field").getField("name").asString().equals("Teste")) {
            throw new Exception("Campo field[name] com valor diferente de 'Teste'. Retorno = " + request.getFields().getField("field").getField("name").asString() );
        }

        if (request.getFields().getField("field").getField("age").getClass() != FieldManager.class) {
            throw new Exception("Retorno não é uma classe FieldManager em age");
        }

        if (request.getFields().getField("field").getField("age").asInt() != 10) {
            throw new Exception("Campo field[age] com valor diferente de '10'. Retorno = " + request.getFields().getField("field").getField("age").asInt() );
        }

        if (request.getFields().getField("teste_1").getClass() != FieldManager.class) {
            throw new Exception("Retorno não é uma classe FieldManager em teste_1");
        }

        if (!request.getFields().getField("teste_1").asString().equals("teste")) {
            throw new Exception("Campo teste_1 com valor diferente de 'teste'. Retorno = " + request.getFields().getField("teste").asString());
        }

        if (!request.getFields().getField("campo").getField("a")
                .getField("b").getField("c").getField("d")
                .getField("e").getField("f").getField("g")
                .getField("h").getField("i").getField("j")
                .getField("k").asString().equals("lmnopqrstuvxyz")) {
            throw new Exception("Campo campo com valor diferente de 'lmnopqrstuvxyz'. Retorno = " + request.getFields().getField("campo").getField("a")
                    .getField("b").getField("c").getField("d")
                    .getField("e").getField("f").getField("g")
                    .getField("h").getField("j").getField("k").asString());
        }
    }
}