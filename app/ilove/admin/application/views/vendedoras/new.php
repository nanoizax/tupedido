<div class="container" style="margin-top: 5%; margin-left: 15%">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">

            <h1>Registrar nuevos vendedores</h1>

        	<?php
        		
        		echo form_open("usuario/insert_vendedora");
        		
        		echo form_input_text('tipo', 'Ingresa Tipo de vendedor (Oficina o Freelancer)');
        		
        		echo form_input_text('nombres', 'Ingrese nombres');
        	
            	echo form_input_text('apellidos', 'Ingrese apellidos');

        		echo form_input_text('DNI', 'Ingrese DNI');

                echo form_input_text('correo', 'Ingrese Correo');

                echo form_input_text('telefono', 'Ingrese Telefono');

                echo form_input_text('ciudad', 'Ingrese Ciudad');

                echo form_submit('Guardar cliente');

        		echo form_close();
        	?>
        	
        	

 <form action="<?php echo base_url(); ?>usuario/guardar_horario" method="POST" enctype="multipart/form-data">


     <div class="form-group">
         <label>Seleccione un xlxs</label>
         <input type="file" name="file" id="file" accept=".xlsx" class="form-control" > 
      </div>


                <div class="form-group">

                    <button class="btn btn-primary" type="submit" id="Ingresar" name="Ingresar" class="btn bg-aqua">Guardar</button>
            
                </div>
            </div>

  </form>


          
        </div>
      </div>
    </div>

    <hr>
    
    
    