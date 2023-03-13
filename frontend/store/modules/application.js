let state = {}
let getters = {}

state = () => ({
  nav: [{
    type: 1,
    name: 'Люди',
    items: [{
      name: 'Участники',
      link: '/persons/members'
    }, {
      name: 'Организаторы',
      link: '/persons/organizers'
    }]
  }, {
    type: 1,
    name: 'Материалы',
    items: [{
      name: 'Памятки',
      link: '/materials/reminders'
    }, {
      name: 'Тесты',
      link: '/materials/tests'
    }]
  }, {
    type: 0,
    name: 'Актуальное',
    link: '/events'
  }, {
    type: 0,
    name: 'Профиль',
    link: '/profile'
  }]
})

getters = {
  nav: state => state.nav
}

export default {
  namespaced: true,
  state,
  getters
}
