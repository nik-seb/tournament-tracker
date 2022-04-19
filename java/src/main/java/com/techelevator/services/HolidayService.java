package com.techelevator.services;

import com.techelevator.model.Holiday;
import org.jboss.logging.BasicLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Component
public class HolidayService implements ServerHolidayService{

    @Value("${api.key}")
    private final String apiKey = "0fdef0df-5fac-40ce-bdf7-0b3c4a45ea3d";

    public static final String API_BASE_URL = "https://holidayapi.com/v1/holidays";
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public Holiday[] getAllHolidaysOnDate(Date date) {

         Holiday[] holidays = null;


        try {

            holidays  =

                    restTemplate.getForObject(API_BASE_URL +  "?pretty&key="+ apiKey + "&country=US&year=2021",  Holiday[].class );

        }catch (RestClientResponseException | ResourceAccessException e){
            System.out.println(e.getLocalizedMessage());
        }


        return holidays;
    }

//    curl -G -d country="US" -d year="2022" -d pretty
//-d key="0fdef0df-5fac-40ce-bdf7-0b3c4a45ea3d" "https://holidayapi.com/v1/holidays"

//    private HttpEntity<Void> makeAuthEntity(){
//        HttpHeaders headers = new HttpHeaders();
//        headers.setBearerAuth(authToken);
//        return new HttpEntity<>(headers);
//    }



    //        HttpHeaders httpHeaders = new HttpHeaders();
//
//        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
//
//        HttpEntity<Holiday> entity = new HttpEntity<>(httpHeaders);
}
