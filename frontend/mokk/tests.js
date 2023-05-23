export const getTests = () => ([
  {
    name: 'Электронные сервисы',
    id: 1,
    photo: '/adapters/images/reminders/сервисы.png',
    points: null
  },
  {
    name: 'Стипендии',
    id: 2,
    photo: '/adapters/images/reminders/стипендии.png',
    points: 80
  },
  {
    name: 'Учебный процесс',
    id: 3,
    photo: '/adapters/images/reminders/учебный.png',
    points: null
  },
  {
    name: 'Переводы',
    id: 4,
    photo: '/adapters/images/reminders/переводы.png',
    points: null
  }
])

export const getTest = () => ({
  id: 1,
  name: 'Электронные сервисы',
  questions: [
    {
      id: 1,
      text: 'Где НЕЛЬЗЯ найти номер своего потока?',
      variants: [
        { text: 'учебный план в ИСУ', value: 1 },
        { text: 'персональное расписание в ИСУ', value: 2 },
        { text: 'расписание в my itmo', value: 3 },
        { text: 'электронный журнал в БаРС', value: 4 }
      ]
    },
    {
      id: 2,
      text: 'Где сейчас проходит выборность предметов?',
      variants: [
        { text: 'ЦДО', value: 1 },
        { text: 'ИСУ', value: 2 },
        { text: 'БаРС', value: 3 },
        { text: 'my itmo', value: 4 }
      ]
    },
    {
      id: 3,
      text: 'Где МОЖНО записаться на занятия по физкультуре? ',
      variants: [
        { text: 'приложение my itmo', value: 1 },
        { text: 'сайт my itmo', value: 2 },
        { text: 'группа ВКонтакте «Кронверкские барсы»', value: 3 },
        { text: 'ИСУ', value: 4 }
      ]
    },
    {
      id: 4,
      text: 'Где можно посмотреть дни рождения своих одногруппников?',
      variants: [
        { text: 'персоналии в ИСУ', value: 1 },
        { text: 'персоналии в my itmo', value: 2 },
        { text: 'коллеги в Представленность и коммуникации', value: 3 },
        { text: 'заявки на my itmo', value: 4 }
      ]
    },
    {
      id: 5,
      text: 'Чего НЕЛЬЗЯ сделать в my itmo?',
      variants: [
        { text: 'посмотреть расписание', value: 1 },
        { text: 'забронировать аудиторию', value: 2 },
        { text: 'подать заявку', value: 3 },
        { text: 'посмотреть зачетку', value: 4 }
      ]
    },
    {
      id: 6,
      text: 'Какое устройство НЕЛЬЗЯ забронировать с помощью ITMO.SHARE?',
      variants: [
        { text: 'колонки', value: 1 },
        { text: 'разветвитель USB', value: 2 },
        { text: 'гарнитуру', value: 3 },
        { text: 'павербанк', value: 4 }
      ]
    },
    {
      id: 7,
      text: 'Какое устройство МОЖНО забронировать с помощью ITMO.SHARE?',
      variants: [
        { text: 'портативный жесткий диск', value: 1 },
        { text: 'мышь', value: 2 },
        { text: 'математический калькулятор', value: 3 },
        { text: 'браслет фитнес-трекер', value: 4 }
      ]
    },
    {
      id: 8,
      text: 'В каком из этих коворкингов НЕЛЬЗЯ забронировать помещение в ИСУ?',
      variants: [
        { text: 'коворкинг на Биржевой', value: 1 },
        { text: 'коворкинг в Студенческом офисе', value: 2 },
        { text: 'коворкинг KRONBARS Space', value: 3 },
        { text: 'центр управления полетами (ректорский холл)', value: 4 }
      ]
    },
    {
      id: 9,
      text: 'Где МОЖНО найти номер своего потока?',
      variants: [
        { text: 'учебный план в ИСУ', value: 1 },
        { text: 'персональное расписание в ИСУ', value: 2 },
        { text: 'расписание в my itmo', value: 3 },
        { text: 'электронный журнал в БаРС', value: 4 }
      ]
    },
    {
      id: 10,
      text: 'Где МОЖНО найти контрольные точки по определенной дисциплине?',
      variants: [
        { text: 'зачетная книжка в ИСУ', value: 1 },
        { text: 'зачетная книжка в my itmo', value: 2 },
        { text: 'электронный журнал в БаРС', value: 3 },
        { text: 'электронный журнал в ЦДО', value: 4 }
      ]
    },
    {
      id: 11,
      text: 'Где НЕЛЬЗЯ найти контрольные точки по определенной дисциплине?',
      variants: [
        { text: 'зачетная книжка в ИСУ', value: 1 },
        { text: 'зачетная книжка в my itmo', value: 2 },
        { text: 'электронный журнал в БаРС', value: 3 },
        { text: 'лектронный журнал в ЦДО', value: 4 }
      ]
    },
    {
      id: 12,
      text: 'Где МОЖНО подать заявку в студофис?',
      variants: [
        { text: 'приложение my itmo', value: 1 },
        { text: 'сайт my itmo', value: 2 },
        { text: 'ИСУ', value: 3 },
        { text: 'ITMO STUDENTS', value: 4 }
      ]
    },
    {
      id: 13,
      text: 'Где МОЖНО посмотреть, в каких мероприятиях вы принимали участие?',
      variants: [
        { text: 'ИСУ', value: 1 },
        { text: 'приложение my itmo', value: 2 },
        { text: 'сайт my itmo', value: 3 },
        { text: 'ITMO STUDENTS', value: 4 }
      ]
    }
  ]
})
