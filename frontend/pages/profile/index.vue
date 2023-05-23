<template>
  <div>
    <person-profile :is-loading="isLoading" :person="user">
      <template #logout>
        <b-button variant="white" class="shadow-none d-none d-lg-flex" @click="logout">
          <b-icon icon="box-arrow-right" />
        </b-button>
      </template>
    </person-profile>
    <div class="d-flex justify-content-center">
      <b-button variant="link" class="shadow-none mt-2 d-lg-none" @click="logout">
        Выйти
      </b-button>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import PersonProfile from '../../components/persons/PersonProfile'

export default {
  name: 'ProfilePage',

  components: { PersonProfile },

  computed: {
    ...mapGetters('modules/user', ['isLoading', 'user'])
  },

  async mounted () {
    await this.$store.dispatch('modules/user/getUserInfo')
  },

  methods: {
    logout () {
      this.$router.push('/login')
    }
  }
}
</script>

<style scoped>

</style>
