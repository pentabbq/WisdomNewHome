var wxCharts = require('../../utils/wxcharts.js');
var util = require('../../utils/util.js');
var app = getApp();
var dayLineChart = null;
Page({
  data: {
    dateChosed: '2018-05',
    month: '',
    userId: '',
    requestUrl: app.globalData.commonUrl + '/data/monthaverage',
    // requestUrl: app.globalData.commonUrl+'/data/monthaverage',
  },
  touchHandler: function (e) {
    // console.log(dayLineChart.getCurrentDataIndex(e));
    dayLineChart.showToolTip(e, {
      format: function (item, category) {
        return category + ' ' + item.name + ':' + item.data
      }
    });
  },
  createSimulationData: function (data) { //绘图
    var categories = [];
    var returnData = [];
    var length = data.length;
    for (var i = 0; i < length; i++) {
      categories.push((i + 1));
      if (returnData[i] != 0) { //考虑丢包问题，若丢包，传过来的数据默认为0
        returnData[i] = data[i];
      } else {
        returnData[i] = null;
      }
    }
    return {
      categories: categories,
      data: returnData
    }
  },
  getLocalUserId: function () { //获取本地存储的userId
    try {
      var value = wx.getStorageSync('localUserId')
      if (value) {
        return value;
      }
    } catch (e) {
      // Do something when catch error
    }
  },
  getDefaultWidth: function () {
    var windowWidth = 320;
    try {
      var res = wx.getSystemInfoSync();
      windowWidth = res.windowWidth;
      return (windowWidth);
    } catch (e) {
      console.error('getSystemInfoSync failed!');
    }
  },
  drawTable: function (simulationData, windowWidth, dayLineCanvas) {
    dayLineChart = new wxCharts({
      canvasId: dayLineCanvas,
      type: 'line',
      categories: simulationData.categories,
      animation: true,
      series: [{
        name: '甲醛浓度',
        data: simulationData.data,
        format: function (val, name) {
          return parseFloat(val).toFixed(2) + 'mg/m3';
        }
      }],
      xAxis: {
        disableGrid: true
      },
      yAxis: {
        title: '甲醛浓度 (mg/m3)',
        format: function (val) {
          return parseFloat(val).toFixed(2);
        },
        min: 0
      },
      width: windowWidth,
      height: 200,
      dataLabel: false,
      dataPointShape: true,
      extra: {
        lineStyle: 'curve'
      }
    });
    return (dayLineChart);
  },
  bindDateChange: function (e) {
    this.setData({
      dateChosed: e.detail.value
    })
  },
  daysInMonth: function(time) { //判断某个月的天数
    var arr = time.split("-");
    var month = {
      beginDate: '',
      endDate: ''
    };
    switch (arr[1]) {
      case '01':
        month.beginDate = arr[0]+"-"+arr[1]+"-"+'01';
        month.endDate = arr[0] + "-" + arr[1] + "-" + '31';
        return(month);
        break;
      case '02':
        month.beginDate = arr[0] + "-" + arr[1] + "-" + '01';
        month.endDate = arr[0] + "-" + arr[1] + "-" + '28';
        return (month);
        break;
      case '03':
        month.beginDate = arr[0] + "-" + arr[1] + "-" + '01';
        month.endDate = arr[0] + "-" + arr[1] + "-" + '31';
        return (month);
        break;
      case '04':
        month.beginDate = arr[0] + "-" + arr[1] + "-" + '01';
        month.endDate = arr[0] + "-" + arr[1] + "-" + '30';
        return (month);
        break;
      case '05':
        month.beginDate = arr[0] + "-" + arr[1] + "-" + '01';
        month.endDate = arr[0] + "-" + arr[1] + "-" + '31';
        return (month);
        break;
      case '06':
        month.beginDate = arr[0] + "-" + arr[1] + "-" + '01';
        month.endDate = arr[0] + "-" + arr[1] + "-" + '30';
        return (month);
        break;
      case '07':
        month.beginDate = arr[0] + "-" + arr[1] + "-" + '01';
        month.endDate = arr[0] + "-" + arr[1] + "-" + '31';
        return (month);
        break;
      case '08':
        month.beginDate = arr[0] + "-" + arr[1] + "-" + '01';
        month.endDate = arr[0] + "-" + arr[1] + "-" + '31';
        return (month);
        break;
      case '09':
        month.beginDate = arr[0] + "-" + arr[1] + "-" + '01';
        month.endDate = arr[0] + "-" + arr[1] + "-" + '30';
        return (month);
        break;
      case '10':
        month.beginDate = arr[0] + "-" + arr[1] + "-" + '01';
        month.endDate = arr[0] + "-" + arr[1] + "-" + '31';
        return (month);
        break;
      case '11':
        month.beginDate = arr[0] + "-" + arr[1] + "-" + '01';
        month.endDate = arr[0] + "-" + arr[1] + "-" + '30';
        return (month);
        break;
      case '12':
        month.beginDate = arr[0] + "-" + arr[1] + "-" + '01';
        month.endDate = arr[0] + "-" + arr[1] + "-" + '31';
        return (month);
        break;
      default:
        console.log("失败")
    }
  },

  serarchNewData: function (e) { //button绑定事件
    //获取数据
    var that = this;
    var userId = this.getLocalUserId();
    var time = this.data.dateChosed;
    var timeDate = this.daysInMonth(time);
    var userSelect = {
      userId: userId,
      beginDate: timeDate.beginDate,
      endDate: timeDate.endDate
    }
    console.log(userSelect)

    wx.request({
      url: this.data.requestUrl,
      data: userSelect,
      header: {
        'content-type': 'application/json'
      },
      method: 'POST',
      success: function (res) {
        if(res.data.length == 0){
          wx.showModal({
            content: '查询月份数据为空',
            showCancel: false,
            success: function (res) {
              if (res.confirm) {
                console.log('用户点击确定')
              }
            }
          });
        }else{
          var simulationData = that.createSimulationData(res.data);
          var windowWidth = that.getDefaultWidth();
          var dayLineCanvas = 'dayLineCanvas';
          dayLineChart = that.drawTable(simulationData, windowWidth, dayLineCanvas);
          that.setData({
            month: time
          })
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

  onShow: function (e) {
    //获取数据
    var that = this;
    var userId = this.getLocalUserId();
    var time = util.formatTime(new Date()); //获取日期
    var arr = time.split("-");
    var strings = arr[0]+"-"+arr[1];
    this.setData({
      month: strings
    });
    var timeDate = this.daysInMonth(time);
    var userSelect = {
      userId: userId,
      beginDate: timeDate.beginDate,
      endDate: timeDate.endDate
    }
    wx.request({
      url: this.data.requestUrl,
      data: userSelect,
      header: {
        'content-type': 'application/json'
      },
      method: 'POST',
      success: function (res) {
        var simulationData = that.createSimulationData(res.data);
        var windowWidth = that.getDefaultWidth();
        var dayLineCanvas = 'dayLineCanvas';
        dayLineChart = that.drawTable(simulationData, windowWidth, dayLineCanvas);
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

  }

});

