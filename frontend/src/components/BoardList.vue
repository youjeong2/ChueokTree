// 하위 컴포넌트들을 작성해주면됨
<template>
  <Layout>
    <template #content>
      <v-simple-table>
        <thead>
          <tr>
            <th align="center" width="80">No</th>
            <th align="center" width="320">Title</th>
            <th align="center" width="100">Writer</th>
            <th align="center" width="180">Registration aDate</th>
          </tr>
        </thead>
        <tbody>
          <tr v-if="!boards || (Array.isArray(boards) && boards.length === 0)">
            <td colspan="4">
              List is empty
            </td>
          </tr>

          <tr v-else v-for="board in boards" :key="board.boardNo">
            <td align="center">{{ board.boardNo }}</td>
            <td align="left">
              <router-link :to="{ name: 'BoardReadPage',
                      params: { boardNo: board.boardNo.toString() } }">
                {{ board.title }}
              </router-link>
            </td>
            <td align="right">{{ board.writer }}</td>
            <td align="center">{{ board.regDate }}</td>
          </tr>
          <board-list-page-form :list-array="pageArray"/>
        </tbody>
      </v-simple-table>
    </template>
  </Layout>
</template>

<script>
import Layout from '@/components/Layout.vue'
import BoardListPageForm from '@/components/BoardListPageForm.vue'
export default {
  name: 'BoardList',
  components: {
    Layout,
    BoardListPageForm
  },
  props: {
    boards: {
      type: Array
    }
  }
}
</script>
