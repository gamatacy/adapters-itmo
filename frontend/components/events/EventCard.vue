<template>
  <b-card class="h-100">
    <div class="d-flex flex-column justify-content-between h-100">
      <div>
        <div class="h4">
          {{ event.name }}
        </div>
        <template v-if="event.signed===null || isAdmin">
          <div>
            {{ event.places.join(', ') }}
          </div>
          <b-badge v-for="(date, i) in event.dates" :key="i" class="mr-2 mt-2">
            {{ $dayjs(date).format('DD.MM.YYYY (HH:mm)') }}
          </b-badge>
        </template>
        <template v-else>
          <div>
            {{ event.signed.place }}
          </div>
          <b-badge class="mt-2">
            {{ $dayjs(event.signed.date).format('DD.MM.YYYY (HH:mm)') }}
          </b-badge>
        </template>
      </div>
      <div v-if="isAdmin" class="d-flex justify-content-center mt-3">
        <b-button v-b-modal="'event-admin-'+event.id" variant="primary">
          Отметить посещение
        </b-button>
      </div>
      <div v-else>
        <div v-if="event.signed===null" class="d-flex justify-content-center mt-3">
          <b-button v-b-modal="'event-'+event.id" variant="primary">
            Записаться
          </b-button>
        </div>
        <div v-else class="text-center mb-2 mt-3 text-secondary">
          Вы уже записаны
        </div>
      </div>
    </div>
  </b-card>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  name: 'EventCard',

  props: {
    event: {
      type: Object,
      default: () => ({})
    }
  },

  computed: { ...mapGetters('modules/user', ['isAdmin']) }
}
</script>

<style scoped>

</style>
