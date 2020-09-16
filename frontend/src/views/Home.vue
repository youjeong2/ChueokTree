// home을 idex에서 보여줌, router에 있는 home을 찾아서 보여줌
<template>
  <Layout>
    <!-- Layout의 menubar로 정보가 전달됨) -->
    <template #menubar>
      <div class="home">
        <!-- <img alt="Vue logo" src="../assets/logo.png"> -->
        <!-- -isAuthorized 권한이 있으면 체크를 해서 접근을 할 수 있게 해줌
             -권한이 부여된거니까 로그아웃이 되게하고 @클릭하면 로그아웃이 되게 -->
        <div id="header" v-if="isAuthorized">
          <button id="login" @click="onClickLogout">Logout</button>
          <v-btn @click="$router.push({ name: 'About' })" text color="white"
            style="padding: 10px; width: 100px;">About</v-btn>
          <v-btn @click="$router.push({ name: 'VuetifyBoardListPage' })" text color="white"
            style="padding: 10px; width: 100px;">Coumunity</v-btn>
          <v-btn @click="$router.push({ name: 'VuetifyBoard' })" text color="white"
            style="padding: 10px; width: 100px;">TourList</v-btn>
          <v-btn @click="$router.push({ name: 'CrawlCategory' })" text color="white"
            style="padding: 100px; width: 100px;">TouristCategory</v-btn>

          <div>
            <!-- <br><span>{{ myinfo.auth }}계정, 접속을 환영합니다.</span> -->
          </div>
        </div>
        <!-- 로그인 하지 않았을 경우 -->
        <div id="header" v-else>
          <v-btn @click="$router.push({ name: 'About' })" text color="white"
            style="padding: 10px; width: 100px;">About</v-btn>
          <v-btn @click="$router.push({ name: 'VuetifyBoardListPage' })" text color="white"
            style="padding: 10px; width: 100px;">Coumunity</v-btn>
          <v-btn @click="$router.push({ name: 'VuetifyBoard' })" text color="white"
            style="padding: 10px; width: 100px;">TourList</v-btn>
          <v-btn @click="$router.push({ name: 'CrawlCategory' })" text color="white"
            style="padding: 100px; width: 100px;">TouristCategory</v-btn>
          <v-btn @click="$router.push({ name: 'LoginPage' })" text color="white"
            style="padding: 4px; width: 100px;">Login</v-btn>
          <v-btn @click="$router.push({ name: 'AdminSetupPage' })" text color="white"
            style="padding: 2px; width: 100px;">Register</v-btn>
        </div>
      </div>
    </template>
    <template #content>
      <v-simple-table>
        <template v-slot:default>
        <div id="app">
          <v-app id="inspire">
            <v-row>
              <v-col cols="12" sm="6" md="12">
                <v-hover v-slot:default="{ hover }" open-delay="200">
                  <v-card :elevation="hover ? 16 : 2" class="mx-auto" height="250" max-width="200">
                    <v-card-text class="font-weight-medium mt-12 text-center subtitle-1">
                    <v-img src="../assets/1.jpg" width="200"></v-img>
                    BlueBerry!
                  </v-card-text>
                </v-card>
              </v-hover>
            </v-col>
          </v-row>
        </v-app>
      </div>
        </template>
      </v-simple-table>
    </template>
  </Layout>
</template>
<script>
// @ is an alias to /src

/* eslint-disable no-unused-vars */
import store from '../store'
import Vue from 'vue'
import Layout from '../components/Layout'
import axios from 'axios'
// import cookies from 'vue-cookies'

import { mapState, mapGetters, mapActions } from 'vuex'

// Vue.use(cookies)

export default {
  name: 'Home',
  data: function () {
    return {
      message: 'Vue Test Message',
      pageArray: []
    }
  },
  methods: {
    onClickLogout () {
      this.logout()
      alert('Success Logout')
      this.$router.push({ name: 'Home' })
    },
    ...mapActions(['logout'])
  },
  computed: {
    ...mapState(['myinfo']),
    ...mapGetters(['isAuthorized'])
  },
  components: {
    Layout
  },
  created () {
    axios.get('http://sample.bmaster.kro.kr/contacts')
      .then(res => {
        console.log(res)
        // pageArray를 res.data로 보내기
        this.pageArray = res.data.contacts
      })
      .catch(err => {
        console.log(err)
      })
  }
}</script>
