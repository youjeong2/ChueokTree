<template>
  <Layout>
    <template #content>
        <div align="center">
          <h2>로그인</h2>
          <login-form @submit="onSubmit"/>
        </div>
    </template>
  </Layout>
</template>

<script>
import LoginForm from '@/components/member/LoginForm.vue'
import { mapActions } from 'vuex'
import Layout from '@/components/Layout.vue'
export default {
  name: 'LoginPage',
  components: {
    Layout,
    LoginForm
  },
  methods: {
    onSubmit (payload) {
      console.log('loginPage onSubmit()')
      this.login(payload).then(res => {
        alert('Enjoy Your Blueberry!')
        this.$router.push({ name: 'Home' })
      }).catch(err => {
        // alert(err.response.data.message)
        alert('존재하지 않는 아이디입니다. ', err)
      })
    },
    ...mapActions(['login'])
  }
}
</script>
