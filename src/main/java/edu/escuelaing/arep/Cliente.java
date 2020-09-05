package edu.escuelaing.arep;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;

/**
 * Hello world!
 *
 */
public class Cliente
{
    public static void main(String[] args) {
        HttpResponse<String> response = null;
        try {
            response = Unirest.get("https://fachadeserver-orlando.herokuapp.com/API/calculator?operation=sin&number=0.785398")
                    .asString();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        System.out.println(response.getBody());
    }


}
