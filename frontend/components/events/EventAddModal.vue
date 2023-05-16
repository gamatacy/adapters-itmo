<template>
  <b-modal id="event-add-modal" hide-footer hide-header body-class="py-4" @show="showModal">
    <template #default="{cancel}">
      <b-form novalidate @submit="addEvent">
        <div class="text-center text-primary h3 mb-4">
          Создать событие
        </div>

        <div class="mb-3">
          <b-form-input
            v-model="form.name"
            placeholder="Название"
            :class="{'is-invalid':!validationName}"
          />
          <b-form-invalid-feedback :state="validationName">
            Обязательно
          </b-form-invalid-feedback>
        </div>

        <div>
          Места проведения
        </div>
        <b-form-invalid-feedback :state="!isTouchedBtn || !!form.places.length">
          Обязательно
        </b-form-invalid-feedback>
        <b-row v-for="(_, i) in form.places" :key="i" no-gutters class="d-flex mt-2">
          <b-col col>
            <b-form-input
              v-model="form.places[i]"
              :class="{'is-invalid':!validationPlace(i)}"
            />
            <b-form-invalid-feedback :state="validationPlace(i)">
              Обязательно
            </b-form-invalid-feedback>
          </b-col>
          <b-col cols="auto">
            <b-button variant="white" class="shadow-none px-1" @click="form.places.splice(i,1)">
              <b-icon icon="x" />
            </b-button>
          </b-col>
        </b-row>
        <b-button variant="link" class="shadow-none px-0" @click="form.places.push('')">
          Добавить место
        </b-button>

        <div class="mt-3">
          Дата проведения
        </div>
        <b-form-invalid-feedback :state="!isTouchedBtn || !!form.dates.length">
          Обязательно
        </b-form-invalid-feedback>
        <b-row v-for="(_, i) in form.dates" :key="i" no-gutters class="d-flex mt-2">
          <b-col col class="mr-1">
            <b-form-input
              v-model="form.dates[i].day"
              type="date"
              :class="{'is-invalid':!validationDateDay(i)}"
            />
            <b-form-invalid-feedback :state="validationDateDay(i)">
              Обязательно
            </b-form-invalid-feedback>
          </b-col>
          <b-col col>
            <b-form-input
              v-model="form.dates[i].time"
              type="time"
              :class="{'is-invalid':!validationDateTime(i)}"
            />
            <b-form-invalid-feedback :state="validationDateTime(i)">
              Обязательно
            </b-form-invalid-feedback>
          </b-col>
          <b-col cols="auto">
            <b-button variant="white" class="shadow-none px-1" @click="form.dates.splice(i,1)">
              <b-icon icon="x" />
            </b-button>
          </b-col>
        </b-row>
        <b-button variant="link" class="shadow-none px-0" @click="form.dates.push({time:null,day:null})">
          Добавить дату
        </b-button>

        <div class="mt-4 d-flex flex-column align-items-center">
          <b-button type="submit" class="w-50" variant="primary" :disabled="loading">
            Создать
          </b-button>
          <b-button class="w-50 text-secondary" variant="link" @click="cancel">
            Закрыть
          </b-button>
        </div>
      </b-form>
    </template>
  </b-modal>
</template>

<script>
export default {
  name: 'EventAddModal',

  data: () => ({
    form: {
      name: '',
      places: [],
      dates: []
    },
    isTouchedBtn: false,
    loading: false
  }),

  computed: {
    validationName () {
      return !this.isTouchedBtn || !!this.form.name
    },

    validationDate () {
      return !this.isTouchedBtn || !!this.form.name
    },

    validationDates () {
      let validate = !!this.form.dates.length
      this.form.dates.forEach((date, i) => {
        if (!this.validationDateDay(i) || !this.validationDateTime(i)) {
          validate = false
        }
      })
      return validate
    },

    validationPlaces () {
      let validate = !!this.form.places.length
      this.form.places.forEach((date, i) => {
        if (!this.validationPlace(i)) {
          validate = false
        }
      })
      return validate
    }
  },

  methods: {
    addEvent (e) {
      e.preventDefault()
      this.isTouchedBtn = true
      if (!this.validationName || !this.validationDates || !this.validationPlaces) {
        return
      }
      this.loading = true
      //
      this.$bvModal.hide('event-add-modal')
      this.loading = false
    },

    showModal () {
      this.isTouchedBtn = false
      this.form = {
        name: '',
        places: [],
        dates: []
      }
    },

    validationPlace (i) {
      return !this.isTouchedBtn || !!this.form.places[i]
    },

    validationDateDay (i) {
      return !this.isTouchedBtn || !!this.form.dates[i].day
    },

    validationDateTime (i) {
      return !this.isTouchedBtn || !!this.form.dates[i].time
    }
  }
}
</script>

<style scoped>

</style>
