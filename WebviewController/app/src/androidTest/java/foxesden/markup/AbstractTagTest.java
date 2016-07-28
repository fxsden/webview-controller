package foxesden.markup;

import junit.framework.TestCase;

/**
 * Created by henrique on 27/07/2016.
 */
public class AbstractTagTest extends TestCase {

    public void testGenerate() throws Exception {
        //<img src="teste.png">
        Tag img = new Tag("img", false);
        if (!img.addAttribute("src", "teste.png").toString().equals("<img src=\"teste.png\">")) {
            throw new Exception("Falhou no teste: <img src=\"teste.png\"> Resultado: " + img.toString());
        }
        //<body><script src="bootstrap.js"></script><div class="row"><div class="col-xs-12">Teste</div></div></body>
        TagComposite body = (new TagComposite("body"))
                .addChild((new Tag("script")).addAttribute("src", "bootstrap.js"))
                .addChild(((TagComposite) ((new TagComposite("div")).addAttribute("class", "row")))
                        .addChild(((Tag) (new Tag("div")).addAttribute("class", "col-xs-12")).setValue("Teste")));
        if (!body.toString()
                .equals("<body><script src=\"bootstrap.js\"></script><div class=\"row\"><div class=\"col-xs-12\">Teste</div></div></body>")) {
            throw new Exception("Falhou no teste: <body><script src=\"bootstrap.js\"></script><div class=\"row\"><div class=\"col-xs-12\">Teste</div></div></body> Resultado: " + body.toString());
        }
    }
}