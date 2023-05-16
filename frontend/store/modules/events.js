import { getEvents, getEventsForAdmin } from '../../mokk/events'
import { getEventsByDates, getEventsByDatesAdmin } from '../../mokk/eventsByDates'

let state = {}
let getters = {}
let mutations = {}
let actions = {}

state = () => ({
  isLoading: true,
  events: [],
  eventsByDates: {}
})

getters = {
  isLoading: state => state.isLoading,
  events: state => state.events,
  eventsByDates: state => state.eventsByDates
}

mutations = {
  setLoading (state, payload) {
    state.isLoading = payload
  },
  setEvents (state, payload) {
    state.events = payload
  },
  setEventsByDates (state, payload) {
    state.eventsByDates = payload
  }
}

actions = {
  getEvents (context) {
    try {
      context.commit('setLoading', true)
      // const { data } = await this.$axios.get()
      // if (data.error_code === 0) {
      //   context.commit('setEvents', data.result)
      // }
      let data = null
      if (context.rootGetters['modules/user/isAdmin']) {
        data = getEventsForAdmin()
      } else {
        data = getEvents()
      }
      context.commit('setEvents', data)
    } catch (e) {
      context.commit('setEvents', [])
    } finally {
      context.commit('setLoading', false)
    }
  },

  getEventsByDates (context) {
    try {
      context.commit('setLoading', true)
      // const { data } = await this.$axios.get()
      // if (data.error_code === 0) {
      //   context.commit('setEvents', data.result)
      // }
      let data = null
      if (context.rootGetters['modules/user/isAdmin']) {
        data = getEventsByDatesAdmin()
      } else {
        data = getEventsByDates()
      }
      context.commit('setEventsByDates', data)
    } catch (e) {
      context.commit('setEventsByDates', [])
    } finally {
      context.commit('setLoading', false)
    }
  }
}

export default {
  namespaced: true,
  state,
  getters,
  mutations,
  actions
}
