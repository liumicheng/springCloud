<template>
  <div id="app">
<!--      <router-link to="/MyLogin">MyLogin</router-link>-->
<!--      <div>-->
<!--          &lt;!&ndash; 路由对应组件的显示 &ndash;&gt;-->
          <router-view></router-view>
<!--      </div>-->
  </div>
  </template>
  <script>
  export default {
    name: 'App',
    components: {
    },
    data() {
      return {}
    }
  }
</script>
<style>
  #app {
    text-align: center;
    margin-top:400px ;
  }
</style>
