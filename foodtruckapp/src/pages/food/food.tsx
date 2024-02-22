import React,{ Component, PropsWithChildren } from 'react'
import { View, Text } from '@tarojs/components'
import Taro from '@tarojs/taro'
import * as api from '../../api/index'
import Loading from '../../components/Loading/index'
import List from './list'

import './food.less'

export default class FoodView extends Component<PropsWithChildren> {
  state: {
    foods: api.FoodVo[]
    distance: number,
    latitude: number,
    longitude: number,
    loading: false,
  }
  constructor(props: PropsWithChildren) {
    super(props)
    this.state = {
      foods: [],
      distance: 1,
      latitude: 37.7749,
      longitude: -122.4194,
      loading: false
    }
  }

  initPosition =  (res:{latitude: number, longitude: number}) => {

    const latitude = res.latitude
    const longitude = res.longitude
    this.setState({
      latitude,
      longitude,
      loading: true
    })
    api.FoodApi.getNearbyFoods(
      this.state.latitude,
      this.state.longitude,
      this.state.distance
    ).then((fres) => {
      debugger
      console.log('fres:', fres.data)
      this.setState({
        foods: fres.data,
        loading: false
      })
    })

  }
  componentDidMount () { 
    try {
      this.initPosition({
        latitude: 37.7749,
        longitude: -122.4194,
      })
      // navigator.geolocation.getCurrentPosition((position) => {
      //   console.log('当前位置信息：', position)
      //   this.initPosition(position.coords)
      // })
    // Taro.getLocation({
    //   type: 'wgs84',
    //   success: function (res) {
    //     debugger
       
    //   }
    //   })
    } catch (error) {
      Taro.showToast({
        title: `载入远程数据错误${error.getMessage()}`,
        icon: 'none',
        duration: 2000

      })
    }
  }

  componentWillUnmount () { }

  componentDidShow () { }

  componentDidHide () { }

  render () {
    return (
      <View className='food'>
        {this.state.loading ?<Loading />:<List foods={this.state.foods} point={{latitude: this.state.latitude, longitude:this.state.longitude}}/>}
      </View>
    )
  }
}
