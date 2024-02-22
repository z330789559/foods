export default {
  pages: [
    'pages/index/index',
    'pages/food/food',
    'pages/me/me'
  ],
  tabBar: {
    list: [
      {
        // iconPath: 'resource/latest.png',
        // selectedIconPath: 'resource/lastest_on.png',
        pagePath: 'pages/index/index',
        text: '最新',
      },
      {
        // iconPath: 'resource/hotest.png',
        // selectedIconPath: 'resource/hotest_on.png',
        pagePath: 'pages/food/food',
        text: 'nearby',
      },
      {
        // iconPath: 'resource/node.png',
        // selectedIconPath: 'resource/node_on.png',
        pagePath: 'pages/me/me',
        text: 'me',
      },
    ],
    color: '#000',
    selectedColor: '#56abe4',
    backgroundColor: '#fff',
    borderStyle: 'white',
  },
  window: {
    backgroundTextStyle: 'light',
    navigationBarBackgroundColor: '#fff',
    navigationBarTitleText: 'WeChat',
    navigationBarTextStyle: 'black'
  }
}
