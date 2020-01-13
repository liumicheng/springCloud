import Vue from 'vue'
import App from './App.vue'
import iView from 'iview'
import 'iview/dist/styles/iview.css' // 使用 CSS
import axios from 'axios'
import  router from './router' //会自动找index.js（router文件夹下）

Vue.prototype.$axios = axios //把axios挂载到vue的原型中，在vue中每个组件都可以使用axios发送请求
Vue.prototype.HOME = '/api' //重要在于这里，Vue.prototype.HOME = '/api'是一个定值，默认指向localhost，所有修改指向路径为'/api'，配置文件index.js定义的可跨域路径
Vue.use(iView)
Vue.config.productionTip = false

new Vue({
    router,  //使用router
    render: h => h(App)
}).$mount('#app')
