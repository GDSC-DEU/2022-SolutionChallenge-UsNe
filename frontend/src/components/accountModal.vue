<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width"> 
    <link href="style.css" rel="stylesheet" type="text/css" />
    <title>Acount Book</title>
    <div class="myGoal">
      <h1>My Goal</h1> 
      </head>
  <style>
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
      top: 50%;
      left: 50%;

      width: 600px;
      height: 500px;

      padding: 40px;

      text-align: center;

      background-color: rgb(255, 255, 255);
      border-radius: 10px;
      box-shadow: 0 2px 3px 0 rgba(34, 36, 38, 0.15);
      transform: translateX(-50%) translateY(-50%);
      }
    
    </style>

  <body style="overflow: hidden;">
    <div class="modal show">
      <div class="modal_body"><h2>Goal</h2>한 달 예산 <p>
      <input> 원</input> </p> <br> 
     <p>식비 <input>
        문화 <input></p> <br>
     <p>생활 <input>
        의류 <input></p> <br>
     <p>쇼핑 <input> 
        미용 <input></p> <br>
     <p>금융 <input>   
        의료 <input></p> 
     <p><button class="input">Input </button>
     <button class="cancel">Cancel </button>       
      </div> 
    </div>
    <p> <button class="btn-open-popup">Goal Setting</button> </p> <br></br>
    <div class="goalBar"> 
     <p>#식비  
        #문화 </p> <br><br>
     <p>#생활 
        #의류 </p> <br><br>
     <p>#쇼핑  
        #미용 </p> <br><br>
     <p>#금융    
        #의료 </p> 
    </div>
      
    <script src="script.js"></script>
    <script>
      const body = document.querySelector('body')
      const modal = document.querySelector('.modal');
      const btnOpenPopup = document.querySelector('.btn-open-popup');

      btnOpenPopup.addEventListener('click', () => {
        modal.classList.toggle('show');

        if (modal.classList.contains('show')) {
          body.style.overflow = 'hidden';
        }
      });

      modal.addEventListener('click', (event) => {
        if (event.target === modal) {
          modal.classList.toggle('show');

          if (!modal.classList.contains('show')) {
            body.style.overflow = 'auto';
          }
        }
      });
    </script> 
 </body>
</html>