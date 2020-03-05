<div class="container" style="margin-top: 8%; margin-left: 15%">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">

            <h1>Crear una nueva Categoria</h1>

        	<?php
        		
        		echo form_open("usuario/insertCategoria");
        		
        		echo form_input_text('nombre', 'Ingresa Nombre de la Categoria');
        	
                echo form_submit('Guardar cliente');

        		echo form_close();
        	?>
          
        </div>
      </div>
    </div>

    <hr>