<body class="bg-dark">







  <div class="container">
    <div class="card card-login mx-auto mt-5">
      <div class="card-header">Login</div>
      <div class="card-body">
       
          <form action='<?= base_url() ?>login' method='post' accept-charset='UTF-8' role="form">

              <div class='form-group'>
                 <input class='form-control large' style='text-align: center;' type='text' name='email' placeholder='usuario'/>
              </div>

              <div class='form-group'>
                 <input class='form-control large' style='text-align: center;' type='password' name='password' placeholder='contraseña' />
              </div>

              <div class='form-group'>
                 <button class='btn btn-primary' style='width: 100%;' type='submit'>INGRESAR</button>
              </div>

          </form>   
              
      </div>
    </div>
  </div>