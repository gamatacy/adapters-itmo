<template>
  <div>
    <div class="h2 text-primary">
      Памятки
    </div>
    <b-button class="btn-back" variant="white" @click="$router.go(-1)">
      <b-icon icon="arrow-left" class="mr-2" />Назад
    </b-button>

    <b-row class="mt-3">
      <b-col
        v-for="(reminder,i) in reminders"
        :key="i"
        cols="12"
        md="6"
        lg="4"
        class="mb-3"
      >
        <b-card>
          <img :src="reminder.photo" width="100%" class="rounded" :alt="reminder.photo">
          <div class="font-weight-semibold text-center mt-2">
            {{ reminder.name }}
          </div>
          <b-button v-b-modal="'reminder'+i" class="mt-2 w-100" variant="primary">
            Изучить
          </b-button>
          <b-modal :id="'reminder'+i" size="lg" hide-footer :title="reminder.name">
            <iframe :src="reminder.path" />
          </b-modal>
        </b-card>
      </b-col>
    </b-row>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  name: 'RemindersPage',
  computed: {
    ...mapGetters('modules/reminders', ['reminders'])
  }
}
</script>

<style>
iframe{
  width:100%;
  border:none;
  height: calc(100vh - 160px);
}
</style>
