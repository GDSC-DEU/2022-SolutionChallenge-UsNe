<template>
  <div>
    <div>
      <h2>input test</h2>
      <form @submit.prevent='onSubmit'>
        <input type="text" v-model="date" placeholder="date">
        <input type="text" v-model="description" placeholder="Description">
        <input type="text" v-model="tag" placeholder="tag">
        <input type="text" v-model="inout" placeholder="in out">
        <input type="text" v-model="total" placeholder="total">
        <input type="button" @click="onSubmit" value="submit">
      </form>
    </div>
    <h2>usne</h2>
    <button id="new" @click.stop="onNew">New</button>
    <button id="delete">Delete</button>
    <table id="accountBook">
      <thead>
        <tr>
          <th>Date</th>
          <th>Description</th>
          <th>tag</th>
          <th>In/Out</th>
          <th>Total</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="list in lists" :key="list.key">
          <td>{{ list.date }}</td>
          <td>{{ list.description }}</td>
          <td>{{ list.tag.join(", ") }}</td>
          <td>{{ list.inout }}</td>
          <td>{{ list.total }}</td>
        </tr>
      </tbody>
    </table>
    <Modal 
      v-if = "showNewModal"
      @close="closeNewHodal"
    />
  </div>
</template>

<script>
import { ref } from "vue";
import Modal from "@/components/newModal.vue";
export default {
  components: {
    Modal
  },
  setup() {
    const showNewModal = ref(false);
    const onNew = () => {
      showNewModal.value = true;
    }
    const closeNewHodal = () => {
      showNewModal.value = false;
    }
    return {
      showNewModal,
      onNew,
      closeNewHodal,
    }
  },
  methods: {
   onSubmit() {
      this.lists.push({
        date: this.date,
        description: this.description,
        tag: [this.tag.split(",")],
        inout: this.inout,
        total: this.total,
      })
      this.date = ""
      this.description = ""
      this.tag = ""
      this.inout = ""
      this.total = ""
   }
  },
  data() {
    return {
      lists: [],
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