<template>
  <v-container fluid>
    <v-row dense>
      <v-col
        v-for="card in cards"
        :key="card.title"
        :cols="card.flex"
      >
      <a href="https://www.instagram.com/chueoktree_blueberry/?hl=ko">
            <v-img
              :src="card.src"
              class="white--text align-end"
              gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
              height="300px"
            >
              <v-card-title v-text="card.title"></v-card-title>
            </v-img>
      </a>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: 'VuetifyBoardListForm',
  // 데이터
  data: () => ({
    cards: [
      { title: '', src: 'https://cdn.vuetifyjs.com/images/cards/house.jpg', flex: 4 },
      { title: '', src: 'https://cdn.vuetifyjs.com/images/cards/road.jpg', flex: 4 },
      { title: '', src: 'https://cdn.vuetifyjs.com/images/cards/plane.jpg', flex: 4 },
      { title: '', src: 'https://cdn.vuetifyjs.com/images/cards/house.jpg', flex: 4 },
      { title: '', src: 'https://cdn.vuetifyjs.com/images/cards/road.jpg', flex: 4 },
      { title: '', src: 'https://cdn.vuetifyjs.com/images/cards/plane.jpg', flex: 4 }
    ]
  })
}
</script>
