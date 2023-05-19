<template>
  <b-modal :id="'event-'+event.id" hide-footer hide-header body-class="py-4" @show="showModal">
    <template #default="{cancel}">
      <div class="text-center px-3 h4 mb-4">
        Запись на {{ event.name }}
      </div>
      <div class="px-5">
        <div class="font-weight-bold">
          Выберите корпус:
        </div>
        <b-form-group v-slot="{ ariaDescribedby }">
          <b-form-radio
            v-for="place in event.places"
            :key="place"
            v-model="form.place"
            :aria-describedby="ariaDescribedby"
            :value="place"
          >
            {{ place }}
          </b-form-radio>
        </b-form-group>
        <div class="font-weight-bold mt-2">
          Выберите дату и время:
        </div>
        <b-form-group v-slot="{ ariaDescribedby }">
          <b-form-radio
            v-for="date in event.dates"
            :key="date"
            v-model="form.date"
            :aria-describedby="ariaDescribedby"
            :value="date"
          >
            {{ $dayjs(date).format('DD.MM.YYYY (HH:mm)') }}
          </b-form-radio>
        </b-form-group>
      </div>
      <div class="mt-4 d-flex flex-column align-items-center">
        <b-button class="w-50" variant="primary" :disabled="!form.place || !form.date" @click="signToEvent">
          Записаться
        </b-button>
        <b-button class="w-50 text-secondary" variant="link" @click="cancel">
          Закрыть
        </b-button>
      </div>
    </template>
  </b-modal>
</template>

<script>
export default {
  name: 'EventModal',

  props: {
    event: {
      type: Object,
      default: () => ({})
    }
  },

  data: () => ({
    form: {
      place: null,
      date: null
    }
  }),

  methods: {
    signToEvent () {
      this.$bvModal.hide('event-' + this.event.id)
    },

    showModal () {
      this.form.place = null
      this.form.date = null
    }
  }
}
</script>

<style scoped>

</style>
