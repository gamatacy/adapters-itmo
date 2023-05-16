<template>
  <b-modal :id="'event-admin-'+event.id" hide-footer hide-header body-class="py-4" @show="showModal">
    <template #default="{cancel}">
      <div class="text-center px-3 h4 mb-4">
        Отметить посещение
      </div>
      <div class="px-5">
        <div class="font-weight-bold mb-2">
          Записанные
        </div>
        <div v-if="form.signed.length===0">
          Еще никто не записался
        </div>
        <b-form-group v-slot="{ ariaDescribedby }">
          <b-form-checkbox
            v-for="(person,i) in form.signed"
            :key="i"
            v-model="form.signed[i].visited"
            :aria-describedby="ariaDescribedby"
            :value="1"
            :unchecked-value="0"
          >
            {{ person.name }} [{{ person.isuNumber }}]
          </b-form-checkbox>
        </b-form-group>
      </div>
      <div class="mt-4 d-flex flex-column align-items-center">
        <b-button class="w-50" variant="primary" @click="submitForm">
          Сохранить
        </b-button>
        <b-button class="w-50 text-secondary" variant="link" @click="cancel">
          Закрыть
        </b-button>
      </div>
    </template>
  </b-modal>
</template>

<script>
export default {
  name: 'EventModalAdmin',

  props: {
    event: {
      type: Object,
      default: () => ({})
    }
  },

  data: () => ({
    form: {
      signed: []
    }
  }),

  methods: {
    submitForm () {
      this.$bvModal.hide('event-admin-' + this.event.id)
    },

    showModal () {
      this.form.signed = structuredClone(this.event.signed)
    }
  }
}
</script>

<style scoped>

</style>
