import { Component, PropsWithChildren } from 'react'
import { View, Text } from '@tarojs/components'

import './me.less'

export default class Me extends Component<PropsWithChildren> {
  componentDidMount () { }

  componentWillUnmount () { }

  componentDidShow () { }

  componentDidHide () { }

  render () {
    return (
      <View className='me'>
        <Text>Hello world!</Text>
      </View>
    )
  }
}
