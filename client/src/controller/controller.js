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
        // [function (data) {
        //     return data? JSON.parse(data).data : data
        // }]
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

    addInvoice: (data, list) => instance.post('invoices/invoice/' + list, {
        phoneNumber: data.phone,
        email: data.email,
        describe: data.describe,
        brand: data.brand,
        computerType: data.type,
        sentDate: data.date
    })
}