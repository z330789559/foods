import Taro from "@tarojs/taro";

/**
 * FoodVo
 */
export interface FoodVo {
    locationid: number;
    applicant: string;
    facilityType: string;
    cnn: number;
   locationDescription: string;
    address: string;
    blocklot: string;
    block: string;
    lot: string;
    permit: string;
    status: string;
    foodItems: string;
    x: string;
    y: string;
    latitude: string;
    longitude: string;
    schedule: string;
    dayshours: string;
    nOISent: string;
    approved: string;
    received: number;
    priorPermit: number;
    ExpirationDate: string;
    location: string;
    Fire_Prevention_Districts: number;
    Police_Districts: number;
    Supervisor_Districts: number;
    Zip_Codes: string;
    Neighborhoods_old: number;
    distance: string;
}

export const FoodApi = {
    getNearbyFoods:  (latitude: number, longitude: number,distance: number) => {
     return Taro.request({
            url: '/food/nearby',
            data: {
                latitude,
                longitude,
                distance
            }
        });
    }

}