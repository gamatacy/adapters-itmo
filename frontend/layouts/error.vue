<template>
  <div class="error-container py-4">
    <div class="h-100 rounded bg-white d-flex align-items-center justify-content-center flex-column">
      <div>
        <img src="/images/illustration%20_seo%20settings%20display%20computer%20screen_.svg" height="175" alt="404">
      </div>
      <div class="mt-4 mb-3">
        Упс... Кажется, здесь ничего нет!<br>
        Скоро мы добавим этот раздел
      </div>
      <b-button variant="primary" @click="$router.go(-1)">
        Назад
      </b-button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'ErrorLayout'
}
</script>

<style scoped>
.error-container{
  height: calc(100% - 60px);
}
</style>
