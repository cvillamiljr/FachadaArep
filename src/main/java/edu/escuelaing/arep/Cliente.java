package edu.escuelaing.arep;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Cliente {
    public static void main(String[] args) {
        HttpResponse<String> response = null;
        try {
            response = Unirest.get("https://fachada-cesar.herokuapp.com/result?operation=sin&number=1")
                    .asString();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        System.out.println(response.getBody());
    }


}
