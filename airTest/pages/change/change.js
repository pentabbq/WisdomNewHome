var app = getApp()
Page({
  data: {
    src: '../../images/logo.png',
    userPageUrl: '../../pages/user/user',
    commonUrl: app.globalData.commonUrl,
    requestUrl: app.globalData.commonUrl+'/user/login',
    motto: '空气质量检测系统',
    userId: '',
    password: '',
    response: '', //存取返回数据  
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
  
  openConfirm: function () {
    var that = this//了解为什么把赋值放在这里就可以实现函数调用函数，放在函数外部就会出错
    wx.showModal({
      title: '绑定操作',
      content: '点击确定，绑定新设备并删除旧设备的信息',
      confirmText: "确认",
      cancelText: "取消",
      success: function (res) {
        console.log(res);
        if (res.confirm) {
          that.logIn();
          // that.secondConnect(that, that.data.localUserId);
        } else {
          console.log('用户取消')
        }
      }
    });
  },

  //   secondConnect: function (that, value) { //定义二次连接函数，this和userId作为参数
  //   wx.request({
  //     url: that.data.commonUrl + '/user/selectbyid',
  //     data: {
  //       userId: value
  //     },
  //     header: {
  //       'content-type': 'application/x-www-form-urlencoded'
  //     },
  //     method: 'POST',
  //     success: function (res) {
  //       console.log("二次连接");
  //       console.log(res.data);
  //     },
  //     fail: function (res) {
  //       console.log(res.data);
  //       wx.showModal({
  //         content: '网络连接出错',
  //         showCancel: false,
  //         success: function (res) {
  //           if (res.confirm) {
  //             console.log('用户点击确定')
  //           }
  //         }
  //       });
  //     }
  //   })
  // }
})  