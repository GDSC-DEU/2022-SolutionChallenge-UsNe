<template>
  <div class="accountTable">
    <p style="letter-spacing: 14px;">FEBRUARY</p>
    <p style="text-decoration: underline; text-underline-position:under; font-size: 18px;">2022</p>
    <div class="searchButton">
      <!-- <button type="button">All</button>
      <button type="button">식비</button>
      <button type="button">교통비</button>
      <button type="button">생활비</button>
      <button type="button">문화활동</button>
      <button type="button">카드</button>
      <button type="button">현금</button>
      <button type="button">계좌이체</button>
      <button type="button">상품권</button>
      <button type="button">All</button>
      <button type="button">All</button> -->
    </div>
    <div class="tableButton">
      <div/>
      <button id="new" @click.stop="onNew">New</button>
      <button id="delete">Delete</button>
    </div>
    <table id="accountBook">
      <thead>
        <tr>
          <th class="th-1">Date</th>
          <th class="th-2">Description</th>
          <th class="th-3">tag</th>
          <th class="th-4">Amount</th>
          <th class="th-5">Total</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(list, index) in lists" :key="index">
          <td>{{ list.consumptionDatetime }}</td>
          <td>{{ list.content }}</td>
          <td>{{ list.dwType }}, {{ list.payType }}, {{ list.useType }}</td>
          <td>{{ list.cost }}</td>
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
import { consumptions } from "@/api/index";
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
    async inputUpdate(listData) {
      const userData = {
        consumptionDatetime: Number(listData.consumptionDatetime.replace(/-/g, "")),
        content: listData.content,
        useType: this.types.useType[listData.useType],
        payType: this.types.payType[listData.payType],
        dwType: this.types.dwType[listData.dwType],
        cost: listData.cost
      };
      
      console.log(userData)
      const { data } = await consumptions(userData);
      console.log(data);
      this.lists.push({
        consumptionDatetime: listData.consumptionDatetime,
        content: listData.content,
        useType: listData.useType,
        payType: listData.payType,
        dwType: listData.dwType,
        cost: listData.cost,
        total: this.countTotal(listData.cost, listData.dwType)
      })
      console.log(this.lists);
      this.consumptionDatetime = ""
      this.content = ""
      this.useType = ""
      this.payType = ""
      this.dwType = ""
      this.cost = ""
      this.total = ""

      this.closeNewModal()
    },
    countTotal(cost, dwType) {
      let newAmount = 0;
      if(dwType === "지출") {
        newAmount = -cost;
      } else if(dwType === "수입") {
        newAmount = cost;
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
      lastTotal: 0,
      types: {
        useType: {
          "뷰티": "BEAUTY",
          "의류비": "CLOTHES",
          "문화활동": "CULTURE",
          "교육비": "EDUCATION",
          "기타": "ETC",
          "식비": "FOOD",
          "생활비": "LIFE",
          "병원비": "MEDICALTREATMENT",
          "교통비": "TRAFFIC",
        },
        payType: {
          "계좌이체": "ACCOUNTTRANSFER",
          "카드": "CARD",
          "현금": "CASH",
          "기프트카드": "GIRTCARD", 
        },
        dwType: {
          "지출": "WITHDRAW",
          "수입": "DEPOSIT",
        },
      }
    };
  }
}
</script>

<style scoped>
  .searchButton {
    text-align: center;
  }
  p {
    text-align: center;
    font-family: 'pinokio';
    font-size: 20px;
    /* font-family:'Times New Roman', Times, serif; */
  }
  .accountTable {
    margin-bottom: 147px;
  }
  .tableButton {
    display: grid;
    grid-template-columns: 66% 60px 60px ;
    grid-gap: 6px;
    margin-bottom: 5px;
  }
 .th-1 {
    width: 16%
  }
  .th-2 {
    width: 45%;
  }
  .th-3 {
    width: 19%;
  }
  .th-4, .th-5 {
    width: 10%;
  }
  button {
    width: 55px;
    padding: 4px;
    margin: 5px;
    border-radius: 35px;
    border: none;
    color: white;
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
</style>