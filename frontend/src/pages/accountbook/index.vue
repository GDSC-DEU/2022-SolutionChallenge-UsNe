<template>
  <div>
    <AccountTable />
    <GoalTable />
  </div>
</template>

<script>
import AccountTable from "@/components/AccountTable.vue";
import GoalTable from "@/components/GoalTable.vue";
export default {
  components: {
    AccountTable,
    GoalTable
  }
}
</script>

<style scoped>

</style>