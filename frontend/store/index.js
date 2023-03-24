import Vue from 'vue'
import Vuex from 'vuex'
import application from './modules/application'
import persons from './modules/persons'
import events from './modules/events'
import reminders from './modules/reminders'
import tests from './modules/tests'
import user from './modules/user'

Vue.use(Vuex)

export const store = new Vuex.Store({
  namespaced: true,
  state: {},
  getters: {},
  mutations: {},
  actions: {},
  modules: {
    application,
    persons,
    events,
    tests,
    reminders,
    user
  }
})
