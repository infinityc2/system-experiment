<template>
  <v-app>
    <v-content>
      <v-container fluid fill-height>
        <v-layout align-center justify-center>
          <v-flex xs12 sm8 md4>
            <v-card class="elevation-12">
              <v-toolbar color="primary" dark flat>
                <v-toolbar-title>เข้าสู่ระบบ</v-toolbar-title>
                <v-spacer></v-spacer>
              </v-toolbar>
              <v-card-text @keyup.enter="userLogin">
                <v-form>
                  <v-text-field
                    v-model="user.username"
                    label="Login"
                    name="login"
                    prepend-icon="person"
                    type="text"
                  ></v-text-field>

                  <v-text-field
                    v-model="user.password"
                    id="password"
                    label="Password"
                    name="password"
                    prepend-icon="lock"
                    type="password"
                  ></v-text-field>
                </v-form>
              </v-card-text>
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn color="primary" @click="userLogin">Login</v-btn>
              </v-card-actions>
            </v-card>
          </v-flex>
        </v-layout>
      </v-container>
    </v-content>
  </v-app>
</template>

<script>
import Controller from "../controller/controller";

export default {
  data() {
    return {
      user: {
        username: null,
        password: null
      }
    };
  },
  methods: {
    userLogin: function() {
      Controller.signIn(this.user)
        .then(response => {
          if (response.data) {
            this.$route.params.username = this.user.username
            this.$router.push("/dashboard/" + this.user.username + '/invoice')
          } else {
            this.$log.debug("username or password incorrect")
          }
        })
        .catch(error => {
          this.$log.debug(error);
        });
    }
  }
};
</script>