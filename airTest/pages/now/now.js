var util = require('../../utils/util.js');
var app = getApp()
Page({
  data: {
    formaldehyde: '0',
    temperature: '0',
    humidity: '0',
    quality: '',
    src: '../../images/logo.png',
    userPageUrl: '../../pages/user/user',
    requestUrl: app.globalData.commonUrl + '/data/newdata',
    userId: '',
    compare:'<='
  },
  onLoad: function () {
    // 调用函数时，传入new Date()参数，返回值是日期和时间  
    var time = util.formatTime(new Date());
    // 再通过setData更改Page()里面的data，动态更新页面的数据  
    this.setData({
      time: time
    });
  },
  onShow: function () {
    var that = this //为什么不用这个就不能把user对象的值传进去，而是空
    try {
      var value = wx.getStorageSync('localUserId')
      if (value) {

        that.data.userId = value;
        console.log(that.data.userId);
      }
    } catch (e) {
      // Do something when catch error
    }
    this.getNewData(this);
  },
  getNewData: function (that) { //数据获取函数，封装数据访问和设置操作
    var user = {
      userId: that.data.userId
    }
    wx.request({
      url: that.data.requestUrl,
      data: user,
      header: {
        'content-type': 'application/json'
      },
      method: 'POST',
      success: function (res) {
        switch (res.data.quality) {
          case "comfort":
            that.setData({
              formaldehyde: res.data.formaldehyde,
              temperature: res.data.temperature,
              humidity: res.data.humidity,
              quality: '较低'
            });
            break;
          case "normal":
            that.setData({
              formaldehyde: res.data.formaldehyde,
              temperature: res.data.temperature,
              humidity: res.data.humidity,
              quality: '正常'
            });
            break;
          case "overproof":
            that.setData({
              formaldehyde: res.data.formaldehyde,
              temperature: res.data.temperature,
              humidity: res.data.humidity,
              quality: '超标'
            });
            break;
          default:
            console.log("default");
        }
      },
      fail: function (res) {
        console.log(res.data);
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
  onPullDownRefresh: function () { //下拉操作
    app.openLoading()
    this.getNewData(this); //调用数据获取函数
    wx.stopPullDownRefresh()

  }
})  