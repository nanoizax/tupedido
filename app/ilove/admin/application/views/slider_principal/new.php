<div class="container" style="margin-top: 8%; margin-left: 15%">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto col-lg-offset-2 col-md-offset-1">

            <h1>Registrar nueva Imagen.</h1>

        	<?php
        	
        	    echo form_open_multipart("usuario/insertSliderPrincipal");
        		
                echo form_input_file('Selecciona una imagen');
        	
                echo form_submit('Guardar Imagen');

        		echo form_close();
        	?>


          
        </div>
      </div>
    </div>

    <hr>