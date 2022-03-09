<template>
   <div>
      <h4>search</h4>
      <button @click="gofilter"> 검색결과출력</button>
    </div>
</template>

<script>
export default {
  data() {
    return {
      // searchText: '',
    }
  },
  methods: {
  //   computedConsumption() {
  //     if (this.searchText) {
  //       return console.log(this.searchText);
  //     }
  //   },
    gofilter() {
      this.$emit('filterCon', {
        useType: "FOOD",
        dwType: "WITHDRAW",
        payType: "CARD"
      })
    }

  },
}
</script>

<style>

</style>