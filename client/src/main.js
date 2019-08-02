import Vue from 'vue'
import App from './App.vue'
import router from './router'
import vuetify from './plugins/vuetify'
import VueLogger from 'vuejs-logger'
import '@babel/polyfill'

Vue.config.productionTip = false

const options = {
  isEnabled: true,
  logLevel : 'debug',
  stringifyArguments : false,
  showLogLevel : true,
  showMethodName : false,
  separator: '|',
  showConsoleColors: true
}

Vue.use(VueLogger, options)

new Vue({
  vuetify,
  render: h => h(App),
  router,
}).$mount('#app')
