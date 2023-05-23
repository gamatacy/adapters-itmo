import { getTest, getTests } from '../../mokk/tests'

let state = {}
let getters = {}
let mutations = {}
let actions = {}

state = () => ({
  isLoading: true,
  test: null,
  tests: []
})

getters = {
  isLoading: state => state.isLoading,
  test: state => state.test,
  tests: state => state.tests
}

mutations = {
  setLoading (state, payload) {
    state.isLoading = payload
  },
  setTest (state, payload) {
    state.test = payload
  },
  setTests (state, payload) {
    state.tests = payload
  }
}

actions = {
  getTest (context, payload) {
    try {
      context.commit('setLoading', true)
      // const { data } = await this.$axios.get()
      // if (data.error_code === 0) {
      //   context.commit('setTest', data.result)
      // }
      const data = getTest()
      context.commit('setTest', data)
    } catch (e) {
      context.commit('setTest', null)
    } finally {
      context.commit('setLoading', false)
    }
  },

  getTests (context) {
    try {
      context.commit('setLoading', true)
      // const { data } = await this.$axios.get()
      // if (data.error_code === 0) {
      //   context.commit('setTests', data.result)
      // }
      const data = getTests()
      context.commit('setTests', data)
    } catch (e) {
      context.commit('setTests', [])
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
