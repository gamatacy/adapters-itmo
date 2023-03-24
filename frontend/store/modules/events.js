let state = {}
let getters = {}
let mutations = {}
let actions = {}

state = () => ({
  isLoading: true,
  events: []
})

getters = {
  isLoading: state => state.isLoading,
  events: state => state.events
}

mutations = {
  setLoading (state, payload) {
    state.isLoading = payload
  },
  setEvents (state, payload) {
    state.events = payload
  }
}

actions = {
  async getEvents (context) {
    try {
      context.commit('setLoading', true)
      const { data } = await this.$axios.get()
      if (data.error_code === 0) {
        context.commit('setEvents', data.result)
      }
    } catch (e) {
      context.commit('setEvents', [])
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
