let state = {}
let getters = {}

state = () => ({
  reminders: [{
    name: 'Напарничество',
    path: '/pdfs/Naparnichestvo.pdf',
    photo: '/images/reminders/Screenshot_1.png'
  }, {
    name: 'Общежития',
    path: '/pdfs/Obschezhitia.pdf',
    photo: '/images/reminders/Screenshot_3.png'
  }, {
    name: 'Военка для девочек',
    path: '/pdfs/Voenka_dlya_devochek.pdf',
    photo: '/images/reminders/Screenshot_4.png'
  }, {
    name: 'Иностранцы',
    path: '/pdfs/Inostrantsy.pdf',
    photo: '/images/reminders/Screenshot_5.png'
  }, {
    name: 'Подразделения',
    path: '/pdfs/Podrazdelenia.pdf',
    photo: '/images/reminders/Screenshot_2.png'
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
