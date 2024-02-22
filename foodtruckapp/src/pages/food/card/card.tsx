import { View, Text } from '@tarojs/components'
import React, {  Component, PropsWithChildren } from 'react'
import * as api from '../../../api/index'
import "./card.less"

export default (props: {
    food: api.FoodVo
    }) => {
    return <View className='card'>
        <View className='card__title'>Applicant: {props.food.applicant}</View>
        <View className='card__location'>Distance(m): {props.food.distance} m </View>
        <View className='card__content'>
        <View className='card__content__left'>
            <View> STatus: {props.food.status} </View>
            <View> FoodItems: {props.food.foodItems} </View>
        </View>
        <View className='card__content__right'>
            <View className='card__content__right__desc'>Dayshours: {props.food.dayshours}</View>
            <View className='card__content__right__price'>schedule: {props.food.schedule}</View>
            <View className='card__content__right__desc'>Address: {props.food.address}</View>
        </View>
        </View>
    </View>
    }