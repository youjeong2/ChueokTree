<template>
  <div>
    <v-card-title>
      COMMUNITY
      <v-divider class="mx-12" inset vertical></v-divider>
        <v-text-field
          color="purple darken-2"
          v-model="search"
          append-icon="mdi-magnify"
          label="Search"
          single-line
          hide-details
          class="ma-5 mr-7 ml-12">
        </v-text-field>
        <v-row>
          <v-btn @click="$router.push({ name: 'BoardRegisterPage' })"
          class="ma-" outlined large fab color="purple darken-2">
          <v-icon>mdi-pencil</v-icon></v-btn>
        </v-row>
    </v-card-title>

    <v-data-table
      :headers="headers"
      :items="paginatedData"
      :search="search">
      <template v-slot:item.title="{ item }">
        <div @click="moveRead(item.boardNo)">{{ item.title  }}</div>
      </template>
    </v-data-table>
    <v-col cols="5" sm="5" md="5" lg="5">
    <div class="btn-cover">
      <v-btn :disabled="pageNum === 0"
        @click="prevPage" fab width="40" height="40" color="purple darken-2"
        class="page-btn mr-2"><v-icon>mdi-chevron-left</v-icon></v-btn>
        <span class="page-count grey--text" >{{ pageNum + 1 }} / {{ pageCount }} 페이지</span>
       <v-btn :disabled="pageNum >= pageCount - 1" @click="nextPage" fab width="40" height="40" color="purple darken-3"
      class="page-btn ml-2"><v-icon>mdi-chevron-right</v-icon></v-btn>
    </div>
    </v-col>
  </div>
</template>

<script>
import router from '@/router'

export default {
  name: 'BoardListPageForm',
  data () {
    return {
      pageNum: 0,
      pageArray: [],
      search: '',
      headers: [
        {
          text: 'No',
          align: 'center',
          sortable: true,
          value: 'boardNo',
          width: '10%'
        },
        {
          text: 'Title',
          align: 'center',
          sortable: false,
          value: 'title'
        },
        {
          text: 'Writer',
          align: 'center',
          sortable: false,
          value: 'writer',
          width: '20%'
        },
        {
          text: 'Registration Date',
          align: 'center',
          sortable: false,
          value: 'regDate',
          width: '20%'
        }
      ]
    }
  },
  // 아래쪽VutifyBoardListPage에서 만든listArray를 넣주기
  // pageArray는 views에서 list-array는 compo에서 바인드로 전달받음 (data, props)
  props: {
    listArray: {
      type: Array,
      required: true
    },
    pageSize: {
      type: Number,
      required: true,
      default: 5
    }
  },
  methods: {
    nextPage () {
      this.pageNum += 1
    },
    prevPage () {
      this.pageNum -= 1
    },
    moveRead (boardNo) {
      router.push({ name: 'BoardReadPage', params: { boardNo: boardNo } })
    }
  },
  // 여기의 계산식에 의해 위의 페이지가 Count됨
  computed: {
    pageCount () {
      const listLen = this.listArray.length
      const listSize = this.pageSize
      // 디비에 들어온 데이터의 개수 전체길이에서 5로 나누기
      let page = Math.floor(listLen / listSize)
      if (listLen % listSize > 0) {
        page += 1
      }

      return page
    },
    // pagenatedData를 listArray로 return해서 list채워짐
    // 5개의 데이터
    paginatedData () {
      const start = this.pageNum * this.pageSize
      const end = start + this.pageSize
      return this.listArray.slice(start, end)
    }
  }
}
</script>

<style>
  border: 2px solid b
</style>
