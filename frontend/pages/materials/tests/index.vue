<template>
  <div>
    <div class="h2 text-primary">
      Тесты
    </div>
    <b-button class="btn-back" variant="white" @click="$router.go(-1)">
      <b-icon icon="arrow-left" class="mr-2" />Назад
    </b-button>

    <b-row class="mt-3" align-v="stretch">
      <b-col
        v-for="(test,i) in tests"
        :key="i"
        cols="12"
        md="6"
        lg="4"
        class="mb-3"
      >
        <b-card class="h-100">
          <img :src="test.photo" width="100%" class="rounded" :alt="test.photo">
          <div class="font-weight-semibold text-center mt-2">
            {{ test.name }}
          </div>
          <b-button v-if="test.points === null" :to="'/materials/tests/'+test.id" class="mt-2 w-100" variant="primary">
            Пройти
          </b-button>
          <div v-else class="mt-1 py-2 text-center">
            Вы набрали {{ test.points }}%
          </div>
        </b-card>
      </b-col>
    </b-row>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  name: 'TestsPage',

  computed: {
    ...mapGetters('modules/tests', ['tests'])
  },

  mounted () {
    this.$store.dispatch('modules/tests/getTests')
  }
}
</script>

<style>

</style>
