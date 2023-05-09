<template>
  <b-overlay :show="isLoading">
    <b-row>
      <b-col cols="12" lg="5">
        <div class="h5 my-3">
          События {{ $dayjs(date).format('DD.MM.YY') }}
        </div>
        <template v-if="eventsByDate.length>0">
          <div v-for="(event, i) in eventsByDate.slice(0,1)" :key="i">
            <event-card :event="event" class="mb-2" />
          </div>
          <div class="d-flex justify-content-center mb-2">
            <b-button
              v-if="eventsByDate.length>1"
              v-b-modal.events-by-date
              variant="link"
              class="shadow-none"
            >
              Смотреть все
            </b-button>
          </div>
        </template>
        <template v-else>
          <div class="d-flex justify-content-center">
            <img src="/images/404.svg" height="150" alt="404">
          </div>
          <div class="text-center my-2">
            Событий в этот день нет
          </div>
        </template>
      </b-col>
      <b-col cols="12" lg="7">
        <b-row align-v="center" no-gutters class="border rounded p-3">
          <b-button variant="white" class="shadow-none d-none d-lg-flex" @click="changeMonth(-1)">
            <b-icon icon="chevron-left" />
          </b-button>
          <b-col>
            <div class="text-center h5 mb-3 d-none d-lg-block">
              Календарь событий, {{ $dayjs(date).format('MMMM YYYY') }}
            </div>
            <div class="d-lg-none">
              <div class="text-center h5 mb-3">
                Календарь событий
              </div>
              <div class="d-flex align-items-center justify-content-center">
                <b-button variant="white" size="sm" class="shadow-none" @click="changeMonth(-1)">
                  <b-icon icon="chevron-left" />
                </b-button>
                {{ $dayjs(date).format('MMMM YYYY') }}
                <b-button variant="white" size="sm" class="shadow-none" @click="changeMonth(1)">
                  <b-icon icon="chevron-right" />
                </b-button>
              </div>
            </div>
            <b-calendar
              v-model="date"
              :hide-header="true"
              block
              locale="ru"
              :date-info-fn="dateInfo"
            />
          </b-col>
          <b-button variant="white" class="shadow-none d-none d-lg-flex" @click="changeMonth(1)">
            <b-icon icon="chevron-right" />
          </b-button>
        </b-row>
      </b-col>
    </b-row>
    <div class="h3 my-3">
      Все события
    </div>
    <b-row>
      <b-col v-for="(event, i) in events" :key="i" cols="12" lg="6" class="mb-3">
        <event-card :event="event" />
      </b-col>
    </b-row>
    <events-by-date-modal :events="eventsByDate" />
    <template v-for="(event, i) in events">
      <EventModal :key="i" :event="event" />
    </template>
  </b-overlay>
</template>

<script>
import { mapGetters } from 'vuex'
import EventCard from '../components/events/EventCard'
import EventModal from '../components/events/EventModal'
import EventsByDateModal from '../components/events/EventsByDateModal'

export default {
  name: 'EventsPage',

  components: { EventModal, EventCard, EventsByDateModal },

  data () {
    return {
      date: this.$dayjs().format()
    }
  },

  computed: {
    ...mapGetters('modules/events', ['isLoading', 'events', 'eventsByDates']),
    datesEvent () {
      return Object.keys(this.eventsByDates).map(eventDate => this.$dayjs(eventDate).format('DD.MM.YYYY'))
    },
    eventsByDate () {
      return this.eventsByDates[this.$dayjs(this.date).format('YYYY-MM-DD')] || []
    }
  },

  mounted () {
    this.$store.dispatch('modules/events/getEvents')
    this.$store.dispatch('modules/events/getEventsByDates')
  },

  methods: {
    changeMonth (val) {
      this.date = this.$dayjs(this.date).add(val, 'month').format()
    },

    dateInfo (ymd, date) {
      if (this.datesEvent.includes(this.$dayjs(date).format('DD.MM.YYYY'))) { return 'date-info' }
      return ''
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

.date-info:after{
  content:'';
  display: block;
  background: var(--primary);
  width: 7px;
  height: 7px;
  position: absolute;
  top:0;
  right:0;
  border-radius: 50%;
}
</style>
