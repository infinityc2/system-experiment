<template>
  <v-card class="mx-auto" max-width="500">
    <v-card-title>แจ้งซ่อมคอมพิวเตอร์</v-card-title>
    <v-card-text>
      <v-layout column @keyup.enter="addInvoice">
        <v-flex>
          <v-select label="อุปกรณ์ที่ส่งซ่อม" :items="computerType" v-model="invoice.type"></v-select>
        </v-flex>

        <v-flex>
          <v-select label="ยี่ห้อ" :items="brands" v-model="invoice.brand"></v-select>
        </v-flex>

        <v-flex>
          <v-menu
            ref="menu"
            v-model="menu"
            :close-on-content-click="false"
            :return-value.sync="date"
            transition="scale-transition"
            offset-y
            full-width
            min-width="290px"
          >
            <template v-slot:activator="{ on }">
              <v-text-field
                v-model="date"
                label="วันที่ส่งซ่อม"
                prepend-icon="event"
                readonly
                v-on="on"
              ></v-text-field>
            </template>
            <v-date-picker v-model="invoice.date" no-title scrollable>
              <v-spacer></v-spacer>
              <v-btn text color="primary" @click="menu = false">Cancel</v-btn>
              <v-btn text color="primary" @click="$refs.menu.save(invoice.date)">OK</v-btn>
            </v-date-picker>
          </v-menu>
        </v-flex>

        <v-flex>
          <v-select chips multiple label="อุปกรณ์หรือ Software ที่ต้องการติดตั้ง" :items="tools" v-model="invoice.tools"></v-select>
        </v-flex>

        <v-flex>
          <v-text-field label="อีเมล์" :rules="[rules.email]" v-model="invoice.email"></v-text-field>
        </v-flex>

        <v-flex>
          <v-text-field label="เบอร์โทรศัพท์" :rules="[rules.number]" v-model="invoice.phone"></v-text-field>
        </v-flex>

        <v-flex>
          <v-textarea label="รายละเอียด" v-model="invoice.describe"></v-textarea>
        </v-flex>
      </v-layout>
    </v-card-text>
    <v-card-actions>
      <v-btn color="primary" @click.prevent="addInvoice">แจ้งซ่อม</v-btn>
      <v-btn text>กลับ</v-btn>
    </v-card-actions>
    <v-snackbar v-model="snackbarSuccess">
      <h6 class="subtitle-1">เพิ่มรายการแจ้งซ่อมสำเร็จ</h6>
      <v-btn color="primary" text @click="snackbarSuccess = false">ปิด</v-btn> 
    </v-snackbar>
    <v-snackbar v-model="snackbarError">
      <h6 class="subtitle-2">ไม่สามารถเพิ่มรายการแจ้งซ่อมได้</h6>
      <v-btn color="primary" text @click="snackbarError = false">ปิด</v-btn> 
    </v-snackbar>
  </v-card>
</template>

<script>
import Controller from '../controller/controller'

export default {
  name: "RepairInvoice",
  data() {
    return {
      // item in combobox
      brands: [],
      computerType: [],
      tools: [],

      // form input for repair invoice
      invoice: {
        type: null,
        brand: null,
        date: null,
        tools: [],
        email: null,
        phone: null,
        describe: null,
        customer: this.$route.params.username
      },

      // switching
      snackbarSuccess: false,
      snackbarError: false,

      date: new Date().toISOString().substr(0, 10),
      menu: false,
      currentDate: new Date().toDateString(),
      rules: {
        number: value => {
            const pattern = /^\d+$/
            return pattern.test(value) || "ยังไม่ได้กรอกหรือกรอกรูปแบบไม่ถูกต้อง"
        },
        email: value => {
          const pattern = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
          return pattern.test(value) || "รูปแบบอีเมล์ไม่ถูกต้อง";
        }
      }
    };
  },
  mounted() {
    Controller.getAllBrand()
      .then(response => {
        var brand = []
        this.brands = response.data
        this.$log.debug("Data loaded: ", this.brands)
        this.brands.forEach(element => {
          brand.push({
            text: element.name,
            value: element.brandId
          })
        })
        this.brands = brand
      })
      .catch(error => {
        this.$log.debug(error)
      })

    Controller.getAllType()
      .then(response => {
        var type = []
        this.computerType = response.data
        this.$log.debug("Data loaded: ", this.computerType)
        this.computerType.forEach(element => {
          type.push({
            text: element.type,
            value: element.computerTypeId
          })
        })
        this.computerType = type
      })
      .catch(error => {
        this.$log.debug(error)
      })

    Controller.getAllTool()
      .then(response => {
        var tool = []
        this.tools = response.data
        this.$log.debug("Data loaded: ", this.tools)
        this.tools.forEach(element => {
          tool.push({
            text: element.name,
            value: element.toolId
          })
        })
        this.tools = tool
      })
      .catch(error => {
        this.$log.debug(error)
      })
  },
  methods: {
    addInvoice: function () {
      this.$log.debug(this.invoice)
      Controller.addInvoice(this.invoice, this.invoice.tools)
      .then((response) => {
        this.snackbarSuccess = true
        this.snackbarError = false
        this.$log.debug(response)
        this.$log.debug("Add Complete: ", this.invoice)
      })
      .catch(error => {
        this.snackbarSuccess = false
        this.snackbarError = true
        this.$log.debug(error)
      })
    }
  }
};
</script>



