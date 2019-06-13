// pages/equipment/equipment.js
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    osVersion: '',
    version: '',
    userId : '',
    pDate: '',
    requestUrl: app.globalData.commonUrl +'/user/userdetail'
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onShow: function (options) {
    var that = this
    wx.showToast({
      title: '数据加载中',
      icon: 'loading',
      duration: 600
    });
    try {
      var value = wx.getStorageSync('localUserId')
      if (value) {

        that.data.userId = value,
          console.log(that.data.userId);
      }
    } catch (e) {
      // Do something when catch error
    }

    setTimeout(function () {
      wx.request({
        url: that.data.requestUrl,
        data: {
          userId: that.data.userId
        },
        header: {
          'content-type': 'application/x-www-form-urlencoded'
        },
        method: 'POST',
        success: function (res) {
          console.log(res.data);
          that.setData({
            osVersion: res.data.osVersion,
            version: res.data.version,
            userId: res.data.userId,
            pDate: res.data.pDate
          })
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
    }, 600)
  }

})