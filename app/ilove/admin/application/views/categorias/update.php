<div class="container" style="margin-top: 8%; margin-left: 15%">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">

            <h1>Actualizar Categoria</h1>

        	<?php
        		
        		echo form_open("usuario/updateCategoria/$id");
        		
        		?>

                <div class="form-group">
                    <label for="exampleInputEmail1">Categoria</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Telefono" name="categoria" value="<?= $nombre ?>">
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
