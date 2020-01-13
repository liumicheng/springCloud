<template>
    <div>
        <div>
            <p>{{info}}</p>
            <button @click="tijiao">点击</button>
        </div>
    </div>
</template>

<script>
    export default {
        name: "TestAjax",
        data(){
            return{
                info: '哈哈'
            }
        },
        // mounted(){
        //     const url = 'https://www.runoob.com/try/ajax/json_demo.json'
        //     tijiao(){
        //         //发ajax请求
        //         this.$axios.get(url).then(response =>{
        //             this.info = response
        //         }).catch(function(error) {
        //             alert('请求失败！'+error)
        //         })
        //     }
        // },
        methods: {
            // tijiao(){
            //     const url = 'http://localhost:8111/TestAjax'
            //     //发ajax请求
            //     this.$axios.get(url).then(response =>{
            //         this.info = response
            //         alert(response);
            //     }).catch(function(error) {
            //         alert('请求失败！'+error)
            //     })
            // },
            tijiao(){
                this.$axios({
                    url: '/api/TestAjax',
                    method: 'get',
                    data: '',
                    dataType:"json"
                }).then(res =>{
                    console.log("请求成功：" + res)
                    this.info = res.data;
                }).catch(err =>{
                    console.log("请求失败：" + err )
                })
            }
        }
    }
</script>

<style scoped>

</style>
