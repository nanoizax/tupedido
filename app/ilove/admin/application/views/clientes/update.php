<div class="container" style="margin-top: 5%; margin-bottom: 4%; margin-left: 15%">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">

            <h1>Actualziar Registro</h1>



        	<?php
        		
        		echo form_open("usuario/updateCliente/$id");

                ?>

                <div class="form-group">
                    <label for="exampleInputEmail1">Nombre</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Nombre" name="nombre" value="<?= $nombre ?>">
                 </div>

                <p></p>

                <div class="form-group">
                    <label for="exampleInputEmail1">Telefono</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Telefono" name="sexo" value="<?= $sexo ?>">
                 </div>

                <p></p>

                <div class="form-group">
                    <label for="exampleInputEmail1">Email address</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" name = "email" value="<?= $email ?>">
                 </div>

                <p></p>

                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name = "password" value="<?= $password ?>">
                </div>

                <p></p>

                <?php
        	
                echo form_submit('Actualizar');

        		echo form_close();
        	?>
          
        </div>
      </div>
    </div>

    <hr>