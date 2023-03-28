<template>
  <div>
    <b-row>
      <b-col cols="12" lg="5">
        {{ value }}
      </b-col>
      <b-col cols="12" lg="7">
        <b-row align-v="center" class="border rounded p-3">
          <b-button variant="white" class="shadow-none" @click="changeMonth(-1)">
            <b-icon icon="chevron-left" />
          </b-button>
          <b-col>
            <div class="text-center h5 mb-3">
              Календарь событий, {{ value }}
            </div>
            <b-calendar
              v-model="value"
              :hide-header="true"
              block
              locale="ru"
            />
          </b-col>
          <b-button variant="white" class="shadow-none" @click="changeMonth(1)">
            <b-icon icon="chevron-right" />
          </b-button>
        </b-row>
      </b-col>
    </b-row>
  </div>
</template>

<script>
export default {
  name: 'EventsPage',
  data: () => ({
    value: new Date()
  }),
  methods: {
    changeMonth (val) {
      const date = new Date(this.value)
      this.value = new Date(date.setMonth(date.getMonth() + val))
    }
  }
}
</script>

<style>
.b-calendar-grid {
  border: 0;
  box-shadow: none !important;
}

.b-calendar-nav, .b-calendar-grid-help, .b-calendar-grid-caption  {
  display: none !important;
}

.b-calendar-grid-weekdays {
  border-bottom: 0 !important;
  text-transform: capitalize;
}
</style>
