package foxesden.collection;

import junit.framework.TestCase;

import java.util.Map;

/**
 * Created by henrique-vianna on 28/07/2016.
 */
public class FieldManagerTest extends TestCase {

    private Map getTestMap() {
        MapBuilder paises = new MapBuilder();
        paises.add("BR", (new MapBuilder())
                        .add("ESTADOS", (new MapBuilder())
                                .add("RS", "Rio Grande do Sul")
                                .add("SC", "Santa Catarina")
                                .getMap())
                        .getMap()
        )
        .add("US", new MapBuilder())
        .add("MX", new MapBuilder());
        return paises.getMap();
    }

    public void testGetField() throws Exception {
        FieldManager fm = new FieldManager(getTestMap());

        if (fm.getField("BR").getField("ESTADOS").getField("RS").getClass() != FieldManager.class) {
            throw new Exception("Erro ao acessar field manager RS");
        }

        if (fm.getField("BR").getField("ESTADOS").getField("SC").getClass() != FieldManager.class) {
            throw new Exception("Erro ao acessar field manager SC");
        }

        if (fm.getField("US").getClass() != FieldManager.class) {
            throw new Exception("Erro ao acessar field manager US");
        }

        if (fm.getField("MX").getClass() != FieldManager.class) {
            throw new Exception("Erro ao acessar field manager MX");
        }
    }

    public void testAsString() throws Exception {
        FieldManager fm = new FieldManager(getTestMap());
        if (!fm.getField("BR").getField("ESTADOS").getField("RS").asString().equals("Rio Grande do Sul")) {
            throw new Exception("Valor esperado inválido era esperado Rio Grande do Sul Retornado" + fm.getField("BR").getField("ESTADOS").getField("RS").asString());
        }

        if (!fm.getField("BR").getField("ESTADOS").getField("SC").asString().equals("Santa Catarina")) {
            throw new Exception("Valor esperado inválido era esperado Santa Catarina Retornado" + fm.getField("BR").getField("ESTADOS").getField("SC").asString());
        }


    }

    public void testAsInt() throws Exception {

    }

    public void testAsLong() throws Exception {

    }

    public void testAsDouble() throws Exception {

    }

    public void testAsBoolean() throws Exception {

    }
}