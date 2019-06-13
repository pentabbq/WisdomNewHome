//app.js
App({
  globalData: {
    userInfo: null,
    commonUrl: 'http://101.132.181.225:8080/wisdomnewhome_version02' //所有页面的公共URL
    // commonUrl: 'http://10.72.51.241:8080/wisdomnewhome_test_01'
  },
  onLaunch: function () { //小程序加载时执行
    wx.getSetting({ // 获取用户信息
      success: res => {
        if (res.authSetting['scope.userInfo']) {
          // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框
          wx.getUserInfo({
            success: res => {
              // 可以将 res 发送给后台解码出 unionId
              this.globalData.userInfo = res.userInfo;

              // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
              // 所以此处加入 callback 以防止这种情况
              if (this.userInfoReadyCallback) {
                this.userInfoReadyCallback(res);
              }
            }
          })
        }
      }
    })
  },
  openLoading: function () { //加载提示
    wx.showToast({
      title: '数据加载中',
      icon: 'loading',
      duration: 600
    });
  },


})