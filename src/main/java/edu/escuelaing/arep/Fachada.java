package edu.escuelaing.arep;

import org.json.JSONObject;
import edu.escuelaing.arep.fachada.Peticion;

import static spark.Spark.*;

public class Fachada {
    public static void main(String[] args) {

        port(getPort());
        get("/result", (req, res) -> {
            String operation = req.queryParams("operation");
            String number = req.queryParams("number");
            JSONObject jsonObject = new JSONObject(new Peticion().get(operation, number));
            return jsonObject;
        });
    }

    public static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 45555;
    }


}

