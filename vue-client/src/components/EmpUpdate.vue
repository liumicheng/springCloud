<template>
    <div>
        <p>hhh{{empId}}</p>
    </div>
</template>

<script>
    export default {
        name: "EmpUpdate",
        data(){
            return{
                empId: this.$route.query.empId
            }
        }
    }
</script>

<style scoped>

</style>
