import { getPerson, getPersonAdmin } from '../../mokk/person'

let state = {}
let getters = {}
let mutations = {}
let actions = {}

state = () => ({
  isLoading: true,
  user: null
})

getters = {
  isLoading: state => state.isLoading,
  isAdmin: state => state.user?.admin,
  user: state => state.user
}

mutations = {
  setLoading (state, payload) {
    state.isLoading = payload
  },
  setUser (state, payload) {
    state.user = payload
  }
}

actions = {
  login (context, payload) {
    try {
      context.commit('setLoading', true)
      let data = null
      if (payload.email === 'admin') {
        data = getPersonAdmin()
      } else {
        data = getPerson()
      }
      context.commit('setUser', data)
    } catch (e) {
      context.commit('setUser', null)
    } finally {
      context.commit('setLoading', false)
    }
  },

  logout (context) {
    context.commit('setUser', null)
  }
}

export default {
  namespaced: true,
  state,
  getters,
  mutations,
  actions
}
