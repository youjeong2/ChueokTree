<template>
  <Layout>
    <template #content>
        <div align="center">
          <h2>Login</h2>
          <login-form @submit="onSubmit"/>
        </div>
    </template>
  </Layout>
</template>

<script>
import LoginForm from '@/components/LoginForm.vue'
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
        alert('Login Success')
        this.$router.push({ name: 'Home' })
      }).catch(err => {
        // alert(err.response.data.message)
        alert('Something Fail: ', err)
      })
    },
    ...mapActions(['login'])
  }
}
</script>
