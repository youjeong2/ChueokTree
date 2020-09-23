<template>
  <div id="app">
      <v-row justify="center">
        <v-col cols="20" sm="10" md="7" lg="11">
          <v-card ref="form">
            <v-col cols="15" >
              <v-text-field
                v-model="userId"
                  color="purple darken-2"
                  :error-messages="IdErrors"
                  :counter="10"
                  label="Email address"
                  suffix="@gmail.com"
                  required
                  @input="$v.name.$touch()"
                  @blur="$v.name.$touch()"
                  :style="{ display: 'inline-block', width: '330px' }"
                ></v-text-field>
                <v-btn class="ml-5" @click="check" v-model="check" width="70" height="35" outlined color="purple darken-2" :style="{ display: 'inline-block' }">중복확인</v-btn>
                </v-col>

                <v-col cols="12" sm="10" md="8" lg="5">
                <v-text-field
                  v-model="userName"
                  color="purple darken-2"
                  label="Name"
                  required
                  @input="$v.password.$touch()"
                  @blur="$v.password.$touch()"
                ></v-text-field>
                </v-col>

                <v-col cols="12" sm="10" md="8" lg="5">
                <v-text-field
                  input type="password" v-model="userPw"
                  color="purple darken-2"
                  :error-messages="passwordErrors"
                  label="Password"
                  required
                  @input="$v.password.$touch()"
                  @blur="$v.password.$touch()"
                  hint="At least 8 characters"
                ></v-text-field>
                </v-col>
                <v-col cols="5" sm="5" md="5" lg="5">
                <v-checkbox
                  v-model="checkbox"
                  :error-messages="checkboxErrors"
                  label="Do you agree?"
                  required
                  @change="$v.checkbox.$touch()"
                  @blur="$v.checkbox.$touch()"
                ></v-checkbox>
                </v-col>
            <v-btn class="mr-4" @click="submit" tile color="purple darken-2" dark style="padding: 5px; width: 200px;">회원가입</v-btn>
            <br><br>
          </v-card>
        </v-col>
      </v-row>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'AdminSetupForm',
  data () {
    return {
      userId: '',
      userName: '',
      userPw: ''
    }
  },
  methods: {
    submit () {
      console.log('this: ' + this.userId +
                  ', ' + this.userName +
                  ', ' + this.userPw)
      const { userId, userName, userPw } = this
      this.$emit('submit', { userId, userName, userPw })
    },
    check () {
      // alert("확인")
      axios.get(`http://localhost:7777/users/idCheck/${this.userId}`)
        .then(res => {
          console.log(res)
          if (res.status === 200) {
            if (res.data === 'success') {
              alert('사용가능한 아이디 입니다.')
            } else {
              alert('이미 있는 아이디 입니다.')
            }
          }
        })
        .catch(err => {
          console.log(err)
          alert('error')
        })
    }
  }
}
</script>
