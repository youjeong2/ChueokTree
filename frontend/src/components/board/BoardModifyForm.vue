<template>
  <Layout>
    <template #content>
      <div>
      <v-sheet color="purple darken-2" dark> - Board Modify View - </v-sheet>
    <form @submit.prevent="onSubmit">
      <table>
        <tr>
          <v-subheader>번호</v-subheader>
          <td><input type="text" :value="board.boardNo" disabled></td>
        </tr>
        <tr>
          <v-subheader>작성일</v-subheader>
          <td><input type="text" :value="board.regDate" disabled></td>
        </tr>
        <tr>
          <v-subheader>제목</v-subheader>
          <!-- 내가 수정한 정보를 보내야하니까 그냥 title -->
          <td><v-text-field input type="text" v-model="title"
          color="purple darken-2" rows="2"></v-text-field></td>
        </tr>
        <tr>
          <v-subheader>작성자</v-subheader>
          <!-- 얘는 바인드 -->
            <td><v-text-field :value="board.writer" readonly
            color="purple darken-2" rows="2"></v-text-field></td>
        </tr>
        <tr>
          <v-subheader>내용</v-subheader>
          <td><v-textarea v-model="content" rows="5"
          outlined color="purple darken-2" filled></v-textarea></td>
        </tr>
      </table>
      <div>
      <v-col cols="5" sm="5" md="5" lg="5">
        <v-btn type="submit" class="mr-3 ml-10"
        outlined color="purple darken-2" text="white">수정</v-btn>
        <v-btn @click="$router.push({ name: 'BoardReadPage', params: { boardNo: board.boardNo.toString() } })"
        class="mr-3" outlined color="purple darken-2" text="white">취소</v-btn>
      </v-col>
      </div>
    </form>
      </div>
    </template>
  </Layout>
</template>

<script>
import Layout from '@/components/Layout.vue'

export default {
  name: 'BoardModifyForm',
  components: {
    Layout
  },
  props: {
    board: {
      type: Object,
      required: true
    }
  },
  data () {
    return {
      title: '',
      content: '',
      writer: ''

    }
  },
  methods: {
    onSubmit () {
      const { title, content } = this
      this.$emit('submit', { title, content })
    }
  },
  created () {
    this.title = this.board.title
    this.content = this.board.content
  }
}
</script>
