package com.foodtruck.loveeat.infra.dal.po;

import lombok.Data;

/**
 * FoodPo
 *
 * @author libaozhong
 * @version 2024-02-21
 * create table foods.Mobile_Food_Facility_Permit
 * (
 *     locationid                  int               not null
 *         primary key,
 *     Applicant                   varchar(255)      null,
 *     FacilityType                varchar(20)       null,
 *     cnn                         int               null,
 *     LocationDescription         varchar(255)      null,
 *     Address                     varchar(200)      null,
 *     blocklot                    varchar(10)       null,
 *     block                       varchar(5)        null,
 *     lot                         varchar(4)        null,
 *     permit                      varchar(50)       null,
 *     Status                      varchar(20)       null,
 *     FoodItems                   varchar(255)      null,
 *     X                           varchar(30)       null,
 *     Y                           varchar(30)       null,
 *     Latitude                    varchar(40)       null,
 *     Longitude                   varchar(40)       null,
 *     Schedule                    varchar(200)      null,
 *     dayshours                   varchar(100)      null,
 *     NOISent                     varchar(20)       null,
 *     Approved                    varchar(100)      null,
 *     Received                    int               null,
 *     PriorPermit                 tinyint default 0 not null,
 *     ExpirationDate              varchar(40)       null,
 *     Location                    varchar(100)      null,
 *     `Fire Prevention Districts` smallint          null,
 *     `Police Districts`          smallint          null,
 *     `Supervisor Districts`      smallint          null,
 *     `Zip Codes`                 varchar(8)        null,
 *     `Neighborhoods (old)`       smallint          null
 * );
 **/

@Data
public class FoodPo {

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
