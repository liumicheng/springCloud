<template>
    <div id="app" style="align-content: center;">
        <form  @submit.prevent="submit">
            <span>用户名：</span>
            <input type="text" v-model="userName"><br>

            <span>密码：</span>
            <input type="password" v-model="passWord"/><br />

            <span>性别：</span>
            <input type="radio" id="female" value="女" v-model="sex"/>
            <label for="female">女</label>
            <input type="radio" id="male" value="男" v-model="sex"/>
            <label for="male">男</label><br />

            <span>爱好：</span>
            <input type="checkbox" id="basket" value="篮球" v-model="likes"/>
            <label for="basket">篮球</label>
            <input type="checkbox" id="foot" value="足球" v-model="likes"/>
            <label for="foot">足球</label>
            <input type="checkbox" id="pingpang" value="乒乓球" v-model="likes"/>
            <label for="pingpang">乒乓球</label><br/>

            <span>城市：</span>
            <select v-model="cityId">
                <option value="">未选择</option>
                <option :value="city.id" v-for="(city,index) in citys" :key="index">
                    {{city.name}}
                </option>
            </select><br />
            <button @click="zhuce">注册</button>
        </form>
    </div>
</template>

<script>
    export default {
        name: "Zhuce",
        data(){
            return{
                userName:'',
                passWord:'',
                sex:'女',
                likes:['足球'],
                citys:[
                    {name:'北京',id:1},
                    {name:'上海',id:2},
                    {name:'广州',id:3}
                ],
                cityId:''

            }
        },
        methods:{
            zhuce(){
                this.$axios({
                    method:"post",
                    url:"/api/Zhuce",
                    data:{
                        userName: this.userName,
                        passWord: this.passWord,
                        sex:this.sex,
                        likes: this.likes
                    }
                }).then().catch()
            }
        }
    }
</script>

<style scoped>

</style>
