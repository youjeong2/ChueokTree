VuetifyBoardListPage 홈추가 라우터추가
VuetifyBoardListPageForm-->
<template>
  <Layout>
    <template #content>
      <div align="center">
      <br>
        <h2 class="oblique">instagram</h2>
         <vuetify-board-list-form/>
      </div>
  </template>
</Layout>
</template>

<script>
import Layout from '@/components/Layout.vue'
import VuetifyBoardListForm from '@/components/board/VuetifyBoardListForm.vue'

export default {
  name: 'VuetifyBoard',
  components: {
    VuetifyBoardListForm,
    Layout
  }
}
</script>

<style>
h2.oblique {
  font-style: oblique;
  letter-spacing: 3px;
  background-color: lightgrey;
}
</style>
