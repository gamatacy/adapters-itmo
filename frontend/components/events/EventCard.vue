<template>
  <b-card class="h-100">
    <div class="h4">
      {{ event.name }}
    </div>
    <div>
      {{ event.places.join(', ') }}
    </div>
    <b-badge v-for="(date, i) in event.dates" :key="i" class="mr-2 mt-2">
      {{ $dayjs(date).format('DD.MM.YYYY (HH:mm)') }}
    </b-badge>
    <div class="d-flex justify-content-center mt-2">
      <b-button v-b-modal="'event-'+event.id" variant="primary">
        Записаться
      </b-button>
    </div>
  </b-card>
</template>

<script>
export default {
  name: 'EventCard',

  props: {
    event: {
      type: Object,
      default: () => ({})
    }
  }
}
</script>

<style scoped>

</style>
