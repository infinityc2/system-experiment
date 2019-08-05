import axios from 'axios'

const SERVER_URL = 'http://localhost:9000'

const instance = axios.create({
    baseURL: SERVER_URL,
    timeout: 1000
})

export default {
    
    getAllBrand: () => instance.get('computer/brand', {
        transformResponse: (response) => {
            return JSON.parse(response)
        }
    }),

    getAllType: () => instance.get('computer/type', {
        transformResponse: (response) => {
            return JSON.parse(response)
        }
    }),

    getAllToolType: () => instance.get('tool/type', {
        transformResponse: (response) => {
            return JSON.parse(response)
        }
    }),

    getAllTool: () => instance.get('tool', {
        transformResponse: (response) => {
            return JSON.parse(response)
        }
    }),

    addInvoice: (data) => instance.post('invoices/invoice/' + data.tools, {
        phoneNumber: data.phone,
        email: data.email,
        describe: data.describe,
        brand: data.brand,
        computerType: data.type,
        sentDate: data.date,
        customer: data.customer
    }),

    signIn: (data) => instance.post('login', {
        username: data.username,
        password: data.password
    })
}