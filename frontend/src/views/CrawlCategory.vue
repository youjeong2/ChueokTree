<template>
  <Layout>
    <div id="app">
      <v-app id="inspire">
        <div class="text-center">
        </div>
      </v-app>
    </div>
    <!-- Layout의 menubar로 정보가 전달됨) -->
    <template #menubar>
    <div class="menubar">
      <v-btn @click="start('culture')" text color="white"
        style="padding: 10px; width: 150px;">CUlTURE</v-btn>
      <v-btn @click="start('foreign')" text color="white"
        style="padding: 10px; width: 150px;">WORLD</v-btn>
      <v-btn @click="start('digital')" text color="white"
        style="padding: 10px; width: 150px;">TECH</v-btn>
    </div>
    </template>
    <template #content>
      <div class="sheet">
        <v-sheet color="purple darken-2" dark> - ChueokTree Market - </v-sheet>
        <v-alert
          outlined
          color="purple">
          <div class="title"></div>
          <div>click category !<br>Blueberries are perennial flowering plants with blue-or purple-coloerd berries</div>
        </v-alert>
      </div>
      <v-simple-table>
        <template v-slot:default>
          <thead>
            <tr>
              <th class="text-left">No.</th>
              <th class="text-left">제목</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="list of lists" :key="list.title">
              <td style="color: gray">{{ list.newsNo }}</td>
              <!-- a tag 는 링크연 -->
              <a :href="list.address" target="_blank">
              <td><a @click="clickNews(list.newsNo)">{{ list.title }}</a></td>
              </a>
            </tr>
          </tbody>
        </template>
      </v-simple-table>
    </template>
  </Layout>
</template>

<script>
import Layout from '../components/Layout'
import { mapState } from 'vuex'

export default {
  components: { Layout },
  computed: {
    ...mapState({
      lists: state => state.lists
    })
  },
  methods: {
    clickNews (newsNo) {
      console.log('clickNews: ' + newsNo)
      this.$store.dispatch('crawlFindOne', newsNo)
    },
    start (category) {
      this.$store.dispatch('crawlFind', category)
    }
  }
}
</script>

<style>
div.sheet {
  font-family: "Lucida Console", Courier, monospace;
}
div.menubar {
  font-family: "Lucida Console", Courier, monospace;
}
</style>
