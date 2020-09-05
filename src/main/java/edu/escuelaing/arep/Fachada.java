package edu.escuelaing.arep;
import org.json.JSONObject;
import edu.escuelaing.arep.fachada.Peticion;
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


    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 46000;
    }
}

