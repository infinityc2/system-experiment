<template>
  <v-app>
    <v-navigation-drawer app v-model="drawer">
      <v-list dense>
        <v-list-item link :to="toInvoice">
          <v-list-item-action>
            <v-icon>list_alt</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>
              แจ้งซ่อมคอมพิวเตอร์
            </v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <v-list-item link @click="logOut">
          <v-list-item-action>
            <v-icon>clear</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>
              ออกจากระบบ
            </v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>

    <v-app-bar app color="primary" dark>
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title>ระบบแจ้งซ่อมคอมพิวเตอร์</v-toolbar-title>
    </v-app-bar>

    <v-content>
      <router-view />
    </v-content>

    <v-footer app></v-footer>
  </v-app>
</template>

<script>
export default {
  data() {
    return {
      drawer: null,
      toInvoice: '/dashboard/'+ this.$route.params.username + '/invoice'
    }
  },
  methods: {
    logOut: function () {
      this.$route.params.username = null
      this.$router.push('/login')
    }
  }
};
</script>

