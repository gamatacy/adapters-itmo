<template>
  <b-modal :id="'event-'+event.id" :title="'Запись на '+ event.name" @show="showModal">
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
    <template #modal-footer="{ cancel }">
      <b-button variant="secondary" @click="cancel">
        Закрыть
      </b-button>
      <b-button variant="primary" :disabled="!form.place || !form.date" @click="signToEvent">
        Записаться
      </b-button>
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
    signToEvent () {},

    showModal () {
      this.form.place = null
      this.form.date = null
    }
  }
}
</script>

<style scoped>

</style>
