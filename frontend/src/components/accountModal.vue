<template>
    <div class="modalBody">
        <h1>Goal</h1>
       <p>한 달 예산</p> 
       <p><input> 원 </p> <br>
       <p>식비 <input> 문화 <input></p> <br>
       <p>생활 <input> 의류 <input></p> <br>
       <p>쇼핑 <input> 미용 <input></p> <br>
       <p>금융 <input> 의료 <input></p> 
       <div class="input"><button>Input</button> </div>
       <div class="cancel"><button>Cancel</button> </div>       
     </div> 
</template> 

<script>
import { defineComponent } from '@vue/composition-api'

export default defineComponent({
    setup() {
     const body = document.querySelector('body')
     const modal = document.querySelector('.modal');
     const btnOpenPopup = document.querySelector('.btnPopup');

     btnOpenPopup.addEventListener('click', () => {
     modal.classList.toggle('show');

     if (modal.classList.contains('show')) {
     body.style.overflow = 'hidden';
        }
      });
    },
})

 modal.addEventListener('click', (event) => {
        if (event.target === modal) {
          modal.classList.toggle('show');

          if (!modal.classList.contains('show')) {
            body.style.overflow = 'auto';
          }
        }
      });
</script>

<style scoped>
.modalBody {
    position: absolute;
    text-align: center; 
    top: 50%;
    left: 50%;
    width: 600px;
    height: 500px;
    padding: 40px;
    background-color: rgb(255, 255, 255);
    border-radius: 10px;
    box-shadow: 0 2px 3px 0 rgba(34, 36, 38, 0.15);
    transform: translateX(-50%) translateY(-50%);
}
 
.myGoal {
       text-align: center;
}
      
.modal {
       position: absolute;
      top: 0;
      left: 0;
      width: 100%;
      height: 100%;
      display: none;
      background-color: rgba(0, 0, 0, 0.4);
}

.modal.show {
      display: block;
}

.modal_body {
      position: absolute;
      text-align: center; 
      top: 50%;
      left: 50%;
      width: 600px;
      height: 500px;
      padding: 40px;
      background-color: rgb(255, 255, 255);
      border-radius: 10px;
      box-shadow: 0 2px 3px 0 rgba(34, 36, 38, 0.15);
      transform: translateX(-50%) translateY(-50%);
}

</style>