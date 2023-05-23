<template>
  <div v-if="test">
    <div class="h3 text-center">
      {{ test.name }}
    </div>

    <div v-if="type===0" class="my-3">
      <b-form-group
        v-for="question in test.questions"
        :key="question.id"
        v-slot="{ ariaDescribedby }"
        :label="question.text"
      >
        <b-form-checkbox-group
          v-model="form[question.id]"
          :options="question.variants"
          :aria-describedby="ariaDescribedby"
          stacked
        />
      </b-form-group>
      <div class="d-flex justify-content-center">
        <b-button variant="primary" @click="type=1">
          Отправить
        </b-button>
      </div>
    </div>

    <template v-if="type===1">
      <div class="h5 text-center mt-4">
        Вы набрали 80%
      </div>
      <div class="d-flex justify-content-center mt-3">
        <b-button variant="link" to="/materials/tests">
          Назад ко всем тестам
        </b-button>
      </div>
    </template>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  name: 'TestPage',

  data: () => ({ form: {}, type: 0 }),

  computed: {
    ...mapGetters('modules/tests', ['test'])
  },

  mounted () {
    this.$store.dispatch('modules/tests/getTest', this.$route.params.test)
    this.test.questions.forEach((question) => {
      this.form[question.id] = []
    })
  }
}
</script>

<style scoped>

</style>
