package com.gs.startwars.repository;

import com.gs.startwars.model.Person;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;
public interface ServicesSW {
    @GET("starwars-api/api/all.json")
    Call<ArrayList<Person>> getPersons();
}