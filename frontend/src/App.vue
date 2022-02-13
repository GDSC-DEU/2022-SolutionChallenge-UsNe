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
    <button id="new">New</button>
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
        <tr>
          <td>02.01</td>
          <td>고기만두, 김치만두</td>
          <td>#식비 #카드</td>
          <td>-7,000</td>
          <td>10,000</td>
        </tr>
        <tr>
          <td>-</td>
          <td>-</td>
          <td>-</td>
          <td>-</td>
          <td>-</td>
        </tr>
        <!-- <tr v-for="list in lists" :key="list.id">
          <td>{{ list.date }}</td>
          <td>{{ list.description }}</td>
          <td>{{ list.tag }}</td>
          <td>{{ list.inout }}</td>
          <td>{{ list.total }}</td>
        </tr> -->
      </tbody>
    </table>
  </div>
</template>

<script>
import { ref } from 'vue';
export default {
  setup() {
    const list = ref({
      date: '1',
      description: '...?',
      tag: '????????',
      inout: '1',
      total: 'v'
    });
    const lists = ref([]);
    const date = ref('');
    const description = ref('');
    const tag = ref('');
    const inout = ref('');
    const total = ref('');

    const onSubmit = () => {
      console.log(lists.value)
      lists.value.push({
        id: Date.now(),
        subject: {
          date: date.value, 
          description: description.value, 
          tag: tag.value, 
          inout: inout.value, 
          total: total.value},
      });
      const table = document.getElementById('accountBook');
      const newRow = table.insertRow();
      const newDate = newRow.insertCell(0);
      const newDescription = newRow.insertCell(1);
      const newTag = newRow.insertCell(2);
      const newInout = newRow.insertCell(3);
      const newTotal = newRow.insertCell(4);
      
      newDate.innerText = date.value;
      newDescription.innerText = description.value;
      newTag.innerText = tag.value; 
      newInout.innerText = inout.value;
      newTotal.innerText = total.value;

      date.value = "";
      description.value = "";
      tag.value = "";
      inout.value = "";
      total.value = "";
    }

    return {
      onSubmit,
      list,
      date,
      description,
      tag,
      inout,
      total,
    }
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