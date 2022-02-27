<template>
  <div>
    <AccountTable />
   <body style="overflow: hidden;">
    <div class="modalShow">
     <h1>My Goal</h1>
     <button class="btnPopup"> Goal Setting </button> 
     <p>#식비 #문화 </p> <br>
     <p>#생활 #의류 </p> <br>
     <p>#쇼핑 #미용 </p> <br>
     <p>#금융 #의료 </p> 
    </div>
 </body>
  </div>
</template>

<script>
import AccountTable from "@/components/AccountTable.vue";
export default {
  components: {
    AccountTable
  }
}
</script>

<style scoped>

</style>