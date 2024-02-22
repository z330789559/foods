package com.foodtruck.loveeat.domain.food.dos;

import lombok.Data;

/**
 * FoodDo
 *
 * @author libaozhong
 * @version 2024-02-21
 **/

@Data
public class FoodDo {
  private Integer locationid;

  private String Applicant;

  private String FacilityType;

  private Integer cnn;

  private String LocationDescription;

  private String Address;

  private String blocklot;

  private String block;

  private String lot;

  private String permit;

  private String Status;

  private String FoodItems;

  private String X;

  private String Y;

  private String Latitude;

  private String Longitude;

  private String schedule;

  private String dayshours;

  private String NOISent;

  private String Approved;

  private Integer Received;

  private Integer PriorPermit;

  private String ExpirationDate;

  private String Location;

  private Integer Fire_Prevention_Districts;

  private Integer Police_Districts;

  private Integer Supervisor_Districts;

  private String Zip_Codes;

  private Integer Neighborhoods_old;
}
