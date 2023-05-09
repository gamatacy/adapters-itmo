<template>
  <b-overlay :show="isLoading" class="h-100">
    <div class="d-flex flex-column justify-content-between h-100">
      <div>
        <b-row class="justify-content-center mt-2">
          <b-col cols="10" lg="8">
            <b-input
              v-model="searchQuery"
              class="rounded-pill px-4"
              placeholder="Введите имя"
              @keyup.enter="searchPersons"
            />
          </b-col>
        </b-row>

        <b-row class="mt-4" align-v="stretch">
          <b-col
            v-for="person in persons ? persons.data : []"
            :key="person.id"
            cols="12"
            md="6"
            lg="4"
            xl="3"
            class="pb-3 col-xxl-3"
          >
            <person-card :person="person" />
          </b-col>
        </b-row>
      </div>

      <div
        v-if="persons && persons.count > params.limit"
        class="d-flex justify-content-center mt-3"
      >
        <b-pagination
          :value="params.offset / params.limit + 1"
          :total-rows="persons.count"
          :per-page="params.limit"
          @input="pageChanged($event)"
        />
      </div>
    </div>
  </b-overlay>
</template>

<script>
import PersonCard from '@/components/persons/PersonCard'

export default {
  name: 'PersonsList',

  components: { PersonCard },

  props: {
    persons: {
      type: Object,
      default: () => ({})
    },
    isLoading: {
      type: Boolean,
      default: false
    }
  },

  data: () => {
    return {
      searchQuery: '',
      params: {
        limit: 12,
        offset: 0
      }
    }
  },

  watch: {
    $route: {
      async handler () {
        await this.getRouteQuery()
      },
      deep: true,
      immediate: true
    }
  },

  methods: {
    getRouteQuery () {
      if (this.$route.query.p) {
        this.params.offset = (this.$route.query.p - 1) * this.params.limit
      } else {
        this.params.offset = 0
      }
      if (this.$route.query.q) {
        this.searchQuery = this.$route.query.q
      } else {
        this.searchQuery = ''
      }
      this.getPersons()
    },

    searchPersons () {
      this.params.offset = 0
      this.addHashToLocation()
    },

    getPersons () {
      if (typeof window !== 'undefined') {
        window.scrollTo({
          top: 0,
          behavior: 'smooth'
        })
      }
      this.$emit('getPersons', {
        query: this.searchQuery,
        params: this.params
      })
    },

    pageChanged (page) {
      this.params.offset = (page - 1) * this.params.limit
      this.addHashToLocation()
    },

    addHashToLocation () {
      const query = {}
      query.p = this.params.offset / this.params.limit + 1
      if (this.searchQuery !== '') {
        query.q = this.searchQuery
      }
      this.$router.push({ query })
    }
  }
}
</script>

<style scoped>

</style>
