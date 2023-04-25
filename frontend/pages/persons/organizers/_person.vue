<template>
  <div>
    <div class="h2 text-primary">
      Организаторы
    </div>
    <b-button class="btn-back mb-3" variant="white" @click="$router.go(-1)">
      <b-icon icon="arrow-left" class="mr-2" />Назад
    </b-button>

    <person-profile :is-loading="isLoading" :person="person" />
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import PersonProfile from '../../../components/persons/PersonProfile'

export default {
  name: 'OrganizersPersonPage',

  components: { PersonProfile },

  computed: {
    ...mapGetters('modules/persons', ['isLoading', 'person'])
  },

  async mounted () {
    await this.$store.dispatch('modules/persons/getPerson', this.$route.params.person)
  }
}
</script>

<style scoped>
.profile-photo{
  width: 100%;
  max-width: 250px;
}
</style>
