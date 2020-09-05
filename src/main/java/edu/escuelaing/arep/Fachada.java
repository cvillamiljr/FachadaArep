package edu.escuelaing.arep;
import org.json.JSONObject;
import edu.escuelaing.arep.fachada.Peticion;
import spark.Request;
import spark.Response;
import static spark.Spark.*;

public class Fachada {
    public static void main(String[] args) {
        port(getPort());
        get("/results",(req,res)->{
            String operation = req.queryParams("operation");
            String number = req.queryParams("number");
            JSONObject jsonObject = new JSONObject(Peticion.get(operation,number));
            return jsonObject;
        });


    }

    private static String inputDataPage(Request req, Response res) {
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>Calculadora Web</h2>"
                + "<form action=\"/results\">"
                + "  Number:<br>"
                + "  <input type=\"text\" name=\"number\" value=\"\">"
                + "  <br><br>"
                + "  <input type=\"text\" name=\"operacion\" value=\"\">"
                + "</select>"
                + "<br/>"
                + "<input type=\"submit\" value=\"Submit\">"
                + "</form>"
                + "</body>"
                + "</html>";
        return pageContent;
    }



    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 46000;
    }
}

