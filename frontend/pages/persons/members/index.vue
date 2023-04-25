<template>
  <div>
    <div class="h2 text-primary">
      Участники
    </div>
    <b-button class="btn-back" variant="white" @click="$router.go(-1)">
      <b-icon icon="arrow-left" class="mr-2" />Назад
    </b-button>

    <PersonsList :persons="persons" :is-loading="isLoading" @getPersons="getPersons" />
  </div>
</template>

<script>
import PersonsList from '@/components/persons/PersonsList'

export default {
  name: 'MembersPage',

  components: { PersonsList },

  computed: {
    persons () {
      return this.$store.getters['modules/persons/persons']
    },

    isLoading () {
      return this.$store.getters['modules/persons/persons/isLoading']
    }
  },

  methods: {
    getPersons () {
      this.$store.dispatch('modules/persons/getPersons', {
        query: this.searchQuery,
        params: this.params
      })
    }
  }
}
</script>

<style scoped>

</style>
