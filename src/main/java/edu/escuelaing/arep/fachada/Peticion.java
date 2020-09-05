package edu.escuelaing.arep.fachada;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

    public class Peticion {

        public static String get(String operation, String number){

            HttpResponse<String> response = null;
            try {
                response = Unirest.get("https://trigcalculator.herokuapp.com/calculate?operation"+operation+"&number="+number)
                        .asString();
            } catch (UnirestException e) {
                e.printStackTrace();
            }

            return response.getBody();



        }
}
