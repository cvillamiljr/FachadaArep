package edu.escuelaing.arep;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Cliente {
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
