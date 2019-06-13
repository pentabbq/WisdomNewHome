//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    accountId:         '点击绑定',
    userInfo:          {},
    hasUserInfo:       false,
    canIUse:           wx.canIUse('button.open-type.getUserInfo'),

    icon_detail:       '../../images/icon_detail.png',
    icon_equipment:    '../../images/icon_equipment.png',
    icon_exchange:     '../../images/icon_exchange.png',
    icon_password: '../../images/icon_password.png',
    icon_us:           '../../images/icon_us.png',
    
    changeEquipmentUrl:'../../pages/change/change',
    indexUrl:          '../../pages/index/index',
    equipmentUrl:      '../../pages/equipment/equipment',
    changePasswordUrl: '../../pages/password/password',
    aboutUsUrl:        '../../pages/us/us'
  },
  
  onLoad: function () {
    if (app.globalData.userInfo) {
      this.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true
      })
    } else if (this.data.canIUse) { // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回,所以此处加入 callback 以防止这种情况
      app.userInfoReadyCallback = res => {
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    } else {
      // 在没有 open-type=getUserInfo 版本的兼容处理
      wx.getUserInfo({
        success: res => {
          app.globalData.userInfo = res.userInfo
          this.setData({
            userInfo: res.userInfo,
            hasUserInfo: true
          })
        }
      })
    }
  },
  onShow: function () {

    //二次登录
    try {
      var value = wx.getStorageSync('localUserId')
      if (value) {
        //console.log(value);
        this.setData({
          accountId: value,
          indexUrl:   'user'
        })
      }
    } catch (e) {
      // Do something when catch error
    }  
  },
  getUserInfo: function (e) {
    console.log(e)
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  },
  logOut:function(){
    wx.showModal({
      title: '退出登录',
      content: '点击确定，退出登录',
      confirmText: "确认",
      cancelText: "取消",
      success: function (res) {
        console.log(res);
        if (res.confirm) {
          wx.removeStorage({
            key: 'localUserId',
            success: function (res) {
              console.log(res.data)
              wx.reLaunch({
                url: '../index/index'
              })
            }
          })
        } else {
          console.log('用户取消')
        }
      }
    });
  }
})
