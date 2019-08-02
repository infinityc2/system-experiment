<template>
  <v-card class="mx-auto" max-width="500">
    <v-card-title>แจ้งซ่อมคอมพิวเตอร์</v-card-title>
    <v-card-title class="subtitle-1" style="display: none">วันที่แจ้งซ่อม {{ currentDate }}</v-card-title>
    <v-card-text>
      <v-layout column>
        <v-flex>
          <v-select label="อุปกรณ์ที่ส่งซ่อม"></v-select>
        </v-flex>

        <v-flex>
          <v-select label="ยี่ห้อ"></v-select>
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
            <v-date-picker v-model="date" no-title scrollable>
              <v-spacer></v-spacer>
              <v-btn text color="primary" @click="menu = false">Cancel</v-btn>
              <v-btn text color="primary" @click="$refs.menu.save(date)">OK</v-btn>
            </v-date-picker>
          </v-menu>
        </v-flex>

        <v-flex>
          <v-select chips multiple label="Software ที่ต้องการติดตั้ง"></v-select>
        </v-flex>

        <v-flex>
          <v-text-field label="อีเมล์" :rules="[rules.email]"></v-text-field>
        </v-flex>

        <v-flex>
          <v-text-field label="เบอร์โทรศัพท์" :rules="[rules.number]"></v-text-field>
        </v-flex>

        <v-flex>
          <v-textarea label="รายละเอียด"></v-textarea>
        </v-flex>
      </v-layout>
    </v-card-text>
    <v-card-actions>
      <v-btn color="primary">แจ้งซ่อม</v-btn>
      <v-btn text>กลับ</v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
export default {
  name: "RepairInvoice",
  data() {
    return {
      date: new Date().toISOString().substr(0, 10),
      menu: false,
      currentDate: new Date().toDateString(),
      phone: null,
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
  }
};
</script>



