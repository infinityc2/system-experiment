import Vue from 'vue'
import Router from 'vue-router'

import RepairInvoice from './components/RepairInvoice'
import Dashboard from './components/Dashboard'
import Login from './components/Login'

Vue.use(Router)

const routes = [
    {
        path: '*',
        redirect: '/login'
    },
    {
        path: '/login',
        component: Login
    },
    {
        path: '/dashboard/:username',
        component: Dashboard,
        children: [
            {
                path: 'invoice',
                component: RepairInvoice
            }
        ]
    }
]

const router = new Router({ routes })

export default router