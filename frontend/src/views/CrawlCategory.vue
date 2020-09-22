<template>
  <Layout>
    <div id="app">
      <v-app id="inspire">
        <div class="text-center">
          <v-sheet color="orange lighten-2">Hello, world! I'm a simple v-sheet</v-sheet>
        </div>
      </v-app>
    </div>
    <!-- Layout의 menubar로 정보가 전달됨) -->
    <template #menubar>
      <v-btn @click="start('society')" text color="white"
        style="padding: 10px; width: 150px;">Attraction</v-btn>
      <v-btn @click="start('politics')" text color="white"
        style="padding: 10px; width: 150px;">Festival</v-btn>
      <v-btn @click="start('economic')" text color="white"
        style="padding: 10px; width: 150px;">Cultural Facility</v-btn>
    </template>
    <template #content>
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
              <td><a @click="clickNews(list.newsNo)">{{ list.title }}</a></td>
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
