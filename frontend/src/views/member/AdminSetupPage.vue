<template>
  <Layout>
     <template #content>
      <div align="center">
        <h2>회원가입</h2>
        <admin-setup-form @submit="onSubmit"/>
      </div>
     </template>
  </Layout>
</template>

<script>
import axios from 'axios'
import AdminSetupForm from '@/components/member/AdminSetupForm.vue'
import Layout from '@/components/Layout.vue'

export default {
  name: 'AdminSetupPage',
  components: {
    AdminSetupForm,
    Layout
  },
  methods: {
    onSubmit (payload) {
      console.log('payload: ' + payload.userId +
                  ', ' + payload.userName +
                  ', ' + payload.userPw)
      const { userId, userName, userPw } = payload
      axios.post('http://localhost:7777/users/setup',
        { userId, userName, userPw })
        .then(res => {
          alert('Register Success')
          this.$router.push({
            name: 'Home'
          })
        })
        .catch(err => {
          alert(err.response.data)
        })
    }
  }
}
</script>
