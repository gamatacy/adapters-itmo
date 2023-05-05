<template>
  <b-modal id="events-by-date" title="События" hide-footer>
    <div v-for="(event, i) in events" :key="i" class="mb-3">
      <event-card :event="event" />
    </div>
  </b-modal>
</template>

<script>
import EventCard from './EventCard'
export default {
  name: 'EventsByDateModal',
  components: { EventCard },
  props: {
    events: {
      type: Array,
      required: true
    }
  }
}
</script>

<style scoped>

</style>
