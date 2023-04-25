import { getPersons } from '../../mokk/persons'
import { getPerson } from '../../mokk/person'

let state = {}
let getters = {}
let mutations = {}
let actions = {}

state = () => ({
  isLoading: true,
  person: null,
  persons: {
    count: 0,
    data: []
  }
})

getters = {
  isLoading: state => state.isLoading,
  person: state => state.person,
  persons: state => state.persons
}

mutations = {
  setLoading (state, payload) {
    state.isLoading = payload
  },
  setPerson (state, payload) {
    state.person = payload
  },
  setPersons (state, payload) {
    state.persons = payload
  }
}

actions = {
  getPerson (context, payload) {
    try {
      context.commit('setLoading', true)
      // const { data } = await this.$axios.get()
      // if (data.error_code === 0) {
      //   context.commit('setPerson', data.result)
      // }
      // context.commit('setPerson', data.result)
      const data = getPerson()
      context.commit('setPerson', data)
    } catch (e) {
      context.commit('setPerson', null)
    } finally {
      context.commit('setLoading', false)
    }
  },

  getPersons (context, payload) {
    try {
      // context.commit('setLoading', true)
      // const { data } = await this.$axios.get()
      // if (data.error_code === 0) {
      //   context.commit('setPersons', data.result)
      // }
      const data = getPersons()
      context.commit('setPersons', data)
    } catch (e) {
      context.commit('setPersons', { count: 0, data: [] })
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
