let state = {}
let getters = {}

state = () => ({
  reminders: null
})

getters = {
  reminders: state => state.reminders
}

export default {
  namespaced: true,
  state,
  getters
}
