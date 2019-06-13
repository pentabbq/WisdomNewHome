var app = getApp()
Page({
  data: {
    src:         '../../images/logo.png',
    userPageUrl: '../../pages/user/user',
    requestUrl: app.globalData.commonUrl +'/user/login',
    motto:       '空气质量检测系统',
    userId:      '',
    userPassword:    '',
    response:    '', //存取返回数据  
    localUserId: ''  //方便存在本地的locakStorage  
  },
  userNameInput: function (e) {     //取用户名
    this.setData({
      userId: e.detail.value
    })
  },
  userPasswordInput: function (e) { //取密码
    this.setData({
      userPassword: e.detail.value
    })
  },

  logIn: function () {
    var that = this
    wx.request({
      url: this.data.requestUrl,
      data: {
        userId: this.data.userId,
        password: this.data.userPassword
      },
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      method: 'POST',
      success: function (res) {
        if (res.data.states == 1) {
          that.setData({
            localUserId: that.data.userId
          })
          try {
            wx.setStorageSync('localUserId', that.data.userId)
          } catch (e) {
          }

          try {
            var value = wx.getStorageSync('localUserId')
            if (value) {
              console.log(value);
            }
          } catch (e) {
            // Do something when catch error
          }
          console.log(res.data);
          console.log(res.data.sessionId);
          wx.showToast({
            title: '绑定成功',
            icon: 'success',
            duration: 2000
          });
          setTimeout(function () {
            wx.switchTab({
              url: that.data.userPageUrl
            });
          }, 2500)
        } else {
          wx.showModal({
            content: '设备ID或密码错误，请重新输入!',
            showCancel: false,
            success: function (res) {
              if (res.confirm) {
                console.log('用户点击确定')
              }
            }
          });
        }


      },
      fail: function (res) {
        wx.showModal({
          content: '网络连接出错',
          showCancel: false,
          success: function (res) {
            if (res.confirm) {
              console.log('用户点击确定')
            }
          }
        });
      }
    })

  },
  onShow:function(){
    try {
      var value = wx.getStorageSync('localUserId')
      if (value) {
        wx.showToast({
          title: '正在登录',
          icon: 'loading',
          duration: 1000
        });
        setTimeout(function () {
          wx.switchTab({
            url: '../../pages/user/user'
          })
        }, 1000)
        console.log(value);
      } else {
        console.log('logIn')
      }
    } catch (e) {
      // Do something when catch error
    }
  }
   
})  