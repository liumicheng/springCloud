<template>
    <div>
        <p>{{empId}}</p>
    </div>
</template>

<script>
    export default {
        name: "EmpSave",
        data(){
            return{
                empId: this.$route.query.empId
            }
        }
    }
</script>

<style scoped>

</style>
