let state = {}
let getters = {}
let mutations = {}
let actions = {}

state = () => ({
  isLoading: true,
  person: null,
  persons: []
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
  async getPerson (context, payload) {
    try {
      context.commit('setLoading', true)
      const { data } = await this.$axios.get()
      if (data.error_code === 0) {
        context.commit('setPerson', data.result)
      }
    } catch (e) {
      context.commit('setPerson', null)
    } finally {
      context.commit('setLoading', false)
    }
  },

  async getPersons (context, payload) {
    try {
      context.commit('setLoading', true)
      const { data } = await this.$axios.get()
      if (data.error_code === 0) {
        context.commit('setPersons', data.result)
      }
    } catch (e) {
      context.commit('setPersons', [])
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
