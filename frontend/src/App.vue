<template>
  <div>
    <h2>usne</h2>
    <button id="new" @click.stop="onNew">New</button>
    <button id="delete">Delete</button>
    <table id="accountBook">
      <thead>
        <tr>
          <th>Date</th>
          <th>Description</th>
          <th>tag</th>
          <th>Amount</th>
          <th>Total</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="list in lists" :key="list.key">
          <td>{{ list.date }}</td>
          <td>{{ list.description }}</td>
          <td>{{ list.tag?.join(", ") }}</td>
          <td>{{ list.amount }}</td>
          <td>{{ list.total }}</td>
        </tr>
      </tbody>
    </table>
    <Modal 
      v-if = "showNewModal"
      @close="closeNewModal"
      @insert="inputUpdate"
    />
  </div>
</template>

<script>
import Modal from "@/components/newModal.vue";
export default {
  components: {
    Modal
  },
  methods: {
    onNew() {
      this.showNewModal = true;
    },
    closeNewModal() {
      this.showNewModal = false;
    },
    inputUpdate(data) {
      this.lists.push({
        date: data.date,
        description: data.description,
        tag: data.tag?.split(","),
        amount: data.amount,
        // total: data.countTotal(inout, money) 함수실행
      })
      console.log(lists);
      this.date = ""
      this.description = ""
      this.tag = ""
      this.amount = ""
      this.total = ""
      this.closeNewModal()
    }
  },
  data() {
    return {
      showNewModal: false,
      lists: []
    };
  }
}
</script>

<style>
  * {
    font-family:serif; 
  }
  h2 {
    color: rgb(46, 46, 139);
  }
  #new, #delete {
    width: 55px;
    padding: 4px;
    margin: 5px;
    border-radius: 35px;
    border: none;
    color: white;
    position: relative;
    top: -5px;
    left: 68%;
    
  }
  #new {
    background-color: rgb(255, 160, 160);
  }
  #delete {
    background-color: rgb(100, 170, 235);
  }
  table {
    width: 55%;
    margin: auto;
    border-top: solid 2px black;
    border-collapse: collapse;
    text-align: center;
  }
  th, td {
    height: 20px;
    border-bottom: solid 1px black;
    border-left: solid 1px black;
    padding: 5px;
    font-size: 15px;
  }
  th:first-child, td:first-child {
    border-left: none;
  }
  th {
    border-bottom: solid 2px black;
  }
  input {
    margin: 10px;
  }
</style>