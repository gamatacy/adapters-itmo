let state = {}
let getters = {}

state = () => ({
  reminders: [{
    name: 'Электронные сервисы',
    path: '/adapters/pdfs/Services.pdf',
    photo: '/adapters/images/reminders/сервисы.png'
  }, {
    name: 'Стипендии',
    path: '/adapters/pdfs/Stipend.pdf',
    photo: '/adapters/images/reminders/стипендии.png'
  }, {
    name: 'Учебный процесс',
    path: '/adapters/pdfs/Study_process.pdf',
    photo: '/adapters/images/reminders/учебный.png'
  }, {
    name: 'Переводы',
    path: '/adapters/pdfs/Transfers.pdf',
    photo: '/adapters/images/reminders/переводы.png'
  }]
})

getters = {
  reminders: state => state.reminders
}

export default {
  namespaced: true,
  state,
  getters
}
