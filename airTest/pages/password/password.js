var app = getApp()
Page({
  data: {
    src: '../../images/logo.png',
    userPageUrl: '../../pages/user/user',
    requestUrl: app.globalData.commonUrl + '/user/updateuser',
    // requestUrl: app.globalData.commonUrl + '/user/update',
    motto: '空气质量检测系统',
    equipmentID:'00000',
    userOriginalPassword: '',
    userNewPassword: '',
    response: '', //存取返回数据  
    localUserId: ''  //方便存在本地的locakStorage  
  },
  userOriginalPasswordInput: function (e) {     //取用户名
    this.setData({
      userOriginalPassword: e.detail.value
    })
  },
  userNewPasswordInput: function (e) { //取密码
    this.setData({
      userNewPassword: e.detail.value
    })
  },
  onShow: function(){
    try {
      var value = wx.getStorageSync('localUserId')
      if (value) {
        //console.log(value);
        this.setData({
          equipmentID: value
        })
      }
    } catch (e) {
      // Do something when catch error
    }  
  },

  changePassword: function () {
    var that = this
    wx.request({
      url: this.data.requestUrl,
      data: {
        userId: that.data.equipmentID,
        prePassword: this.data.userOriginalPassword,
        password: this.data.userNewPassword
      },
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      method: 'POST',
      success: function (res) {
      console.log(that.data.userOriginalPassword)
      console.log(that.data.userNewPassword)
      console.log(res.data)
        if (res.data.update == 'success') {
          wx.showToast({
            title: '修改成功',
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
            content: '原密码错误，请重新输入!',
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
      title: '修改操作',
      content: '点击确定，更换账户密码',
      confirmText: "确认",
      cancelText: "取消",
      success: function (res) {
        console.log(res);
        if (res.confirm) {
          that.changePassword()
        } else {
          console.log('用户取消')
        }
      }
    });
  }
})  