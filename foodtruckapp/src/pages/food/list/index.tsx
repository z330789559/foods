
import "./index.less"


import React, {  Component, PropsWithChildren } from 'react'
import { View, Text } from '@tarojs/components'
import Taro from '@tarojs/taro'
import * as api from '../../../api/index'
import Card from '../card/card.tsx'
import {getDistance} from '../../../utils/index'


export default(props:{
 foods: api.FoodVo[],
 point: {latitude: number, longitude: number}
})=>{

    const element = props.foods.map((food)=>{
        food.distance =getDistance(food.latitude, food.longitude, props.point.latitude, props.point.longitude)
        return <Card  key={food.locationid} food={food} />
    })
    return <View>{element}</View>
}