import Vue from 'vue'
import Router from 'vue-router'

import RepairInvoice from './components/RepairInvoice'

Vue.use(Router)

const routes = [
    {
        path: '*',
        redirect: ''
    },
    {
        path: '/invoice',
        name: 'RepairInvoice',
        component: RepairInvoice
    }
]

const router = new Router({routes})

export default router