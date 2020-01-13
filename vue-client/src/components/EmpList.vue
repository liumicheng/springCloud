<template>
    <dev>
        <h2 align="center">员  工  页  面</h2>
        <router-link to="{name:'EmpSave'}">
            <button >添加</button>
        </router-link>
        <table border="1" cellspacing="0" cellpadding="15" width="200">
            <thead align="center">
            <td>姓名</td>
            <td>年龄</td>
            <td>性别</td>
            <td>操作</td>
            </thead>
            <tbody>
                <tr align="center" v-for="(emp ,index) in emps">
                    <td >{{emp.empName}}</td>
                    <td >{{emp.sex}}</td>
                    <td >{{emp.age}}</td>
                    <td>
                        <router-link to="{name:'EmpUpdate',query:{empId:emp.empID}">
                            <button >编辑</button>
                        </router-link>
                        <button @click="del(index,emp.empId)">删除</button>
                    </td>&nbsp;&nbsp;&nbsp;
                </tr>
            </tbody>
        </table>
    </dev>
</template>

<script>
    export default {
        name: "EmpList",
        data(){
            return{
                emps: null
            }
        },
        mounted(){
           this.empList()
        },
        methods: {
            del(index,empId){
                this.$axios({
                    method: "get",
                    url: "/api/empDel/"+empId
                }).then(res =>{
                    console.log("---------:"+empId)
                    if(res.data == 1){
                        alert("删除员工成功")
                        this.empList()
                    }else{
                        alert("删除员工失败")
                    }
                }).catch(err =>{
                    console.log("请求失败："+err)
                })
            },
            empList(){
                this.$axios({
                    method: "get",
                    url: "/api/empList"
                }).then(res =>{
                    console.log("返回结果："+res.data)
                    this.emps = res.data
                }).catch(err =>{
                    console.log("请求报错："+err)
                })
            }

        }
    }
</script>

<style scoped>

</style>
