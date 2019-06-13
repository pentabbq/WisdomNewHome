var Promise = require('./bluebird.js')
function wxPromisify(fn){
  return function (obj = {}){
    return new Promise((resolve,reject) => {
      obj.success = function (res) {
        resolve(res)
      }
      obj.fail = function (res){
        reject(res)
      }
      fn(obj)
    })
  }
}

moudle.exports = {
  wxProisify: wxPromisify
}