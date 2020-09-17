<template>
  <div id="app">
      <v-row justify="center">
        <v-col cols="20" sm="10" md="7" lg="11">
          <v-card ref="form">
            <v-col cols="12" sm="10" md="8" lg="5">
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
                  v-model="password"
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
            <v-btn class="mr-4" @click="submit">submit</v-btn>
            <v-btn @click="clear">clear</v-btn>
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
    }
  }
}
</script>
