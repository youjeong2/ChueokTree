<template>
  <Layout>
  <template #content>
  <div align="center" >
        <div>
        <h3>Board Detailed View</h3>
        <table>
          <tr>
            <td>No</td>
            <td><input type="text" :value="board.boardNo" readonly></td>
          </tr>
          <tr>
            <td>Registration Date</td>
            <td><input type="text" :value="board.regDate" readonly></td>
          </tr>
          <tr>
            <!-- 보드에서 title을 받아오겠다 -->
            <td>Title</td>
            <td><input type="text" :value="board.title" readonly></td>
          </tr>
          <tr>
            <td>Writer</td>
            <td><input type="text" :value="board.writer" readonly></td>
          </tr>
          <tr>
            <td>Content</td>
            <td><textarea :value="board.content" rows="5" readonly></textarea></td>
          </tr>
        </table>
          <v-btn @click="$router.push({ name: 'BoardModifyPage', params: { boardNo } })">Edit</v-btn>
          <!-- 버튼은 @클릭을 onDelte를 동작시키기 -->
          <v-btn @click="onDelete">Delete</v-btn>
          <v-btn @click="$router.push({ name: 'VuetifyBoardListPage' })">List</v-btn>
      </div>
  </div>
  </template>
  </Layout>
</template>

<script>
import Layout from '@/components/Layout.vue'
import { mapState } from 'vuex'

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
