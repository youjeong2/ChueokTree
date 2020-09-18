<template>
 <Layout>
   <template #content>
      <div id="app">
          <v-row justify="center">
            <v-col cols="20" sm="10" md="7" lg="11">
              <v-card ref="form">
                <v-col cols="12" sm="10" md="8" lg="5" >
                  <v-text-field
                      input type="text" v-model="title"
                      color="purple darken-2"
                      label="title"
                    ></v-text-field>
                    </v-col>

                    <v-col cols="12" sm="10" md="8" lg="5">
                    <v-text-field
                      input type="text" v-model="writer"
                      color="purple darken-2"
                      label="writer"
                    ></v-text-field>
                    </v-col>

                <v-col cols="12" sm="10" md="8" lg="5" >
                  <v-text-field
                      textarea v-model="content" rows="5"
                      color="purple darken-2"
                      label="content"
                    ></v-text-field>
                    </v-col>

                <v-col cols="5" sm="5" md="5" lg="5">
                <v-btn class="mr-4" @click="onSubmit">submit</v-btn>
                <v-btn @click="clear">clear</v-btn>
                </v-col>
                <br><br>
              </v-card>
            </v-col>
          </v-row>
      </div>
    </template>
  </Layout>
</template>

<script>
import Layout from '@/components/Layout.vue'

export default {
  name: 'BoardRegisterForm',
  data () {
    return {
      title: '',
      writer: '',
      content: ''
    }
  },
  components: {
    Layout
  },
  methods: {
    onSubmit () {
      const { title, writer, content } = this
      this.$emit('submit', { title, writer, content })
    }
  }
}
</script>
