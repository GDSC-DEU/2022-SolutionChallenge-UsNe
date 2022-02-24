<template>
  <div>
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
        <tr v-for="(list, index) in lists" :key="index">
          <td>{{ list.date }}</td>
          <td>{{ list.description }}</td>
          <td>{{ Object.values(list.tag)?.join(",") }}</td>
          <td>{{ list.amount }}</td>
          <td>{{ list.total }}</td>
        </tr> 
      </tbody>
    </table>
    
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
      console.log(data.tag.inoutTag);
      console.log(data)
      this.lists.push({
        date: data.date,
        description: data.description,
        tag: {
          useTag: data.tag.useTag,
          toolTag: data.tag.toolTag,
          inoutTag: data.tag.inoutTag
        },
        amount: data.amount,
        total: this.countTotal(data.amount, data.tag.inoutTag)
      })
      console.log(this.lists);
      this.date = ""
      this.description = ""
      this.tag = []
      this.amount = ""
      this.total = ""
      this.closeNewModal()
    },
    countTotal(amount, inoutTag) {
      let newAmount = 0;
      if(inoutTag === "지출") {
        newAmount = -amount;
      } else if(inoutTag === "수입") {
        newAmount = amount;
      }

      if (this.lists.length === 0) {
        return newAmount;
      } else {
        return this.lists[this.lists.length - 1].total + newAmount;
      }      
    }
  },
  data() {
    return {
      showNewModal: false,
      lists: [],
      lastTotal: 0
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
    left: 65%;
  }
  #new {
    background-color: rgb(255, 160, 160);
  }
  #new:hover {
    background-color: rgb(241, 91, 91);
  }
  #delete {
    background-color: rgb(100, 170, 235);
  }
  #delete:hover {
    background-color: rgb(50, 134, 212);
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