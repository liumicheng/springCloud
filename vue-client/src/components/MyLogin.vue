<template>
    <div>
        <form>
            <input type="text" placeholder="请输入账号" v-model="userName"></input><br><br>
            <input type="text" placeholder="请输入密码" v-model="passWord"></input><br><br>
            <div class="yincang">
                <p v-if="repetition">用户名已重复，请重新输入！</p>
                <p v-if="flag">用户名或密码出错，请重新输入！</p>
            </div>
            <button @click="zhuce">注册</button>&nbsp;&nbsp;<button @click="denglu">登录</button>
        </form>
    </div>
</template>

<script>
    export default{
        name: "MyLogin",
        data(){
            return{
                userName: "",
                passWord: "",
                pushName: null,
                flag: false,
                repetition: false
            }
        },
        methods:{
            denglu(){
                this.$axios({
                    url:"/api/MyLogin",
                    method: 'post',
                    data:{
                        userName:this.userName,
                        passWord:this.passWord
                    },
                    dataType:"json"
                }).then(res =>{
                    console.log(res.data)
                    this.pushName = res.data.pashName
                    if(this.pushName != null){
                        this.$router.push({
                            name: this.pushName
                        })
                    }else{
                        this.flag = true
                        this.repetition = false
                    }

                }).catch(err =>{
                    console.log("请求出错："+err)
                })
            },
            zhuce(){
               this.$axios({
                   method: 'post',
                   url: '/api/addUserLogin',
                   data:{
                       userName: this.userName,
                       passWord: this.passWord
                   }

               }).then(res =>{
                   console.log("返回数据："+res.data.repetition)
                   this.repetition = res.data.repetition
                   this.flag = false
                   if(!this.repetition){
                       alert("注册成功！")
                   }
               }).catch(err =>{
                   console.log("请求报错："+err)
               })
            }
        }
    }
</script>

<style scoped>
    .yincang{
        color: red;
    }
</style>
