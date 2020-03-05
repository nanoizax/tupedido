<div class="container" style="margin-top: 5%; margin-bottom: 4%; margin-left: 15%">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto col-lg-offset-2 col-md-offset-1">

            <h1>Actualizar producto.</h1>

        	<?php
        		
        		echo form_open_multipart("usuario/updateProducto/$id");

                ?>

                <div class="form-group">
                    <label for="exampleInputEmail1">Nombre</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Direccion" name="nombre" value="<?= $nombre ?>">
                 </div>

                <p></p>

                <div class="form-group">
                    <label for="exampleInputEmail1">Latitud</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Direccion" name="latitud" value="<?= $latitud ?>">
                 </div>

                <p></p>

                <div class="form-group">
                    <label for="exampleInputEmail1">Longitud</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Direccion" name="longitud" value="<?= $longitud ?>">
                 </div>

                <p></p>

               

                <p></p>

                <img src="<?= $img ?>">

                <p></p>
        		
                <?php

                echo form_input_file('Selecciona una imagen');
        	
                echo form_submit('Actualizar');

        		echo form_close();
        	?>


          
        </div>
      </div>
    </div>

    <hr>