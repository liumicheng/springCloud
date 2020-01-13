import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login'
import TestAjax from "@/components/TestAjax"
import MyLogin from "@/components/MyLogin"
import Zhuce from "@/components/UserAdd"
import EmpList from "@/components/EmpList"
import EmpSave from "@/components/EmpSave";
import EmpUpdate from "@/components/EmpUpdate";
Vue.use(Router)

export default new Router({
    routes: [
        {
            path: '/Login',
            name: 'Login',
            component: Login
        },
        {
            path: '/TestAjax',
            name: 'TestAjax',
            component: TestAjax
        },
        {
            path: '/MyLogin',
            name: 'MyLogin',
            component: MyLogin
        },
        {
            path: '/Zhuce',
            name: 'Zhuce',
            component: Zhuce
        },
        {
            path: '/EmpList',
            name: 'EmpList',
            component: EmpList
        },
        {
            path: '/EmpSave',
            name: 'EmpSave',
            component: EmpSave
        },
        {
            path: '/EmpUpdate',
            name: 'EmpUpdate',
            component: EmpUpdate
        },
        {
            path: '/',
            redirect: '/MyLogin'
        }
    ]
})

