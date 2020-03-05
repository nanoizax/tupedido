<div class="container" style="margin-top: 8%; margin-left: 15%">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto col-lg-offset-2 col-md-offset-1">

            <h1>Registrar nuevos producto.</h1>

        	<?php
        		
        		echo form_open_multipart("usuario/insertProducto");

        		echo form_input_text('nombre', 'Ingresa Nombre');

                echo form_input_text('latitud', 'Ingrese Latitud');

                echo form_input_text('longitud', 'Ingrese Longitud');

                echo form_input_file('Selecciona una imagen');
        	
                echo form_submit('Guardar producto');

        		echo form_close();
        	?>


          
        </div>
      </div>
    </div>

    <hr>