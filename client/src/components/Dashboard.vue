<template>
  <v-app>
    <v-navigation-drawer app v-model="drawer"></v-navigation-drawer>

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
      drawer: null
    };
  }
};
</script>

