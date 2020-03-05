<div class="container" style="margin-top: 8%; margin-left: 15%">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">

            <h1>Registrar nuevos clientes</h1>

        	<?php
        		
        		echo form_open("usuario/insert");
        		
        		echo form_input_text('nombres', 'Ingresa nombres');

                echo form_input_text('sexo', 'Ingrese sexo');

                echo form_input_text('email', 'Ingrese email');

                echo form_input_text('password', 'Ingrese Contraseña');
        	
                echo form_submit('Guardar cliente');

        		echo form_close();
        	?>
          
        </div>
      </div>
    </div>

    <hr>