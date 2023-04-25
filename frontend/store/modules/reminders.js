let state = {}
let getters = {}

state = () => ({
  reminders: [{
    name: 'Электронные сервисы',
    path: '/pdfs/Services.pdf',
    photo: '/images/reminders/сервисы.png'
  }, {
    name: 'Стипендии',
    path: '/pdfs/Stipend.pdf',
    photo: '/images/reminders/стипендии.png'
  }, {
    name: 'Учебный процесс',
    path: '/pdfs/Study_process.pdf',
    photo: '/images/reminders/учебный.png'
  }, {
    name: 'Переводы',
    path: '/pdfs/Transfers.pdf',
    photo: '/images/reminders/переводы.png'
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
