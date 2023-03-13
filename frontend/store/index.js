import Vue from 'vue'
import Vuex from 'vuex'
import application from './modules/application'

Vue.use(Vuex)

export const store = new Vuex.Store({
  namespaced: true,
  state: {},
  getters: {},
  mutations: {},
  actions: {},
  modules: {
    application
  }
})
