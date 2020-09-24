<template>
  <Layout>
  <template #content>
  <div align="center" >
        <div>
        <v-sheet color="purple darken-2" dark> - Board Detailed View - </v-sheet>
        <table>
          <tr>
             <v-subheader>번호</v-subheader>
            <td><input type="text" :value="
            board.boardNo" readonly></td>
          </tr>
          <tr>
            <v-subheader>작성일</v-subheader>
            <td><input type="text" :value="board.regDate" color="blue" readonly>
            </td>
          </tr>
          <tr>
            <!-- 보드에서 title을 받아오겠다 -->
            <v-subheader>제목</v-subheader>
            <td><v-text-field :value="board.title" readonly
            color="purple darken-2" rows="2"></v-text-field></td>
          </tr>
          <tr>
            <v-subheader>작성자</v-subheader>
            <td><v-text-field :value="board.writer" readonly
            color="purple darken-2" rows="2"></v-text-field></td>
          </tr>
          <tr>
            <v-subheader>내용</v-subheader>
            <td><v-textarea :value="board.content" rows="5" readonly
              outlined color="purple darken-2" filled></v-textarea></td>
          </tr>
        </table>
        <v-col cols="5" sm="5" md="5" lg="5">
          <v-btn @click="$router.push({ name: 'BoardModifyPage', params: { boardNo } })" class="mr-3 ml-10" outlined color="purple darken-2" text="white">수정</v-btn>
          <!-- 버튼은 @클릭을 onDelte를 동작시키기 -->
          <v-btn @click="onDelete" class="mr-3" outlined color="purple darken-2" text="white">삭제</v-btn>
          <v-btn @click="$router.push({ name: 'VuetifyBoardListPage' })" class="mr-3" outlined color="purple darken-2" text="white">목록</v-btn>
        </v-col>
      </div>
  </div>
  </template>
  </Layout>
</template>

<script>
import Layout from '@/components/Layout.vue'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

export default {
  name: 'BoardRead',
  components: {
    Layout
  },
  computed: {
    ...mapState([
      'board'
    ])
  },
  methods: {
    ...mapActions([
      'fetchBoard'
    ]),
    onDelete () {
      // 보드에 보드넘을 보내달라
      const { boardNo } = this.board
      axios.delete(`http://localhost:7777/boards/${boardNo}`)
        // 처리결과를 res로 처리결과 성공이면 success
        .then(res => {
          alert('Delete Success')
          // delete를 누르면 BoardListPage로 강제로 보내기
          this.$router.push({ name: 'VuetifyBoardListPage' })
        })
        .catch(err => {
          alert(err.response.data.message)
        })
    }
  },
  props: {
    board: {
      type: Object,
      required: true
    },
    boardNo: {
      type: String,
      required: true
    }
  }
}
</script>
