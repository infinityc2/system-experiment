import Vue from 'vue'
import Router from 'vue-router'

import RepairInvoice from './components/RepairInvoice'
import Dashboard from './components/Dashboard'

Vue.use(Router)

const routes = [
    {
        path: '*',
        redirect: '/dashboard'
    },
    {
        path: '/dashboard',
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