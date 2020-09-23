<template>
  <div id="app">
      <v-row justify="center">
        <v-col cols="20" sm="10" md="7" lg="11">
          <v-card ref="form">
            <v-col cols="12" sm="10" md="8" lg="5" >
              <v-text-field
                v-model="userid"
                  color="purple darken-2"
                  :error-messages="IdErrors"
                  :counter="10"
                  label="Id"
                  required
                  @input="$v.name.$touch()"
                  @blur="$v.name.$touch()"
                ></v-text-field>
                </v-col>

                <v-col cols="12" sm="10" md="8" lg="5">
                <v-text-field
                  input type="password" v-model="password"
                  color="purple darken-2"
                  :error-messages="passwordErrors"
                  :counter="10"
                  label="Password"
                  required
                  @input="$v.password.$touch()"
                  @blur="$v.password.$touch()"
                  hint="At least 8 characters"
                ></v-text-field>
                </v-col>
            <v-col cols="8" sm="5" md="5" lg="5">
            <v-btn class="mr-4" @click="submit"
            tile color="purple darken-2" dark style="padding: 5px; width: 200px;">로그인</v-btn>
            </v-col>
            <v-btn class="mr-4" @click="$router.push({ name: 'AdminSetupPage' })"
            outlined color="purple darken-2" text="white" style="padding: 5px; width: 200px;">회원가입</v-btn>
            <br><br>
          </v-card>
        </v-col>
      </v-row>
  </div>
</template>

<script>
export default {
  name: 'LoginForm',
  data () {
    return {
      userid: '',
      password: ''
    }
  },
  methods: {
    submit () {
      console.log('LoginForm submit()')
      const { userid, password } = this
      this.$emit('submit', { userid, password })
    },
    clear () {
      this.$v.$reset()
      this.userid = ''
      this.password = ''
      this.select = null
    }
  }
}
</script>
