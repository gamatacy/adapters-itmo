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
  async login (context) {
  },
  async logout (context) {
  },
  async changeUser (context) {
  }
}

export default {
  namespaced: true,
  state,
  getters,
  mutations,
  actions
}
